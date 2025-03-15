package eu.ciambella.toilettest.data.toilet

import eu.ciambella.toilettest.data.toilet.datastore.SanisettesDatastore
import eu.ciambella.toilettest.domain.location.LocationProvider
import eu.ciambella.toilettest.domain.toilet.SanisettesRepository
import eu.ciambella.toilettest.domain.toilet.model.Sanisette

class SanisettesRepositoryImpl(
    private val toiletDatastore: SanisettesDatastore,
) : SanisettesRepository {

    override suspend fun getSanisettes(): List<Sanisette> = toiletDatastore.getSanisettes()

}
