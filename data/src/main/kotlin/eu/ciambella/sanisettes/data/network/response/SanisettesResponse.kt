package eu.ciambella.sanisettes.data.network.response

import eu.ciambella.sanisettes.data.network.entity.ResultEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SanisettesResponse(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("results")
    val results: List<ResultEntity>
)
