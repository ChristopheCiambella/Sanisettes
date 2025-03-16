package eu.ciambella.sanisettes.design.components

data class LoadingProperty(
    val nextCallback: () -> Unit
) : Property
