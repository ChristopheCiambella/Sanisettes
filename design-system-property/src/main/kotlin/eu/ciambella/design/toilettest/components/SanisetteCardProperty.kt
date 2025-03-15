package eu.ciambella.design.toilettest.components

data class SanisetteCardProperty(
    val address: String,
    val openingHours: String,
    val isPmr: Boolean,
    val isBaby: Boolean,
    val distance: String,
    val onClick: () -> Unit,
) : Property
