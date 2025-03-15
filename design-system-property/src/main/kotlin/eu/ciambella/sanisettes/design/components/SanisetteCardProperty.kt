package eu.ciambella.sanisettes.design.components

import eu.ciambella.sanisettes.design.components.Property

data class SanisetteCardProperty(
    val address: String,
    val openingHours: String,
    val isPmr: Boolean,
    val distance: String,
    val onClick: () -> Unit,
) : Property
