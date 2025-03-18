package eu.ciambella.sanisettes.design.core.bottomsheet

import eu.ciambella.sanisettes.design.core.content.ContentProperty

data class BottomSheetProperty(
    val content: ContentProperty,
    val onDismiss: () -> Unit,
)
