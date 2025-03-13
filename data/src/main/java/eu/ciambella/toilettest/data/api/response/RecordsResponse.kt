package eu.ciambella.toilettest.data.api.response

import eu.ciambella.toilettest.data.api.entity.RecordEntity

data class RecordsResponse(
    val nhits: Int,
    val records: List<RecordEntity>
)
