package eu.ciambella.toilettest.data.toilet.datastore

import eu.ciambella.toilettest.data.network.ToiletApiService
import eu.ciambella.toilettest.data.toilet.mapper.ToiletResponseMapper
import eu.ciambella.toilettest.domain.toilet.model.Toilet

class ToiletDatastore(
    private val toiletApiService: ToiletApiService,
    private val toiletResponseMapper: ToiletResponseMapper
) {

    suspend fun getToilets(): List<Toilet> {
        val response = toiletApiService.getToilets()
        return toiletResponseMapper.mapToToilet(response)
    }

}
