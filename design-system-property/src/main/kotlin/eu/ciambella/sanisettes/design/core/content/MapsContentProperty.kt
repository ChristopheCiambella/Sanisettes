package eu.ciambella.sanisettes.design.core.content

import eu.ciambella.sanisettes.design.components.MapsProperty
import eu.ciambella.sanisettes.design.components.SanisetteSheetProperty

data class MapsContentProperty(
    val mapsProperty: MapsProperty,
    val sheetProperty: SanisetteSheetProperty?,
) : ContentProperty
