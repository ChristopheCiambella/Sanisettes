package eu.ciambella.sanisettes.domain.location

import eu.ciambella.sanisettes.domain.location.model.Location

interface LocationProvider {
    suspend fun getCurrentLocation(): Location?
}
