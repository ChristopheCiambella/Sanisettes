package eu.ciambella.sanisettes.data.sanisette.datastore

import eu.ciambella.sanisettes.data.network.SanisettesParisApiService
import eu.ciambella.sanisettes.data.sanisette.mapper.SanisetteResponseMapper
import eu.ciambella.sanisettes.domain.location.LocationProvider
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette

class SanisettesDatastore(
    private val toiletApiService: SanisettesParisApiService,
    private val toiletResponseMapper: SanisetteResponseMapper,
    private val locationProvider: LocationProvider
) {

    suspend fun getSanisettes(): List<Sanisette> {
        val response = toiletApiService.getSanisettes()
        val currentLocation = locationProvider.getCurrentLocation()
        return toiletResponseMapper.map(response, currentLocation)
    }

}
