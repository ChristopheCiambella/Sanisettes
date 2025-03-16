package eu.ciambella.sanisettes.design.core.content

import eu.ciambella.sanisettes.design.components.MarkerProperty

data class MapsContentProperty(
    val markers: List<MarkerProperty>,
    val centerOnMarkers: Boolean,
    val onLocationChanged: (latitude: Double, longitude: Double) -> Unit
) : ContentProperty
