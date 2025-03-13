package eu.ciambella.toilettest.domain.toilet.usecase

import eu.ciambella.toilettest.domain.toilet.ToiletRepository
import eu.ciambella.toilettest.domain.toilet.model.Toilet

class GetToiletUseCase(
    private val toiletRepository: ToiletRepository
) {

    suspend fun invoke(): Result<List<Toilet>> = runCatching {
        toiletRepository.getToilets()
    }

}
