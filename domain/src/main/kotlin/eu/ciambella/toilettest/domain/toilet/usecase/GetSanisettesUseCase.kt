package eu.ciambella.toilettest.domain.toilet.usecase

import eu.ciambella.toilettest.domain.toilet.SanisettesRepository
import eu.ciambella.toilettest.domain.toilet.model.Sanisette

class GetSanisettesUseCase(
    private val toiletRepository: SanisettesRepository
) {

    suspend fun invoke(): Result<List<Sanisette>> = runCatching {
        toiletRepository.getSanisettes()
    }

}
