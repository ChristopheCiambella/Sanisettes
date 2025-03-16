package eu.ciambella.sanisettes.domain.utils

import eu.ciambella.sanisettes.domain.location.model.Location
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

object DistanceUtils {

    private const val EARTH_RADIUS_IN_METER = 6371000.0

    fun calcHaversineDistance(
        locationA: Location,
        locationB: Location,
    ): Double {
        val phi1 = Math.toRadians(locationA.latitude)
        val phi2 = Math.toRadians(locationB.latitude)
        val deltaPhi = Math.toRadians(locationB.latitude - locationA.latitude)
        val deltaLambda = Math.toRadians(locationB.longitude - locationA.longitude)
        val a = sin(deltaPhi / 2).pow(2.0) + cos(phi1) * cos(phi2) * sin(deltaLambda / 2).pow(2.0)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        return EARTH_RADIUS_IN_METER * c
    }
}
