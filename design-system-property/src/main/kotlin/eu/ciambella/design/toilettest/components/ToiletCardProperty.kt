package eu.ciambella.design.toilettest.components

data class ToiletCardProperty(
    val address: String,
    val openingHours: String,
    val isPmr: Boolean,
    val isBaby: Boolean,
    val distance: String
) : Property
