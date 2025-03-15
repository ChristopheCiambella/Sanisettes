package eu.ciambella.design.toilettest.components

data class ErrorProperty(
    val title: String?,
    val message: String?,
    val action: String?,
    val onActionClick: (() -> Unit)?
) : Property
