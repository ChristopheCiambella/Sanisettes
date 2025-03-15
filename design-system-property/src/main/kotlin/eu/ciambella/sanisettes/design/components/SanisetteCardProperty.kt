package eu.ciambella.sanisettes.design.components

data class SanisetteCardProperty(
    val address: String,
    val openingHours: String,
    val isPmr: Boolean,
    val distance: String,
    val onClick: () -> Unit,
) : Property
