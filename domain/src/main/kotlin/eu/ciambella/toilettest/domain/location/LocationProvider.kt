package eu.ciambella.toilettest.domain.location

import eu.ciambella.toilettest.domain.location.model.Location

interface LocationProvider {
    suspend fun getCurrentLocation(): Location?
}
