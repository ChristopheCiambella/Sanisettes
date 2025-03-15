package eu.ciambella.sanisettes.design.components

data class MarkerProperty(
    val title: String,
    val latitude: Double,
    val longitude: Double,
    val onClick: () -> Unit,
) : Property
