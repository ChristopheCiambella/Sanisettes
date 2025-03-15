package eu.ciambella.sanisettes.design.core.content

data class MapsContentProperty(
    val startLatitude: Double,
    val startLongitude: Double,
    val startZoom: Float,
) : ContentProperty
