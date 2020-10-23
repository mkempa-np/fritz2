package dev.fritz2.dom.html

import dev.fritz2.dom.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import org.w3c.dom.*


/**
 * Exposes the JavaScript [HTMLAnchorElement](https://developer.mozilla.org/en/docs/Web/API/HTMLAnchorElement) to Kotlin
 */
open class A(id: String? = null, baseClass: String? = null, job: Job) : Tag<HTMLAnchorElement>("a", id, baseClass, job),
    WithText<HTMLAnchorElement> {
    var target: Flow<String> by AttributeDelegate
    var download: Flow<String> by AttributeDelegate
    var ping: Flow<String> by AttributeDelegate
    var rel: Flow<String> by AttributeDelegate
    var hreflang: Flow<String> by AttributeDelegate
    var type: Flow<String> by AttributeDelegate
    var text: Flow<String> by AttributeDelegate
    var referrerPolicy: Flow<String> by AttributeDelegate
    var href: Flow<String> by AttributeDelegate
    var protocol: Flow<String> by AttributeDelegate
    var username: Flow<String> by AttributeDelegate
    var password: Flow<String> by AttributeDelegate
    var host: Flow<String> by AttributeDelegate
    var hostname: Flow<String> by AttributeDelegate
    var port: Flow<String> by AttributeDelegate
    var pathname: Flow<String> by AttributeDelegate
    var search: Flow<String> by AttributeDelegate
    var hash: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLAreaElement](https://developer.mozilla.org/en/docs/Web/API/HTMLAreaElement) to Kotlin
 */
open class Area(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLAreaElement>("area", id, baseClass, job),
    WithText<HTMLAreaElement> {
    var alt: Flow<String> by AttributeDelegate
    var coords: Flow<String> by AttributeDelegate
    var shape: Flow<String> by AttributeDelegate
    var target: Flow<String> by AttributeDelegate
    var download: Flow<String> by AttributeDelegate
    var ping: Flow<String> by AttributeDelegate
    var rel: Flow<String> by AttributeDelegate
    var referrerPolicy: Flow<String> by AttributeDelegate
    var href: Flow<String> by AttributeDelegate
    var protocol: Flow<String> by AttributeDelegate
    var username: Flow<String> by AttributeDelegate
    var password: Flow<String> by AttributeDelegate
    var host: Flow<String> by AttributeDelegate
    var hostname: Flow<String> by AttributeDelegate
    var port: Flow<String> by AttributeDelegate
    var pathname: Flow<String> by AttributeDelegate
    var search: Flow<String> by AttributeDelegate
    var hash: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLBRElement](https://developer.mozilla.org/en/docs/Web/API/HTMLBRElement) to Kotlin
 */
open class Br(id: String? = null, baseClass: String? = null, job: Job) : Tag<HTMLBRElement>("br", id, baseClass, job)


/**
 * Exposes the JavaScript [HTMLButtonElement](https://developer.mozilla.org/en/docs/Web/API/HTMLButtonElement) to Kotlin
 */
open class Button(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLButtonElement>("button", id, baseClass, job),
    WithText<HTMLButtonElement> {
    var autofocus: Flow<Boolean> by BooleanAttributeDelegate
    var disabled: Flow<Boolean> by BooleanAttributeDelegate
    var formAction: Flow<String> by AttributeDelegate
    var formEnctype: Flow<String> by AttributeDelegate
    var formMethod: Flow<String> by AttributeDelegate
    var formNoValidate: Flow<Boolean> by BooleanAttributeDelegate
    var formTarget: Flow<String> by AttributeDelegate
    var name: Flow<String> by AttributeDelegate
    var type: Flow<String> by AttributeDelegate
    var value: Flow<String> by ValueAttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLCanvasElement](https://developer.mozilla.org/en/docs/Web/API/HTMLCanvasElement) to Kotlin
 */
open class Canvas(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLCanvasElement>("canvas", id, baseClass, job),
    WithText<HTMLCanvasElement> {
    var width: Flow<Int> by AttributeDelegate
    var height: Flow<Int> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLDListElement](https://developer.mozilla.org/en/docs/Web/API/HTMLDListElement) to Kotlin
 */
open class Dl(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLDListElement>("dl", id, baseClass, job),
    WithText<HTMLDListElement>


/**
 * Exposes the JavaScript [HTMLDataElement](https://developer.mozilla.org/en/docs/Web/API/HTMLDataElement) to Kotlin
 */
open class Data(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLDataElement>("data", id, baseClass, job),
    WithText<HTMLDataElement> {
    var value: Flow<String> by ValueAttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLDataListElement](https://developer.mozilla.org/en/docs/Web/API/HTMLDataListElement) to Kotlin
 */
open class DataList(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLDataListElement>("datalist", id, baseClass, job),
    WithText<HTMLDataListElement>


/**
 * Exposes the JavaScript [HTMLDetailsElement](https://developer.mozilla.org/en/docs/Web/API/HTMLDetailsElement) to Kotlin
 */
open class Details(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLDetailsElement>("details", id, baseClass, job),
    WithText<HTMLDetailsElement> {
    var open: Flow<Boolean> by BooleanAttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLDialogElement](https://developer.mozilla.org/en/docs/Web/API/HTMLDialogElement) to Kotlin
 */
open class Dialog(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLDialogElement>("dialog", id, baseClass, job),
    WithText<HTMLDialogElement> {
    var open: Flow<Boolean> by BooleanAttributeDelegate
    var returnValue: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLDivElement](https://developer.mozilla.org/en/docs/Web/API/HTMLDivElement) to Kotlin
 */
open class Div(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLDivElement>("div", id, baseClass, job),
    WithText<HTMLDivElement> {
    var align: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLDivElement](https://developer.mozilla.org/en/docs/Web/API/HTMLDivElement) to Kotlin
 */
open class Embed(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLEmbedElement>("embed", id, baseClass, job) {
    var src: Flow<String> by AttributeDelegate
    var type: Flow<String> by AttributeDelegate
    var width: Flow<String> by AttributeDelegate
    var height: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLFieldSetElement](https://developer.mozilla.org/en/docs/Web/API/HTMLFieldSetElement) to Kotlin
 */
open class FieldSet(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLFieldSetElement>("fieldSet", id, baseClass, job) {
    var disabled: Flow<Boolean> by BooleanAttributeDelegate
    var name: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLFormElement](https://developer.mozilla.org/en/docs/Web/API/`for`mElement) to Kotlin
 */
open class Form(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLFormElement>("form", id, baseClass, job),
    WithText<HTMLFormElement> {
    var acceptCharset: Flow<String> by AttributeDelegate
    var action: Flow<String> by AttributeDelegate
    var autocomplete: Flow<String> by AttributeDelegate
    var enctype: Flow<String> by AttributeDelegate
    var encoding: Flow<String> by AttributeDelegate
    var method: Flow<String> by AttributeDelegate
    var name: Flow<String> by AttributeDelegate
    var noValidate: Flow<Boolean> by BooleanAttributeDelegate
    var target: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLHRElement](https://developer.mozilla.org/en/docs/Web/API/HTMLHRElement) to Kotlin
 */
open class Hr(id: String? = null, baseClass: String? = null, job: Job) : Tag<HTMLHRElement>("hr", id, baseClass, job)


/**
 * Exposes the JavaScript [HTMLHeadingElement](https://developer.mozilla.org/en/docs/Web/API/HTMLHeadingElement) to Kotlin
 */
open class H(num: Int, id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLHeadingElement>("h$num", id, baseClass, job),
    WithText<HTMLHeadingElement>


/**
 * Exposes the JavaScript [HTMLIFrameElement](https://developer.mozilla.org/en/docs/Web/API/HTMLIFrameElement) to Kotlin
 */
open class IFrame(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLIFrameElement>("iframe", id, baseClass, job),
    WithText<HTMLIFrameElement> {
    var src: Flow<String> by AttributeDelegate
    var srcdoc: Flow<String> by AttributeDelegate
    var name: Flow<String> by AttributeDelegate
    var allowFullscreen: Flow<Boolean> by BooleanAttributeDelegate
    var allowUserMedia: Flow<Boolean> by BooleanAttributeDelegate
    var width: Flow<String> by AttributeDelegate
    var height: Flow<String> by AttributeDelegate
    var referrerPolicy: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLImageElement](https://developer.mozilla.org/en/docs/Web/API/HTMLImageElement) to Kotlin
 */
open class Img(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLImageElement>("img", id, baseClass, job),
    WithText<HTMLImageElement> {
    var alt: Flow<String> by AttributeDelegate
    var src: Flow<String> by AttributeDelegate
    var srcset: Flow<String> by AttributeDelegate
    var sizes: Flow<String> by AttributeDelegate
    var crossOrigin: Flow<String> by AttributeDelegate
    var useMap: Flow<String> by AttributeDelegate
    var isMap: Flow<Boolean> by BooleanAttributeDelegate
    var width: Flow<Int> by AttributeDelegate
    var height: Flow<Int> by AttributeDelegate
    var referrerPolicy: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLInputElement](https://developer.mozilla.org/en/docs/Web/API/HTMLInputElement) to Kotlin
 */
open class Input(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLInputElement>("input", id, baseClass, job) {
    var accept: Flow<String> by AttributeDelegate
    var alt: Flow<String> by AttributeDelegate
    var autocomplete: Flow<String> by AttributeDelegate
    var autofocus: Flow<Boolean> by BooleanAttributeDelegate
    var defaultChecked: Flow<Boolean> by BooleanAttributeDelegate
    var checked: Flow<Boolean> by CheckedAttributeDelegate
    var dirName: Flow<String> by AttributeDelegate
    var disabled: Flow<Boolean> by BooleanAttributeDelegate
    var formAction: Flow<String> by AttributeDelegate
    var formEnctype: Flow<String> by AttributeDelegate
    var formMethod: Flow<String> by AttributeDelegate
    var formNoValidate: Flow<Boolean> by BooleanAttributeDelegate
    var formTarget: Flow<String> by AttributeDelegate
    var height: Flow<Int> by AttributeDelegate
    var indeterminate: Flow<Boolean> by BooleanAttributeDelegate
    var inputMode: Flow<String> by AttributeDelegate
    var max: Flow<String> by AttributeDelegate
    var maxLength: Flow<Int> by AttributeDelegate
    var min: Flow<String> by AttributeDelegate
    var minLength: Flow<Int> by AttributeDelegate
    var multiple: Flow<Boolean> by BooleanAttributeDelegate
    var name: Flow<String> by AttributeDelegate
    var pattern: Flow<String> by AttributeDelegate
    var placeholder: Flow<String> by AttributeDelegate
    var readOnly: Flow<Boolean> by BooleanAttributeDelegate
    var required: Flow<Boolean> by BooleanAttributeDelegate
    var size: Flow<Int> by AttributeDelegate
    var src: Flow<String> by AttributeDelegate
    var step: Flow<String> by AttributeDelegate
    var type: Flow<String> by AttributeDelegate
    var defaultValue: Flow<String> by AttributeDelegate
    var value: Flow<String> by ValueAttributeDelegate
    var width: Flow<Int> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLLIElement](https://developer.mozilla.org/en/docs/Web/API/HTMLLIElement) to Kotlin
 */
open class Li(id: String? = null, baseClass: String? = null, job: Job) : Tag<HTMLLIElement>("li", id, baseClass, job),
    WithText<HTMLLIElement> {
    var value: Flow<Int> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLLabelElement](https://developer.mozilla.org/en/docs/Web/API/HTMLLabelElement) to Kotlin
 */
open class Label(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLLabelElement>("label", id, baseClass, job),
    WithText<HTMLLabelElement> {
    var `for`: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLLegendElement](https://developer.mozilla.org/en/docs/Web/API/HTMLLegendElement) to Kotlin
 */
open class Legend(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLLegendElement>("legend", id, baseClass, job),
    WithText<HTMLLegendElement>


/**
 * Exposes the JavaScript [HTMLMapElement](https://developer.mozilla.org/en/docs/Web/API/HTMLMapElement) to Kotlin
 */
open class Map(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLMapElement>("map", id, baseClass, job),
    WithText<HTMLMapElement> {
    var name: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLAudioElement](https://developer.mozilla.org/en/docs/Web/API/HTMLAudioElement) to Kotlin
 */
open class Audio(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLAudioElement>("audio", id, baseClass, job),
    WithText<HTMLAudioElement> {
    var src: Flow<String> by AttributeDelegate
    var preload: Flow<String> by AttributeDelegate
    var currentTime: Flow<Double> by AttributeDelegate
    var defaultPlaybackRate: Flow<Double> by AttributeDelegate
    var playbackRate: Flow<Double> by AttributeDelegate
    var autoplay: Flow<Boolean> by BooleanAttributeDelegate
    var loop: Flow<Boolean> by BooleanAttributeDelegate
    var controls: Flow<Boolean> by BooleanAttributeDelegate
    var volume: Flow<Double> by AttributeDelegate
    var muted: Flow<Boolean> by BooleanAttributeDelegate
    var defaultMuted: Flow<Boolean> by BooleanAttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLVideoElement](https://developer.mozilla.org/en/docs/Web/API/HTMLVideoElement) to Kotlin
 */
open class Video(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLVideoElement>("video", id, baseClass, job),
    WithText<HTMLVideoElement> {
    var width: Flow<Int> by AttributeDelegate
    var height: Flow<Int> by AttributeDelegate
    var poster: Flow<String> by AttributeDelegate
    var playsInline: Flow<Boolean> by BooleanAttributeDelegate
    var src: Flow<String> by AttributeDelegate
    var preload: Flow<String> by AttributeDelegate
    var currentTime: Flow<Double> by AttributeDelegate
    var defaultPlaybackRate: Flow<Double> by AttributeDelegate
    var playbackRate: Flow<Double> by AttributeDelegate
    var autoplay: Flow<Boolean> by BooleanAttributeDelegate
    var loop: Flow<Boolean> by BooleanAttributeDelegate
    var controls: Flow<Boolean> by BooleanAttributeDelegate
    var volume: Flow<Double> by AttributeDelegate
    var muted: Flow<Boolean> by BooleanAttributeDelegate
    var defaultMuted: Flow<Boolean> by BooleanAttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLMeterElement](https://developer.mozilla.org/en/docs/Web/API/HTMLMeterElement) to Kotlin
 */
open class Meter(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLMeterElement>("meter", id, baseClass, job),
    WithText<HTMLMeterElement> {
    var value: Flow<Double> by AttributeDelegate
    var min: Flow<Double> by AttributeDelegate
    var max: Flow<Double> by AttributeDelegate
    var low: Flow<Double> by AttributeDelegate
    var high: Flow<Double> by AttributeDelegate
    var optimum: Flow<Double> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLModElement](https://developer.mozilla.org/en/docs/Web/API/HTMLModElement) to Kotlin
 */
open class Ins(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLModElement>("ins", id, baseClass, job),
    WithText<HTMLModElement> {
    var cite: Flow<String> by AttributeDelegate
    var dateTime: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLModElement](https://developer.mozilla.org/en/docs/Web/API/HTMLModElement) to Kotlin
 */
open class Del(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLModElement>("del", id, baseClass, job),
    WithText<HTMLModElement> {
    var cite: Flow<String> by AttributeDelegate
    var dateTime: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLOListElement](https://developer.mozilla.org/en/docs/Web/API/HTMLOListElement) to Kotlin
 */
open class Ol(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLOListElement>("ol", id, baseClass, job),
    WithText<HTMLOListElement> {
    var reversed: Flow<Boolean> by BooleanAttributeDelegate
    var start: Flow<Int> by AttributeDelegate
    var type: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLObjectElement](https://developer.mozilla.org/en/docs/Web/API/HTMLObjectElement) to Kotlin
 */
open class Object(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLObjectElement>("object", id, baseClass, job),
    WithText<HTMLObjectElement> {
    var data: Flow<String> by AttributeDelegate
    var type: Flow<String> by AttributeDelegate
    var typeMustMatch: Flow<Boolean> by BooleanAttributeDelegate
    var name: Flow<String> by AttributeDelegate
    var useMap: Flow<String> by AttributeDelegate
    var width: Flow<String> by AttributeDelegate
    var height: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLOptGroupElement](https://developer.mozilla.org/en/docs/Web/API/HTMLOptGroupElement) to Kotlin
 */
open class Optgroup(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLOptGroupElement>("optgroup", id, baseClass, job),
    WithText<HTMLOptGroupElement> {
    var disabled: Flow<Boolean> by BooleanAttributeDelegate
    var label: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLOptionElement](https://developer.mozilla.org/en/docs/Web/API/HTMLOptionElement) to Kotlin
 */
open class Option(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLOptionElement>("option", id, baseClass, job),
    WithText<HTMLOptionElement> {
    var disabled: Flow<Boolean> by BooleanAttributeDelegate
    var label: Flow<String> by AttributeDelegate
    var defaultSelected: Flow<Boolean> by BooleanAttributeDelegate
    var selected: Flow<Boolean> by BooleanAttributeDelegate
    var value: Flow<String> by ValueAttributeDelegate
    var text: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLOutputElement](https://developer.mozilla.org/en/docs/Web/API/HTMLOutputElement) to Kotlin
 */
open class Output(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLOutputElement>("output", id, baseClass, job),
    WithText<HTMLOutputElement> {
    var name: Flow<String> by AttributeDelegate
    var defaultValue: Flow<String> by AttributeDelegate
    var value: Flow<String> by ValueAttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLParagraphElement](https://developer.mozilla.org/en/docs/Web/API/HTMLParagraphElement) to Kotlin
 */
open class P(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLParagraphElement>("p", id, baseClass, job),
    WithText<HTMLParagraphElement>


/**
 * Exposes the JavaScript [HTMLParamElement](https://developer.mozilla.org/en/docs/Web/API/HTMLParamElement) to Kotlin
 */
open class Param(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLParamElement>("param", id, baseClass, job),
    WithText<HTMLParamElement> {
    var name: Flow<String> by AttributeDelegate
    var value: Flow<String> by ValueAttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLPictureElement](https://developer.mozilla.org/en/docs/Web/API/HTMLPictureElement) to Kotlin
 */
open class Picture(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLPictureElement>("picture", id, baseClass, job),
    WithText<HTMLPictureElement>


/**
 * Exposes the JavaScript [HTMLPreElement](https://developer.mozilla.org/en/docs/Web/API/HTMLPreElement) to Kotlin
 */
open class Pre(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLPreElement>("pre", id, baseClass, job),
    WithText<HTMLPreElement>


/**
 * Exposes the JavaScript [HTMLProgressElement](https://developer.mozilla.org/en/docs/Web/API/HTMLProgressElement) to Kotlin
 */
open class Progress(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLProgressElement>("progress", id, baseClass, job),
    WithText<HTMLProgressElement> {
    var value: Flow<Double> by AttributeDelegate
    var max: Flow<Double> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLQuoteElement](https://developer.mozilla.org/en/docs/Web/API/HTMLQuoteElement) to Kotlin
 */
open class Quote(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLQuoteElement>("quote", id, baseClass, job),
    WithText<HTMLQuoteElement> {
    var cite: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLScriptElement](https://developer.mozilla.org/en/docs/Web/API/HTMLScriptElement) to Kotlin
 */
open class Script(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLScriptElement>("script", id, baseClass, job) {
    var src: Flow<String> by AttributeDelegate
    var type: Flow<String> by AttributeDelegate
    var charset: Flow<String> by AttributeDelegate
    var async: Flow<Boolean> by BooleanAttributeDelegate
    var defer: Flow<Boolean> by BooleanAttributeDelegate
    var text: Flow<String> by AttributeDelegate
    var nonce: Flow<String> by AttributeDelegate
    var event: Flow<String> by AttributeDelegate
    var `for`: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLSelectElement](https://developer.mozilla.org/en/docs/Web/API/HTMLSelectElement) to Kotlin
 */
open class Select(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLSelectElement>("select", id, baseClass, job) {
    var autocomplete: Flow<String> by AttributeDelegate
    var autofocus: Flow<Boolean> by BooleanAttributeDelegate
    var disabled: Flow<Boolean> by BooleanAttributeDelegate
    var multiple: Flow<Boolean> by BooleanAttributeDelegate
    var name: Flow<String> by AttributeDelegate
    var required: Flow<Boolean> by BooleanAttributeDelegate
    var size: Flow<Int> by AttributeDelegate
    var length: Flow<Int> by AttributeDelegate
    var selectedIndex: Flow<Int> by AttributeDelegate
    var value: Flow<String> by ValueAttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLSpanElement](https://developer.mozilla.org/en/docs/Web/API/HTMLSpanElement) to Kotlin
 */
open class Span(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLSpanElement>("span", id, baseClass, job),
    WithText<HTMLSpanElement>


/**
 * Exposes the JavaScript [HTMLTableCaptionElement](https://developer.mozilla.org/en/docs/Web/API/HTMLTableCaptionElement) to Kotlin
 */
open class Caption(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLTableCaptionElement>("caption", id, baseClass, job),
    WithText<HTMLTableCaptionElement>


/**
 * Exposes the JavaScript [HTMLTableCellElement](https://developer.mozilla.org/en/docs/Web/API/HTMLTableCellElement) to Kotlin
 */
open class Th(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLTableCellElement>("th", id, baseClass, job),
    WithText<HTMLTableCellElement> {
    var colSpan: Flow<Int> by AttributeDelegate
    var rowSpan: Flow<Int> by AttributeDelegate
    var headers: Flow<String> by AttributeDelegate
    var scope: Flow<String> by AttributeDelegate
    var abbr: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLTableCellElement](https://developer.mozilla.org/en/docs/Web/API/HTMLTableCellElement) to Kotlin
 */
open class Td(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLTableCellElement>("td", id, baseClass, job),
    WithText<HTMLTableCellElement> {
    var colSpan: Flow<Int> by AttributeDelegate
    var rowSpan: Flow<Int> by AttributeDelegate
    var headers: Flow<String> by AttributeDelegate
    var scope: Flow<String> by AttributeDelegate
    var abbr: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLTableColElement](https://developer.mozilla.org/en/docs/Web/API/HTMLTableColElement) to Kotlin
 */
open class Col(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLTableColElement>("col", id, baseClass, job),
    WithText<HTMLTableColElement> {
    var span: Flow<Int> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLTableColElement](https://developer.mozilla.org/en/docs/Web/API/HTMLTableColElement) to Kotlin
 */
open class Colgroup(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLTableColElement>("colgroup", id, baseClass, job),
    WithText<HTMLTableColElement> {
    var span: Flow<Int> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLTableElement](https://developer.mozilla.org/en/docs/Web/API/HTMLTableElement) to Kotlin
 */
open class Table(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLTableElement>("table", id, baseClass, job)


/**
 * Exposes the JavaScript [HTMLTableRowElement](https://developer.mozilla.org/en/docs/Web/API/HTMLTableRowElement) to Kotlin
 */
open class Tr(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLTableRowElement>("tr", id, baseClass, job),
    WithText<HTMLTableRowElement>


/**
 * Exposes the JavaScript [HTMLTableSectionElement](https://developer.mozilla.org/en/docs/Web/API/HTMLTableSectionElement) to Kotlin
 */
open class TFoot(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLTableSectionElement>("tfoot", id, baseClass, job)


/**
 * Exposes the JavaScript [HTMLTableSectionElement](https://developer.mozilla.org/en/docs/Web/API/HTMLTableSectionElement) to Kotlin
 */
open class THead(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLTableSectionElement>("thead", id, baseClass, job)


/**
 * Exposes the JavaScript [HTMLTableSectionElement](https://developer.mozilla.org/en/docs/Web/API/HTMLTableSectionElement) to Kotlin
 */
open class TBody(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLTableSectionElement>("tbody", id, baseClass, job)


/**
 * Exposes the JavaScript [HTMLTextAreaElement](https://developer.mozilla.org/en/docs/Web/API/HTMLTextAreaElement) to Kotlin
 */
open class TextArea(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLTextAreaElement>("textarea", id, baseClass, job),
    WithText<HTMLTextAreaElement> {
    var autocomplete: Flow<String> by AttributeDelegate
    var autofocus: Flow<Boolean> by BooleanAttributeDelegate
    var cols: Flow<Int> by AttributeDelegate
    var dirName: Flow<String> by AttributeDelegate
    var disabled: Flow<Boolean> by BooleanAttributeDelegate
    var inputMode: Flow<String> by AttributeDelegate
    var maxLength: Flow<Int> by AttributeDelegate
    var minLength: Flow<Int> by AttributeDelegate
    var name: Flow<String> by AttributeDelegate
    var placeholder: Flow<String> by AttributeDelegate
    var readOnly: Flow<Boolean> by BooleanAttributeDelegate
    var required: Flow<Boolean> by BooleanAttributeDelegate
    var rows: Flow<Int> by AttributeDelegate
    var wrap: Flow<String> by AttributeDelegate
    var defaultValue: Flow<String> by AttributeDelegate
    var value: Flow<String> by ValueAttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLTimeElement](https://developer.mozilla.org/en/docs/Web/API/HTMLTimeElement) to Kotlin
 */
open class Time(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLTimeElement>("time", id, baseClass, job),
    WithText<HTMLTimeElement> {
    var dateTime: Flow<String> by AttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLTrackElement](https://developer.mozilla.org/en/docs/Web/API/HTMLTrackElement) to Kotlin
 */
open class Track(id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLTrackElement>("track", id, baseClass, job),
    WithText<HTMLTrackElement> {
    var kind: Flow<String> by AttributeDelegate
    var src: Flow<String> by AttributeDelegate
    var srclang: Flow<String> by AttributeDelegate
    var label: Flow<String> by AttributeDelegate
    var default: Flow<Boolean> by BooleanAttributeDelegate
}


/**
 * Exposes the JavaScript [HTMLUListElement](https://developer.mozilla.org/en/docs/Web/API/HTMLUListElement) to Kotlin
 */
open class Ul(id: String? = null, baseClass: String? = null, job: Job) : Tag<HTMLUListElement>("ul", id, baseClass, job)


/**
 * General class for standard html5 elements
 */
open class TextElement(tagName: String, id: String? = null, baseClass: String? = null, job: Job) :
    Tag<HTMLElement>(tagName, id, baseClass, job), WithText<HTMLElement>


interface HtmlElements {
    val job: Job

    fun custom(
        localName: String,
        baseClass: String? = null,
        id: String? = null,
        content: Tag<HTMLElement>.() -> Unit
    ): Tag<HTMLElement> =
        register(Tag(localName, id, baseClass, job), content)

    fun <X : Element, T : Tag<X>> register(element: T, content: (T) -> Unit): T
    fun a(baseClass: String? = null, id: String? = null, content: A.() -> Unit): A =
        register(A(id, baseClass, job), content)

    fun area(baseClass: String? = null, id: String? = null, content: Area.() -> Unit): Area =
        register(Area(id, baseClass, job), content)

    fun br(baseClass: String? = null, id: String? = null, content: Br.() -> Unit): Br =
        register(Br(id, baseClass, job), content)

    fun button(baseClass: String? = null, id: String? = null, content: Button.() -> Unit): Button =
        register(Button(id, baseClass, job), content)

    fun canvas(baseClass: String? = null, id: String? = null, content: Canvas.() -> Unit): Canvas =
        register(Canvas(id, baseClass, job), content)

    fun dl(baseClass: String? = null, id: String? = null, content: Dl.() -> Unit): Dl =
        register(Dl(id, baseClass, job), content)

    fun dt(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("dt", id, baseClass, job), content)

    fun dd(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("dd", id, baseClass, job), content)

    fun data(baseClass: String? = null, id: String? = null, content: Data.() -> Unit): Data =
        register(Data(id, baseClass, job), content)

    fun datalist(baseClass: String? = null, id: String? = null, content: DataList.() -> Unit): DataList =
        register(DataList(id, baseClass, job), content)

    fun details(baseClass: String? = null, id: String? = null, content: Details.() -> Unit): Details =
        register(Details(id, baseClass, job), content)

    fun dialog(baseClass: String? = null, id: String? = null, content: Dialog.() -> Unit): Dialog =
        register(Dialog(id, baseClass, job), content)

    fun div(baseClass: String? = null, id: String? = null, content: Div.() -> Unit): Div =
        register(Div(id, baseClass, job), content)

    fun embed(baseClass: String? = null, id: String? = null, content: Embed.() -> Unit): Embed =
        register(Embed(id, baseClass, job), content)

    fun fieldset(baseClass: String? = null, id: String? = null, content: FieldSet.() -> Unit): FieldSet =
        register(FieldSet(id, baseClass, job), content)

    fun form(baseClass: String? = null, id: String? = null, content: Form.() -> Unit): Form =
        register(Form(id, baseClass, job), content)

    fun hr(baseClass: String? = null, id: String? = null, content: Hr.() -> Unit): Hr =
        register(Hr(id, baseClass, job), content)

    fun h1(baseClass: String? = null, id: String? = null, content: H.() -> Unit): H =
        register(H(1, id, baseClass, job), content)

    fun h2(baseClass: String? = null, id: String? = null, content: H.() -> Unit): H =
        register(H(2, id, baseClass, job), content)

    fun h3(baseClass: String? = null, id: String? = null, content: H.() -> Unit): H =
        register(H(3, id, baseClass, job), content)

    fun h4(baseClass: String? = null, id: String? = null, content: H.() -> Unit): H =
        register(H(4, id, baseClass, job), content)

    fun h5(baseClass: String? = null, id: String? = null, content: H.() -> Unit): H =
        register(H(5, id, baseClass, job), content)

    fun h6(baseClass: String? = null, id: String? = null, content: H.() -> Unit): H =
        register(H(6, id, baseClass, job), content)

    fun iframe(baseClass: String? = null, id: String? = null, content: IFrame.() -> Unit): IFrame =
        register(IFrame(id, baseClass, job), content)

    fun img(baseClass: String? = null, id: String? = null, content: Img.() -> Unit): Img =
        register(Img(id, baseClass, job), content)

    fun input(baseClass: String? = null, id: String? = null, content: Input.() -> Unit): Input =
        register(Input(id, baseClass, job), content)

    fun li(baseClass: String? = null, id: String? = null, content: Li.() -> Unit): Li =
        register(Li(id, baseClass, job), content)

    fun label(baseClass: String? = null, id: String? = null, `for`: String? = null, content: Label.() -> Unit): Label {
        val label = Label(id, baseClass, job)
        if (`for` != null) label.domNode.setAttribute("for", `for`)
        return register(label, content)
    }

    fun legend(baseClass: String? = null, id: String? = null, content: Legend.() -> Unit): Legend =
        register(Legend(id, baseClass, job), content)

    fun map(baseClass: String? = null, id: String? = null, content: Map.() -> Unit): Map =
        register(Map(id, baseClass, job), content)

    fun audio(baseClass: String? = null, id: String? = null, content: Audio.() -> Unit): Audio =
        register(Audio(id, baseClass, job), content)

    fun video(baseClass: String? = null, id: String? = null, content: Video.() -> Unit): Video =
        register(Video(id, baseClass, job), content)

    fun meter(baseClass: String? = null, id: String? = null, content: Meter.() -> Unit): Meter =
        register(Meter(id, baseClass, job), content)

    fun ins(baseClass: String? = null, id: String? = null, content: Ins.() -> Unit): Ins =
        register(Ins(id, baseClass, job), content)

    fun del(baseClass: String? = null, id: String? = null, content: Del.() -> Unit): Del =
        register(Del(id, baseClass, job), content)

    fun ol(baseClass: String? = null, id: String? = null, content: Ol.() -> Unit): Ol =
        register(Ol(id, baseClass, job), content)

    fun `object`(baseClass: String? = null, id: String? = null, content: Object.() -> Unit): Object =
        register(Object(id, baseClass, job), content)

    fun optgroup(baseClass: String? = null, id: String? = null, content: Optgroup.() -> Unit): Optgroup =
        register(Optgroup(id, baseClass, job), content)

    fun option(baseClass: String? = null, id: String? = null, content: Option.() -> Unit): Option =
        register(Option(id, baseClass, job), content)

    fun output(baseClass: String? = null, id: String? = null, content: Output.() -> Unit): Output =
        register(Output(id, baseClass, job), content)

    fun p(baseClass: String? = null, id: String? = null, content: P.() -> Unit): P =
        register(P(id, baseClass, job), content)

    fun param(baseClass: String? = null, id: String? = null, content: Param.() -> Unit): Param =
        register(Param(id, baseClass, job), content)

    fun picture(baseClass: String? = null, id: String? = null, content: Picture.() -> Unit): Picture =
        register(Picture(id, baseClass, job), content)

    fun pre(baseClass: String? = null, id: String? = null, content: Pre.() -> Unit): Pre =
        register(Pre(id, baseClass, job), content)

    fun progress(baseClass: String? = null, id: String? = null, content: Progress.() -> Unit): Progress =
        register(Progress(id, baseClass, job), content)

    fun quote(baseClass: String? = null, id: String? = null, content: Quote.() -> Unit): Quote =
        register(Quote(id, baseClass, job), content)

    fun script(baseClass: String? = null, id: String? = null, content: Script.() -> Unit): Script =
        register(Script(id, baseClass, job), content)

    fun select(baseClass: String? = null, id: String? = null, content: Select.() -> Unit): Select =
        register(Select(id, baseClass, job), content)

    fun span(baseClass: String? = null, id: String? = null, content: Span.() -> Unit): Span =
        register(Span(id, baseClass, job), content)

    fun caption(baseClass: String? = null, id: String? = null, content: Caption.() -> Unit): Caption =
        register(Caption(id, baseClass, job), content)

    fun th(baseClass: String? = null, id: String? = null, content: Th.() -> Unit): Th =
        register(Th(id, baseClass, job), content)

    fun td(baseClass: String? = null, id: String? = null, content: Td.() -> Unit): Td =
        register(Td(id, baseClass, job), content)

    fun col(baseClass: String? = null, id: String? = null, content: Col.() -> Unit): Col =
        register(Col(id, baseClass, job), content)

    fun colgroup(baseClass: String? = null, id: String? = null, content: Colgroup.() -> Unit): Colgroup =
        register(Colgroup(id, baseClass, job), content)

    fun table(baseClass: String? = null, id: String? = null, content: Table.() -> Unit): Table =
        register(Table(id, baseClass, job), content)

    fun tr(baseClass: String? = null, id: String? = null, content: Tr.() -> Unit): Tr =
        register(Tr(id, baseClass, job), content)

    fun tfoot(baseClass: String? = null, id: String? = null, content: TFoot.() -> Unit): TFoot =
        register(TFoot(id, baseClass, job), content)

    fun thead(baseClass: String? = null, id: String? = null, content: THead.() -> Unit): THead =
        register(THead(id, baseClass, job), content)

    fun tbody(baseClass: String? = null, id: String? = null, content: TBody.() -> Unit): TBody =
        register(TBody(id, baseClass, job), content)

    fun textarea(baseClass: String? = null, id: String? = null, content: TextArea.() -> Unit): TextArea =
        register(TextArea(id, baseClass, job), content)

    fun time(baseClass: String? = null, id: String? = null, content: Time.() -> Unit): Time =
        register(Time(id, baseClass, job), content)

    fun track(baseClass: String? = null, id: String? = null, content: Track.() -> Unit): Track =
        register(Track(id, baseClass, job), content)

    fun ul(baseClass: String? = null, id: String? = null, content: Ul.() -> Unit): Ul =
        register(Ul(id, baseClass, job), content)

    fun address(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("address", id, baseClass, job), content)

    fun article(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("article", id, baseClass, job), content)

    fun aside(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("aside", id, baseClass, job), content)

    fun bdi(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("bdi", id, baseClass, job), content)

    fun details(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("details", id, baseClass, job), content)

    fun dialog(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("dialog", id, baseClass, job), content)

    fun figcaption(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("figcaption", id, baseClass, job), content)

    fun figure(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("figure", id, baseClass, job), content)

    fun footer(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("footer", id, baseClass, job), content)

    fun header(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("header", id, baseClass, job), content)

    fun main(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("main", id, baseClass, job), content)

    fun mark(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("mark", id, baseClass, job), content)

    fun nav(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("nav", id, baseClass, job), content)

    fun noscript(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("noscript", id, baseClass, job), content)

    fun progress(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("progress", id, baseClass, job), content)

    fun rp(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("rp", id, baseClass, job), content)

    fun rt(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("rt", id, baseClass, job), content)

    fun ruby(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("ruby", id, baseClass, job), content)

    fun section(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("section", id, baseClass, job), content)

    fun summary(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("summary", id, baseClass, job), content)

    fun time(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("time", id, baseClass, job), content)

    fun wbr(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("wbr", id, baseClass, job), content)

    fun blockquote(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("blockquote", id, baseClass, job), content)

    fun em(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("em", id, baseClass, job), content)

    fun strong(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("strong", id, baseClass, job), content)

    fun small(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("small", id, baseClass, job), content)

    fun s(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("s", id, baseClass, job), content)

    fun cite(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("cite", id, baseClass, job), content)

    fun q(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("q", id, baseClass, job), content)

    fun dfn(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("dfn", id, baseClass, job), content)

    fun abbr(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("abbr", id, baseClass, job), content)

    fun code(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("code", id, baseClass, job), content)

    fun `var`(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("var", id, baseClass, job), content)

    fun samp(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("samp", id, baseClass, job), content)

    fun kbd(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("kbd", id, baseClass, job), content)

    fun sub(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("sub", id, baseClass, job), content)

    fun sup(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("sup", id, baseClass, job), content)

    fun i(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("i", id, baseClass, job), content)

    fun b(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("b", id, baseClass, job), content)

    fun u(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("u", id, baseClass, job), content)

    fun bdo(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("bdo", id, baseClass, job), content)

    fun command(baseClass: String? = null, id: String? = null, content: TextElement.() -> Unit): TextElement =
        register(TextElement("command", id, baseClass, job), content)
}
