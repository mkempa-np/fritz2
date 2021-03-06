package dev.fritz2.components

import dev.fritz2.dom.Tag
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.styling.StyleClass
import dev.fritz2.styling.StyleClass.Companion.plus
import dev.fritz2.styling.params.BasicParams
import dev.fritz2.styling.staticStyle
import dev.fritz2.styling.theme.IconDefinition
import dev.fritz2.styling.theme.Icons
import dev.fritz2.styling.theme.theme
import kotlinx.browser.document
import kotlinx.coroutines.Job
import org.w3c.dom.svg.SVGElement

const val xmlns = "http://www.w3.org/2000/svg"

fun createIconSvgElement(baseClass: String?): SVGElement {
    val elem = document.createElementNS(xmlns, "svg").unsafeCast<SVGElement>()
    baseClass?.let { elem.setAttributeNS(null, "class", it) }
    return elem
}

class Svg(
    id: String? = null,
    baseClass: String? = null,
    override val domNode: SVGElement = createIconSvgElement(baseClass),
    job: Job
) : Tag<SVGElement>(domNode = domNode, tagName = "", id = id, job = job)


fun RenderContext.svg(baseClass: String?, id: String?, init: Svg.() -> Unit): Svg {
    return register(Svg(id = id, baseClass = baseClass, job = job), init)
}

/**
 * Class for configuring the appearance of an icon.
 *
 * An [IconDefinition] _must_ be provided in order to render an icon. This definition wraps the pure SVG markup together
 * with additional properties like the display-name and the viewbox.
 *
 * In order to provide a comfortable way to use the predefined icons from the [dev.fritz2.styling.theme.Theme],
 * use the [IconComponent.fromTheme] method.
 */
class IconComponent {
    companion object {
        const val prefix = "icon"
        val staticCss = staticStyle(
            prefix,
            """
                width: 1.25rem;
                height: 1.25rem;
                color: currentColor;
                display: inline-block;
                vertical-align: middle;
                flex-shrink: 0;
                backface-visibility: hidden;
            """
        )
    }

    var def: IconDefinition? = null

    fun fromTheme(value: Icons.() -> IconDefinition) {
        def = theme().icons.value()
    }
}


/**
 * This component enables to render an icon. It basically wraps raw SVG images into a nicer API.
 *
 * fritz2's default theme offers some basic predefined icons, have a look at [dev.fritz2.styling.theme.Theme.icons].
 *
 * Every icon must be wrapped inside an [IconDefinition], that acts as a value class for the raw SVG markup.
 *
 * ```
 * icon { fromTheme { fritz2 } }
 * //     ^^^^^^^^^
 *        convenient function for easily set the predefined icons from the theme
 *
 * // style the icon with the fritz2 styling DSL like any other component:
 * icon({
 *      color { "purple" }
 *      size { "10rem" }
 *      hover { color { warning } }
 * }) { fromTheme { fritz2 } }
 * ```
 *
 * If you want to use a custom icon, just put the definition inside an [IconDefinition] object and pass the latter
 * into the icon component:
 * ```
 * icon({
 *     size { large }
 * }) {
 *     def = IconDefinition(
 *         displayName = "kotlin",
 *         viewBox = "0 0 60 60",
 *         svg = """
 *         <g>
 *                 <linearGradient id="XMLID_3_" gradientUnits="userSpaceOnUse" x1="15.9594" y1="-13.0143" x2="44.3068" y2="15.3332" gradientTransform="matrix(1 0 0 -1 0 61)">
 *                 <stop  offset="9.677000e-02" style="stop-color:#0095D5"/>
 *                 <stop  offset="0.3007" style="stop-color:#238AD9"/>
 *                 <stop  offset="0.6211" style="stop-color:#557BDE"/>
 *                 <stop  offset="0.8643" style="stop-color:#7472E2"/>
 *                 <stop  offset="1" style="stop-color:#806EE3"/>
 *             </linearGradient>
 *             <polygon id="XMLID_2_" style="fill:url(#XMLID_3_);" points="0,60 30.1,29.9 60,60 	"/>
 *
 *                 <linearGradient id="SVGID_1_" gradientUnits="userSpaceOnUse" x1="4.2092" y1="48.9409" x2="20.6734" y2="65.405" gradientTransform="matrix(1 0 0 -1 0 61)">
 *                 <stop  offset="0.1183" style="stop-color:#0095D5"/>
 *                 <stop  offset="0.4178" style="stop-color:#3C83DC"/>
 *                 <stop  offset="0.6962" style="stop-color:#6D74E1"/>
 *                 <stop  offset="0.8333" style="stop-color:#806EE3"/>
 *             </linearGradient>
 *             <polygon style="fill:url(#SVGID_1_);" points="0,0 30.1,0 0,32.5 	"/>
 *
 *                 <linearGradient id="SVGID_2_" gradientUnits="userSpaceOnUse" x1="-10.1017" y1="5.8362" x2="45.7315" y2="61.6694" gradientTransform="matrix(1 0 0 -1 0 61)">
 *                 <stop  offset="0.1075" style="stop-color:#C757BC"/>
 *                 <stop  offset="0.2138" style="stop-color:#D0609A"/>
 *                 <stop  offset="0.4254" style="stop-color:#E1725C"/>
 *                 <stop  offset="0.6048" style="stop-color:#EE7E2F"/>
 *                 <stop  offset="0.743" style="stop-color:#F58613"/>
 *                 <stop  offset="0.8232" style="stop-color:#F88909"/>
 *             </linearGradient>
 *             <polygon style="fill:url(#SVGID_2_);" points="30.1,0 0,31.7 0,60 30.1,29.9 60,0 	"/>
 *         </g>
 *     """.trimIndent()
 *     )
 * }
 * ```
 * The above example will render quite a big Kotlin logo :-)
 * Of course you should consider to _add_ the definition inside your own theme or to a central place within your
 * application in order to make it _reusable_!
 *
 * @see IconComponent
 *
 * @param styling a lambda expression for declaring the styling as fritz2's styling DSL
 * @param baseClass optional CSS class that should be applied to the element
 * @param id the ID of the element
 * @param prefix the prefix for the generated CSS class resulting in the form ``$prefix-$hash``
 * @param build a lambda expression for setting up the component itself. Details in [IconComponent]
 */
fun RenderContext.icon(
    styling: BasicParams.() -> Unit = {},
    baseClass: StyleClass? = null,
    id: String? = null,
    prefix: String = IconComponent.prefix,
    build: IconComponent.() -> Unit = {}
) {
    val component = IconComponent().apply(build)

    component.def?.let {
        (::svg.styled(baseClass + IconComponent.staticCss, id, prefix) {
            styling()
        }) {
            domNode.setAttributeNS(null, "viewBox", it.viewBox)
            domNode.setAttributeNS(null, "focusable", "false")
            domNode.setAttributeNS(null, "role", "presentation")
            domNode.innerHTML = it.svg
        }
    }
}


