package eu.ciambella.sanisettes.data.sanisette

import eu.ciambella.sanisettes.data.sanisette.datastore.SanisettesDatastore
import eu.ciambella.sanisettes.domain.sanisette.SanisettesRepository
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

class SanisettesRepositoryImpl(
    private val toiletDatastore: SanisettesDatastore,
) : SanisettesRepository {

    override suspend fun getSanisettes(
        offset: Int
    ): Sanisettes = toiletDatastore.getSanisettes(offset)
}
