package eu.ciambella.sanisettes.domain.sanisette.usecase

import eu.ciambella.sanisettes.domain.sanisette.SanisettesRepository
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette

class GetSanisettesUseCase(
    private val sanisettesRepository: SanisettesRepository
) {

    suspend fun invoke(): Result<List<Sanisette>> = runCatching {
        sanisettesRepository.getSanisettes()
    }

}
