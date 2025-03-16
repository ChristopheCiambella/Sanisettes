package eu.ciambella.sanisettes.data.sanisette.datastore

import eu.ciambella.sanisettes.data.network.SanisettesParisApiService
import eu.ciambella.sanisettes.data.sanisette.mapper.SanisetteResponseMapper
import eu.ciambella.sanisettes.domain.location.LocationProvider
import eu.ciambella.sanisettes.domain.logger.LoggerProvider
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

class SanisettesDatastore(
    private val toiletApiService: SanisettesParisApiService,
    private val toiletResponseMapper: SanisetteResponseMapper,
    private val locationProvider: LocationProvider,
    private val loggerProvider: LoggerProvider,
) {

    companion object {
        private const val TAG = "SanisettesDatastore"
        private const val LIMIT = 50
    }

    suspend fun getSanisettes(offset: Int): Sanisettes {
        loggerProvider.i(TAG, "Requesting sanisettes with offset $offset")
        val response = toiletApiService.getSanisettes(
            limit = LIMIT,
            offset = offset
        )
        loggerProvider.i(TAG, "Receive ${response.results.size} sanisettes")
        val currentLocation = locationProvider.getCurrentLocation()
        return toiletResponseMapper.map(
            response = response,
            currentLocation = currentLocation,
            offset = offset
        )
    }
}
