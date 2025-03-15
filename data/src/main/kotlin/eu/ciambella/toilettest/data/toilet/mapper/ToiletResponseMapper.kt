package eu.ciambella.toilettest.data.toilet.mapper

import eu.ciambella.toilettest.data.network.entity.ResultEntity
import eu.ciambella.toilettest.data.network.response.SanisettesResponse
import eu.ciambella.toilettest.data.utils.DistanceUtils
import eu.ciambella.toilettest.domain.location.model.Location
import eu.ciambella.toilettest.domain.toilet.model.Sanisette

class ToiletResponseMapper {

    companion object {
        private const val TRUE = "Oui"
        private const val DISTANCE_FORMAT = "%.3fkm"
        private const val UNAVAILABLE = "----"
    }

    fun map(
        response: SanisettesResponse,
        currentLocation: Location?,
    ): List<Sanisette> = response.results.map {
        mapSanisette(it, currentLocation)
    }

    private fun mapSanisette(
        result: ResultEntity,
        currentLocation: Location?,
    ): Sanisette {
        val location = Location(
            latitude = result.geoPoint2d.lat,
            longitude = result.geoPoint2d.lon
        )
        return Sanisette(
            address = formatAddress(result.adresse),
            isPmr = result.accesPmr == TRUE,
            openingHours = result.horaire,
            location = location,
            distance = calcDistance(
                currentLocation = currentLocation,
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
        currentLocation: Location?,
        sanisetteLocation: Location,
    ): String {
        if (currentLocation == null) {
            return UNAVAILABLE
        }
        val distance = DistanceUtils.calcHaversineDistance(
            locationA = currentLocation,
            locationB = sanisetteLocation
        )
        return formatDistance(distance)
    }

}
