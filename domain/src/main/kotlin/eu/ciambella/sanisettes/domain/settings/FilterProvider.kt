package eu.ciambella.sanisettes.domain.settings

import kotlinx.coroutines.flow.Flow

interface FilterProvider {
    val isPmrOnly: Flow<Boolean>
    suspend fun setPmrOnly(value: Boolean)
}
