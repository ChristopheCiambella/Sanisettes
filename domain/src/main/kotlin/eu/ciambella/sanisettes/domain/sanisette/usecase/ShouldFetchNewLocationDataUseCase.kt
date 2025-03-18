package eu.ciambella.sanisettes.domain.sanisette.usecase

import eu.ciambella.sanisettes.domain.location.model.Location
import eu.ciambella.sanisettes.domain.utils.DistanceUtils

class ShouldFetchNewLocationDataUseCase {

    companion object {
        private const val DISTANCE_METER_THRESHOLD = 1000F
    }

    fun invoke(
        previousLocation: Location?,
        newLocation: Location
    ): Boolean {
        if (previousLocation == null) {
            return true
        }
        val distance = DistanceUtils.calcHaversineDistance(
            locationA = previousLocation,
            locationB = newLocation
        )
        return distance > DISTANCE_METER_THRESHOLD
    }
}
