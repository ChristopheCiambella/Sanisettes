package eu.ciambella.toilettest.present.screen.list

import eu.ciambella.toilettest.domain.toilet.model.Toilet

data class ToiletListState(
    val toilets: Result<List<Toilet>>? = null
)
