package eu.ciambella.sanisettes.domain.sanisette

import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette

interface SanisettesRepository {
    suspend fun getSanisettes(): List<Sanisette>
}
