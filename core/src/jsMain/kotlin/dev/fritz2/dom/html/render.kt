package dev.fritz2.dom.html

import dev.fritz2.dom.Tag
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.w3c.dom.Element

/**
 *  creates a render context for [Tag]s. It should only contain
 *  one root [Tag] like [Div] otherwise a [MultipleRootElementsException]
 *  will be thrown.
 *
 *  @throws MultipleRootElementsException if more then one root [Tag] is defined in [content]
 *  @param content html [Tag] elements to render
 */
fun <E : Element> render(parentjob: Job? = null, content: HtmlElements.() -> Tag<E>) =
    content(object : HtmlElements {
        override val job = Job(parentjob)

        init {
            console.log("... created job $job with parent $parentjob")
        }

        var alreadyRegistered: Boolean = false

        override fun <X : Element, T : Tag<X>> register(element: T, content: (T) -> Unit): T {
            if (alreadyRegistered) {
                throw MultipleRootElementsException(
                    "You can have only one root-tag per html-context!"
                )
            } else {
                content(element)
                alreadyRegistered = true
                return element
            }
        }
    })

/**
 * convenience-method to easily map each value to a [Tag]
 *
 * @param mapper maps a value to a [Tag]
 */
fun <X, E : Element> Flow<X>.render(mapper: HtmlElements.(X) -> Tag<E>): Flow<Tag<E>> {
    return this.map { data ->
        dev.fritz2.dom.html.render {
            mapper(data)
        }
    }
}

/**
 * occurs when more then one root [Tag] is defined in a [render] context
 *
 * @param message exception message text
 */
class MultipleRootElementsException(message: String) : RuntimeException(message)