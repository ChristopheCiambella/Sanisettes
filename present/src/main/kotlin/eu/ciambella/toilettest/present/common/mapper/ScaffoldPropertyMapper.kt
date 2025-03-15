package eu.ciambella.toilettest.present.common.mapper

import eu.ciambella.design.toilettest.bottombar.NavigationBarProperty
import eu.ciambella.design.toilettest.content.ContentProperty
import eu.ciambella.design.toilettest.scaffold.ScaffoldProperty

class ScaffoldPropertyMapper {

    fun map(
        contentProperty: ContentProperty,
        navigationBarProperty: NavigationBarProperty? = null,
    ) = ScaffoldProperty(
        contentProperty = contentProperty,
        navigationBarProperty = navigationBarProperty,
    )

}
