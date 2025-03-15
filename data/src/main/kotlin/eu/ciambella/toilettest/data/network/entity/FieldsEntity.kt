package eu.ciambella.toilettest.data.network.entity

import kotlinx.serialization.Serializable

@Serializable
data class FieldsEntity(
    val acces_pmr: String,
    val horaire: String,
    val adresse: String
)
