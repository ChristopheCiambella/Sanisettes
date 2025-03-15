package eu.ciambella.toilettest.present.screen.list

import eu.ciambella.design.toilettest.components.Property
import eu.ciambella.design.toilettest.components.ShimmerProperty
import eu.ciambella.design.toilettest.components.ToiletProperty
import eu.ciambella.design.toilettest.content.ContentProperty
import eu.ciambella.design.toilettest.content.LazyColumnContentProperty
import eu.ciambella.design.toilettest.scaffold.ScaffoldProperty
import eu.ciambella.toilettest.domain.toilet.model.Toilet
import eu.ciambella.toilettest.present.common.mapper.NavigationBarPropertyMapper
import eu.ciambella.toilettest.present.common.mapper.RouteNavigationBarProperty
import eu.ciambella.toilettest.present.common.mapper.ScaffoldPropertyMapper

class ToiletListScreenMapper(
    private val navigationBarPropertyMapper: NavigationBarPropertyMapper,
) {

    private fun scaffold(
        contentProperty: ContentProperty
    ) = ScaffoldProperty(
        contentProperty = contentProperty,
        navigationBarProperty = navigationBarPropertyMapper.main(RouteNavigationBarProperty.LIST),
    )

    fun loading(): ScaffoldProperty = scaffold(
        contentProperty = LazyColumnContentProperty(
            items = mutableListOf(ShimmerProperty)
        )
    )

    fun map(
        state: ToiletListState,
    ): ScaffoldProperty {
        if (state.toilets == null) {
            return loading()
        }
        return state.toilets.fold(
            onSuccess = {
                mapSuccess(it)
            },
            onFailure = {
                TODO()
            }
        )
    }

    private fun mapSuccess(toilets: List<Toilet>) = scaffold(
        contentProperty = LazyColumnContentProperty(
            items = mapScreen(toilets)
        )
    )

    private fun mapScreen(
        toilets: List<Toilet>
    ): List<Property> = mutableListOf<Property>().apply {
        toilets.forEach {
            add(ToiletProperty(it.address))
        }
    }

}

