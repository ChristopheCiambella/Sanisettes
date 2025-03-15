package eu.ciambella.toilettest.domain.location

import eu.ciambella.toilettest.domain.location.model.LocationResult

interface LocationProvider {
    suspend fun getCurrentLocation(): LocationResult
}
