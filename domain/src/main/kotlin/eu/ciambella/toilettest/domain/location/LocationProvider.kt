package eu.ciambella.toilettest.domain.location

import eu.ciambella.toilettest.domain.location.model.LocationResult

interface LocationProvider {
    fun hasLocationPermission(): Boolean
    suspend fun getCurrentLocation(): LocationResult
}
