package eu.ciambella.toilettest.domain.location

import eu.ciambella.toilettest.domain.location.model.LocationResult

interface LocationRepository {
    suspend fun getCurrentLocation(): LocationResult
}
