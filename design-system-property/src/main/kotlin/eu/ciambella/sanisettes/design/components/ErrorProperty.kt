package eu.ciambella.sanisettes.design.components

data class ErrorProperty(
    val title: String?,
    val message: String?,
    val action: String?,
    val onActionClick: (() -> Unit)?
) : Property
