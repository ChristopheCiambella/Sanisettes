package eu.ciambella.toilettest.data.network.response

import eu.ciambella.toilettest.data.network.entity.ResultEntity
import kotlinx.serialization.Serializable

@Serializable
data class SanisettesResponse(
    val results: List<ResultEntity>
)
