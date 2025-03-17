package eu.ciambella.sanisettes.design.components

data class MapsProperty(
    val markers: List<MarkerProperty>,
    val centerOnPosition: Pair<Double, Double>?,
    val centerZoom: Float? = null,
    val onLocationChanged: (latitude: Double, longitude: Double) -> Unit
) : Property
