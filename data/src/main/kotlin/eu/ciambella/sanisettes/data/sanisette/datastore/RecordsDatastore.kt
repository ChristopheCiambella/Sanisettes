package eu.ciambella.sanisettes.data.sanisette.datastore

import eu.ciambella.sanisettes.data.network.DataRATPParisApiService
import eu.ciambella.sanisettes.data.sanisette.mapper.RecordsResponseMapper
import eu.ciambella.sanisettes.domain.location.LocationProvider
import eu.ciambella.sanisettes.domain.logger.LoggerProvider
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

class RecordsDatastore(
    private val dataRATPParisApiService: DataRATPParisApiService,
    private val recordsResponseMapper: RecordsResponseMapper,
    private val locationProvider: LocationProvider,
    private val loggerProvider: LoggerProvider,
) {

    companion object {
        private const val TAG = "SanisettesDatastore"
        private const val LIMIT = 50
    }

    suspend fun getRecords(offset: Int): Sanisettes {
        loggerProvider.i(TAG, "Requesting sanisettes with offset $offset")
        val response = dataRATPParisApiService.getRecords(
            limit = LIMIT,
            offset = offset
        )
        loggerProvider.i(TAG, "Receive ${response.results.size} sanisettes")
        val currentLocation = locationProvider.getCurrentLocation()
        return recordsResponseMapper.map(
            response = response,
            currentLocation = currentLocation,
            offset = offset
        )
    }
}
