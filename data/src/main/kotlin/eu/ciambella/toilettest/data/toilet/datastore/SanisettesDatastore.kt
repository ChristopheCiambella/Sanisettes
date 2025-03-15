package eu.ciambella.toilettest.data.toilet.datastore

import eu.ciambella.toilettest.data.network.SanisettesParisApiService
import eu.ciambella.toilettest.data.toilet.mapper.ToiletResponseMapper
import eu.ciambella.toilettest.domain.toilet.model.Toilet

class SanisettesDatastore(
    private val toiletApiService: SanisettesParisApiService,
    private val toiletResponseMapper: ToiletResponseMapper
) {

    suspend fun getSanisettes(): List<Toilet> {
        val response = toiletApiService.getSanisettes()
        return toiletResponseMapper.mapToToilet(response)
    }

}
