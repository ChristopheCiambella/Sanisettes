package eu.ciambella.sanisettes.data.sanisette.datastore

import eu.ciambella.sanisettes.data.network.SanisettesParisApiService
import eu.ciambella.sanisettes.data.sanisette.mapper.SanisetteResponseMapper
import eu.ciambella.sanisettes.domain.location.LocationProvider
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

class SanisettesDatastore(
    private val toiletApiService: SanisettesParisApiService,
    private val toiletResponseMapper: SanisetteResponseMapper,
    private val locationProvider: LocationProvider
) {

    companion object {
        private const val LIMIT = 50
    }

    suspend fun getSanisettes(offset: Int): Sanisettes {
        val response = toiletApiService.getSanisettes(
            limit = LIMIT,
            offset = offset
        )
        val currentLocation = locationProvider.getCurrentLocation()
        return toiletResponseMapper.map(
            response = response,
            currentLocation = currentLocation,
            offset = offset
        )
    }
}
