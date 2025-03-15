package eu.ciambella.toilettest.data.network.entity

import kotlinx.serialization.Serializable

@Serializable
data class RecordEntity(
    val geometry: GeometryEntity,
    val fields: FieldsEntity,
)
