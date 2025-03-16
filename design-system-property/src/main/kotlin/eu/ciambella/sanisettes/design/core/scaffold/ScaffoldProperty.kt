package eu.ciambella.sanisettes.design.core.scaffold

import eu.ciambella.sanisettes.design.core.bottombar.NavigationBarProperty
import eu.ciambella.sanisettes.design.core.bottomsheet.BottomSheetProperty
import eu.ciambella.sanisettes.design.core.content.ContentProperty
import eu.ciambella.sanisettes.design.core.topbar.TopAppBarProperty

data class ScaffoldProperty(
    val topAppBarProperty: TopAppBarProperty,
    val contentProperty: ContentProperty,
    val navigationBarProperty: NavigationBarProperty? = null,
    val bottomSheetContentProperty: BottomSheetProperty? = null,
)
