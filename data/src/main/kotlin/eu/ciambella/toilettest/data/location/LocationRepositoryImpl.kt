package eu.ciambella.toilettest.data.location

import eu.ciambella.toilettest.domain.location.LocationProvider
import eu.ciambella.toilettest.domain.location.LocationRepository
import eu.ciambella.toilettest.domain.location.model.LocationResult

class LocationRepositoryImpl(
    private val locationProvider: LocationProvider
) : LocationRepository {

    override suspend fun getCurrentLocation(): LocationResult =
        locationProvider.getCurrentLocation()

}
