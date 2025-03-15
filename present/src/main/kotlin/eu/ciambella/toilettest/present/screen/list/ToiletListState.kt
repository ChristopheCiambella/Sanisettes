package eu.ciambella.toilettest.present.screen.list

import eu.ciambella.toilettest.domain.toilet.model.Sanisette

data class ToiletListState(
    val toilets: Result<List<Sanisette>>? = null,
)
