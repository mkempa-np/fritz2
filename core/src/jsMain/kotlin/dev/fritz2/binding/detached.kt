package dev.fritz2.binding

import dev.fritz2.flow.asSharedFlow
import dev.fritz2.lenses.IdProvider
import dev.fritz2.lenses.Lens
import dev.fritz2.lenses.elementLens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.*

/**
 * creates a new [DetachedStore]
 *
 * @param lens describes, which part of the parent's model a [DetachedStore] is created for
 */
fun <T, X> Store<T>.detach(lens: Lens<T, X>) = DetachedStore(this, lens)

/**
 * creates a new [DetachedStore]s
 *
 * @param element describes, which element of the parent's [List] a [DetachedStore] is created for
 * @param idProvider function to derive a unique id from an instance
 */
fun <T, I> Store<List<T>>.detach(element: T, idProvider: IdProvider<T, I>) =
    DetachedStore(this, elementLens(element, idProvider))


/**
 * A Sub-[Store] that is detached from its parent, i.e. it does not forward updates upstream
 * (but receives and forwards downstream updates).
 * This can be useful, when you want to address a [Handler] different from update at your RootStore
 * to deal with new values of this sub-model (or below).
 *
 * @property parent parent [Store]
 * @property lens definition, which sub-model is represented by this [Store]
 */
@Suppress("UNCHECKED_CAST")
class DetachedStore<T, P>(private val parent: Store<P>, private val lens: Lens<P, T>) :
    Store<T>, CoroutineScope by MainScope() {
    val state: MutableStateFlow<T> = MutableStateFlow(null as T)

    init {
        parent.data.take(1).onEach {
            state.value = lens.get(it)
        }.launchIn(this)
    }

    /**
     * defines how to infer the id of the sub-part from the parent's id.
     */
    override val id: String by lazy { "${parent.id}.${lens.id}".trimEnd('.') }

    /**
     * Since a [SubStore] is just a view on a [RootStore] holding the real value, it forwards the [Update] to it, using it's [Lens] to transform it.
     */
    override suspend fun enqueue(update: QueuedUpdate<T>) {
        state.value = update.update(state.value)
    }

    /**
     * a [SimpleHandler] that just takes the given action-value as the new value for the [Store].
     */
    override val update = handle<T> { _, newValue -> newValue }

    /**
     * a [SimpleHandler] that commits the current value to the parent [Store].
     */
    val commit = handle { value ->
        parent.enqueue(QueuedUpdate({ lens.set(it, value) }, parent::errorHandler))
        value
    }

    /**
     * the current value of the [DetachedStore] is derived from the data of it's parent using the given [Lens].
     */
    override val data: Flow<T> = parent.data.map {
        lens.get(it)
    }.distinctUntilChanged().asSharedFlow()

    /**
     * creates a new [SubStore] using this one as it's parent.
     *
     * @param lens a [Lens] describing which part to create the [SubStore] for
     */
    fun <X> sub(lens: Lens<T, X>): SubStore<T, T, X> =
        SubStore(this, lens, this, lens)

    /**
     * the current value of the [DetachedStore] is derived from the data of it's parent using the given [Lens].
     */
    val detached: Flow<T> = state

    /**
     * calls a handler on each new detached value of the [Store]
     */
    override fun syncBy(handler: Handler<Unit>) {
        detached.drop(1).map { Unit } handledBy handler
    }

    /**
     * calls a handler on each new detached value of the [Store]
     */
    override fun syncBy(handler: Handler<T>) {
        detached.drop(1) handledBy handler
    }

}