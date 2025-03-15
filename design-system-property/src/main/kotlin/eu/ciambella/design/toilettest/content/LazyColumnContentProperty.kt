package eu.ciambella.design.toilettest.content

import eu.ciambella.design.toilettest.components.Property

data class LazyColumnContentProperty(
    val items: List<Property>,
    val scrollEnabled: Boolean = true,
) : ContentProperty
