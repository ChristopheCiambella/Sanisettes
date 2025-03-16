package eu.ciambella.sanisettes.domain.sanisette

import eu.ciambella.sanisettes.domain.location.model.Location
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

interface SanisettesRepository {
    suspend fun getSanisettes(offset: Int): Sanisettes
    suspend fun searchSanisettes(location: Location): Sanisettes
}
