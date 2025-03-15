package eu.ciambella.sanisettes.data.network.response

import eu.ciambella.sanisettes.data.network.entity.ResultEntity
import kotlinx.serialization.Serializable

@Serializable
data class SanisettesResponse(
    val results: List<ResultEntity>
)
