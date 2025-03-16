package eu.ciambella.sanisettes.domain.sanisette.usecase

import eu.ciambella.sanisettes.domain.location.model.Location
import eu.ciambella.sanisettes.domain.sanisette.SanisettesRepository
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

class SearchSanisettesUseCase(
    private val sanisettesRepository: SanisettesRepository
) {

    suspend fun invoke(
        location: Location
    ): Result<Sanisettes> = runCatching {
        sanisettesRepository.searchSanisettes(location)
    }
}
