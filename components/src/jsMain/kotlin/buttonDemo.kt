import dev.fritz2.binding.RootStore
import dev.fritz2.binding.handledBy
import dev.fritz2.binding.watch
import dev.fritz2.components.Flex
import dev.fritz2.components.LineUp
import dev.fritz2.components.StackUp
import dev.fritz2.components.buttons.ClickButton
import dev.fritz2.dom.html.Div
import dev.fritz2.dom.html.HtmlElements
import dev.fritz2.tracking.tracker
import kotlinx.browser.window
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay

@ExperimentalCoroutinesApi
fun HtmlElements.buttonDemo(theme: ExtendedTheme): Div {

    val buttonStore = object : RootStore<String>("") {
        val loading = tracker()

        val showMsg = handle { model ->
            loading.track("running...") {
                delay(30000)
                window.alert("geclickt")
            }
            model
        }

    }

    buttonStore.watch()

    return div {
        Flex({
            direction { column }
            padding { normal }
        }) {
            h1 { +"Button Showcase" }

            StackUp {
                LineUp {
                    ClickButton("save") handledBy buttonStore.showMsg
                    ClickButton("save", buttonStore.loading) handledBy buttonStore.showMsg
                    ClickButton("save", buttonStore.loading, "saving...") handledBy buttonStore.showMsg
                }

                LineUp {
                    ClickButton(theme.icons.arrowUp) handledBy buttonStore.showMsg
                    ClickButton(theme.icons.arrowUp, buttonStore.loading) handledBy buttonStore.showMsg
                }

                LineUp {
                    ClickButton(theme.icons.arrowUp, "save") handledBy buttonStore.showMsg
                    ClickButton(theme.icons.arrowUp, "save", buttonStore.loading) handledBy buttonStore.showMsg
                }

                LineUp {
                    ClickButton("save", theme.icons.arrowUp) handledBy buttonStore.showMsg
                    ClickButton("save", theme.icons.arrowUp, buttonStore.loading) handledBy buttonStore.showMsg
                }

            }
        }
    }
}