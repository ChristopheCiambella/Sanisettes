package eu.ciambella.sanisettes.design.core.content

import eu.ciambella.sanisettes.design.components.MarkerProperty

data class MapsContentProperty(
    val startLatitude: Double,
    val startLongitude: Double,
    val startZoom: Float,
    val markers: List<MarkerProperty>
) : ContentProperty
