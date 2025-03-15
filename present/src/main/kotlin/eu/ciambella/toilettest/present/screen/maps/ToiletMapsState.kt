package eu.ciambella.toilettest.present.screen.maps

import eu.ciambella.toilettest.domain.toilet.model.Sanisette

data class ToiletMapsState(
    val toilets: Result<List<Sanisette>>? = null
)
