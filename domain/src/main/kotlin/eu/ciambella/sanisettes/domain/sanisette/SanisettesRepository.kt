package eu.ciambella.sanisettes.domain.sanisette

import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

interface SanisettesRepository {
    suspend fun getSanisettes(offset: Int): Sanisettes
}
