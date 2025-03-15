package eu.ciambella.sanisettes.present.common.mapper

import eu.ciambella.sanisettes.design.core.bottombar.NavigationBarProperty
import eu.ciambella.sanisettes.design.core.content.ContentProperty
import eu.ciambella.sanisettes.design.core.scaffold.ScaffoldProperty

class ScaffoldPropertyMapper {

    fun map(
        contentProperty: ContentProperty,
        navigationBarProperty: NavigationBarProperty? = null,
    ) = ScaffoldProperty(
        contentProperty = contentProperty,
        navigationBarProperty = navigationBarProperty,
    )

}
