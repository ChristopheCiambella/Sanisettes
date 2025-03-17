package eu.ciambella.sanisettes.domain.settings.usecase

import eu.ciambella.sanisettes.domain.settings.SettingsRepository

class PmrOnlyFilterEnableUseCase(
    private val settingsRepository: SettingsRepository
) {

    suspend fun invoke() = settingsRepository.pmrFilterEnableFlow()
}
