package eu.ciambella.toilettest.data.network.response

import eu.ciambella.toilettest.data.network.entity.RecordEntity

data class ToiletResponse(
    val records: List<RecordEntity>
)
