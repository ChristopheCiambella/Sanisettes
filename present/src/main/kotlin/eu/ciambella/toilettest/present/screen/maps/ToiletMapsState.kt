package eu.ciambella.toilettest.present.screen.maps

import eu.ciambella.toilettest.domain.toilet.model.Toilet

data class ToiletMapsState(
    val toilets: Result<List<Toilet>>? = null
)
