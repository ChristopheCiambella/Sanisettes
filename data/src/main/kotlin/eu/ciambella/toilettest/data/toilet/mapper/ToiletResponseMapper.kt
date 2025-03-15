package eu.ciambella.toilettest.data.toilet.mapper

import eu.ciambella.toilettest.data.network.entity.ResultEntity
import eu.ciambella.toilettest.data.network.response.SanisettesResponse
import eu.ciambella.toilettest.data.utils.DistanceUtils
import eu.ciambella.toilettest.domain.location.model.Location
import eu.ciambella.toilettest.domain.location.model.LocationResult
import eu.ciambella.toilettest.domain.toilet.model.Sanisette

class ToiletResponseMapper {

    companion object {
        private const val TRUE = "Oui"
        private const val DISTANCE_FORMAT = "%.3fkm"
        private const val UNAVAILABLE = "----"
    }

    fun map(
        response: SanisettesResponse,
        locationResult: LocationResult,
    ): List<Sanisette> = response.results.map {
        mapSanisette(it, locationResult)
    }

    private fun mapSanisette(
        result: ResultEntity,
        locationResult: LocationResult,
    ): Sanisette {
        val location = Location(
            latitude = result.geoPoint2d.lat,
            longitude = result.geoPoint2d.lon
        )
        return Sanisette(
            address = formatAddress(result.adresse),
            isPmr = result.accesPmr == TRUE,
            isBaby = result.accesBebe == TRUE,
            openingHours = result.horaire,
            location = location,
            distance = calcDistance(
                currentLocationResult = locationResult,
                sanisetteLocation = location
            )
        )
    }

    private fun formatAddress(
        input: String,
    ) = input.trim().replace(Regex("\\s+"), " ")

    private fun formatDistance(
        distanceInMeters: Double,
    ): String {
        return if (distanceInMeters < 1000) {
            "${distanceInMeters.toInt()}m"
        } else {
            val distanceInKm = distanceInMeters / 1000.0
            DISTANCE_FORMAT.format(distanceInKm)
        }
    }

    private fun calcDistance(
        currentLocationResult: LocationResult,
        sanisetteLocation: Location,
    ): String = when (currentLocationResult) {
        is LocationResult.Success -> {
            val distance = DistanceUtils.calcHaversineDistance(
                locationA = currentLocationResult.location,
                locationB = sanisetteLocation
            )
            formatDistance(distance)
        }
        else -> UNAVAILABLE
    }

}
