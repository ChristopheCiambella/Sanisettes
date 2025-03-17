package eu.ciambella.sanisettes.domain.settings.usecase

import eu.ciambella.sanisettes.domain.settings.SettingsRepository

class ChangeOnlyFilterEnableUseCase(
    private val settingsRepository: SettingsRepository,
) {

    suspend fun invoke(
        enable: Boolean
    ) = settingsRepository.setPmrFilterOnly(enable)
}
