package eu.ciambella.toilettest.data.toilet

import eu.ciambella.toilettest.data.toilet.datastore.ToiletDatastore
import eu.ciambella.toilettest.domain.toilet.ToiletRepository
import eu.ciambella.toilettest.domain.toilet.model.Toilet

class ToiletRepositoryImpl(
    private val toiletDatastore: ToiletDatastore
) : ToiletRepository {
    override suspend fun getToilets(): List<Toilet> = toiletDatastore.getToilets()
}
