package eu.ciambella.toilettest.domain.toilet

import eu.ciambella.toilettest.domain.toilet.model.Sanisette

interface SanisettesRepository {
    suspend fun getSanisettes(): List<Sanisette>
}
