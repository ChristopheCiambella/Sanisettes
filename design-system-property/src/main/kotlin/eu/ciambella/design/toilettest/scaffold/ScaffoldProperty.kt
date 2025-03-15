package eu.ciambella.design.toilettest.scaffold

import eu.ciambella.design.toilettest.bottombar.NavigationBarProperty
import eu.ciambella.design.toilettest.content.ContentProperty

data class ScaffoldProperty(
    val contentProperty: ContentProperty,
    val navigationBarProperty: NavigationBarProperty?
)
