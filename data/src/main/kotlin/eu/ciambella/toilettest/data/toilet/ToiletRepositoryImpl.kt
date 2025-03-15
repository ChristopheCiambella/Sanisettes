package eu.ciambella.toilettest.data.toilet

import eu.ciambella.toilettest.data.toilet.datastore.SanisettesDatastore
import eu.ciambella.toilettest.domain.toilet.ToiletRepository
import eu.ciambella.toilettest.domain.toilet.model.Toilet

class ToiletRepositoryImpl(
    private val toiletDatastore: SanisettesDatastore
) : ToiletRepository {
    override suspend fun getToilets(): List<Toilet> = toiletDatastore.getSanisettes()
}
