package eu.ciambella.sanisettes.design.core.content

import eu.ciambella.sanisettes.design.components.Property
import eu.ciambella.sanisettes.design.core.content.ContentProperty

data class LazyColumnContentProperty(
    val items: List<Property>,
    val scrollEnabled: Boolean = true,
) : ContentProperty
