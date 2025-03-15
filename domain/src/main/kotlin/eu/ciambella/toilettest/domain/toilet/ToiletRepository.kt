package eu.ciambella.toilettest.domain.toilet

import eu.ciambella.toilettest.domain.toilet.model.Toilet

interface ToiletRepository {
    suspend fun getToilets(): List<Toilet>
}
