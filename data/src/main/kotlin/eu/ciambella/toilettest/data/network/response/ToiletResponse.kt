package eu.ciambella.toilettest.data.network.response

import eu.ciambella.toilettest.data.network.entity.RecordEntity
import kotlinx.serialization.Serializable

@Serializable
data class ToiletResponse(
    val records: List<RecordEntity>
)
