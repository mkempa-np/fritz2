package dev.fritz2.components

import dev.fritz2.dom.html.Div
import dev.fritz2.dom.html.HtmlElements
import dev.fritz2.styling.params.FlexStyleParams
import dev.fritz2.styling.params.Style
import dev.fritz2.styling.params.plus
import dev.fritz2.styling.theme.Property
import dev.fritz2.styling.theme.theme


fun HtmlElements.Stack(
    spacing: Property = theme().space.normal,
    reverse: Boolean = false,
    styles: Style<FlexStyleParams> = {},
    init: Div.() -> Unit
): Div {
    val stackStyles: Style<FlexStyleParams> = {
        if (reverse) {
            direction { columnReverse }
            children(":not(:first-child)") {
                margins { bottom { spacing } }
            }
        } else {
            direction { column }
            children(":not(:first-child)") {
                margins { top { spacing } }
            }
        }
        alignItems { center }
    }

    return Flex(stackStyles + styles, init)
}

fun HtmlElements.Group(
    spacing: Property = theme().space.normal,
    reverse: Boolean = false,
    styles: Style<FlexStyleParams> = {},
    init: Div.() -> Unit
): Div {
    val stackStyles: Style<FlexStyleParams> = {
        if (reverse) {
            direction { rowReverse }
            children(":not(:first-child)") {
                margins { right { spacing } }
            }
        } else {
            direction { row }
            children(":not(:first-child)") {
                margins { left { spacing } }
            }
        }
        alignItems { center }
    }

    return Flex(stackStyles + styles, init)
}
