package eu.ciambella.sanisettes.design.core.content

import eu.ciambella.sanisettes.design.components.Property

data class LazyColumnContentProperty(
    val items: List<Property>,
    val scrollEnabled: Boolean = true,
) : ContentProperty
