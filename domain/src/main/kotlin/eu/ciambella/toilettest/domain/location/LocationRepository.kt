package eu.ciambella.toilettest.domain.location

import eu.ciambella.toilettest.domain.location.model.LocationResult

interface LocationRepository {
    suspend fun hasLocationPermission(): Boolean
    suspend fun getCurrentLocation(): LocationResult
}
