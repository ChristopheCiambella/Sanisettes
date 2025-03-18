package eu.ciambella.sanisettes.data.settings

import eu.ciambella.sanisettes.domain.settings.FilterProvider
import eu.ciambella.sanisettes.domain.settings.SettingsRepository
import kotlinx.coroutines.flow.Flow

class SettingsRepositoryImpl(
    private val filterProvider: FilterProvider
) : SettingsRepository {
    override suspend fun pmrFilterEnableFlow(): Flow<Boolean> = filterProvider.isPmrOnly

    override suspend fun setPmrFilterOnly(value: Boolean) {
        filterProvider.setPmrOnly(value)
    }
}
