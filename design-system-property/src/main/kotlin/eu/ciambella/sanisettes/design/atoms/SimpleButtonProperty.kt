package eu.ciambella.sanisettes.design.atoms

import eu.ciambella.sanisettes.design.components.Property

data class SimpleButtonProperty(
    val label: String,
    val onClick: () -> Unit,
) : Property
