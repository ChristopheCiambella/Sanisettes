package eu.ciambella.toilettest.data.toilet.datastore

import eu.ciambella.toilettest.data.network.SanisettesParisApiService
import eu.ciambella.toilettest.data.toilet.mapper.ToiletResponseMapper
import eu.ciambella.toilettest.domain.location.LocationProvider
import eu.ciambella.toilettest.domain.toilet.model.Sanisette

class SanisettesDatastore(
    private val toiletApiService: SanisettesParisApiService,
    private val toiletResponseMapper: ToiletResponseMapper,
    private val locationProvider: LocationProvider
) {

    suspend fun getSanisettes(): List<Sanisette> {
        val response = toiletApiService.getSanisettes()
        val currentLocation = locationProvider.getCurrentLocation()
        return toiletResponseMapper.map(response, currentLocation)
    }

}
