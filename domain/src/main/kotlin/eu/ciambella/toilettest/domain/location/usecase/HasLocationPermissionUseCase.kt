package eu.ciambella.toilettest.domain.location.usecase

import eu.ciambella.toilettest.domain.location.LocationRepository
import eu.ciambella.toilettest.domain.location.model.LocationResult

class HasLocationPermissionUseCase(
    private val locationRepository: LocationRepository
) {
    suspend fun invoke(): Boolean = locationRepository.hasLocationPermission()
}
