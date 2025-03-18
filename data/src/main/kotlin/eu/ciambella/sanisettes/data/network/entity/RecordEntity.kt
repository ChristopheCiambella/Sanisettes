package eu.ciambella.sanisettes.data.network.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecordEntity(
    @SerialName("fields")
    val fields: FieldsEntity?,
)
