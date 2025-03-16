package eu.ciambella.sanisettes.data.sanisette.datastore

import eu.ciambella.sanisettes.data.network.DataRATPParisApiService
import eu.ciambella.sanisettes.data.sanisette.mapper.SearchResponseMapper
import eu.ciambella.sanisettes.domain.location.LocationProvider
import eu.ciambella.sanisettes.domain.location.model.Location
import eu.ciambella.sanisettes.domain.logger.LoggerProvider
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

class SearchDatastore(
    private val dataRATPParisApiService: DataRATPParisApiService,
    private val searchResponseMapper: SearchResponseMapper,
    private val locationProvider: LocationProvider,
    private val loggerProvider: LoggerProvider,
) {

    companion object {
        private const val TAG = "SanisettesDatastore"
        private const val LIMIT = 50
        private const val DATASET = "sanisettesparis2011"
        private const val GEO_FILTER = "%.6f,%.6f,1000"
    }

    suspend fun search(location: Location): Sanisettes {
        loggerProvider.i(TAG, "Search on position lat=${location.latitude} lng=${location.longitude}")
        val response = dataRATPParisApiService.search(
            limit = LIMIT,
            dataset = DATASET,
            geoFilter = GEO_FILTER.format(location.latitude, location.longitude),
            offset = 0
        )
        loggerProvider.i(TAG, "Receive ${response.records.size} sanisettes")
        val currentLocation = locationProvider.getCurrentLocation()
        return searchResponseMapper.map(
            response = response,
            currentLocation = currentLocation,
            offset = 0
        )
    }
}
