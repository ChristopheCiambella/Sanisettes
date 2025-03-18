package eu.ciambella.sanisettes.domain.sanisette.usecase

import eu.ciambella.sanisettes.domain.sanisette.SanisettesRepository
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

class GetSanisettesUseCase(
    private val sanisettesRepository: SanisettesRepository
) {

    companion object {
        private const val DEFAULT_OFFSET = 0
    }

    suspend fun invoke(
        offset: Int = DEFAULT_OFFSET
    ): Result<Sanisettes> = runCatching {
        sanisettesRepository.getSanisettes(offset)
    }
}
