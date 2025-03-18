package eu.ciambella.sanisettes.data.network.response

import eu.ciambella.sanisettes.data.network.entity.RecordEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("nhits")
    val nhits: Int,
    @SerialName("records")
    val records: List<RecordEntity>
)
