package eu.ciambella.sanisettes.domain.settings

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun pmrFilterEnableFlow(): Flow<Boolean>
    suspend fun setPmrFilterOnly(value: Boolean)
}
