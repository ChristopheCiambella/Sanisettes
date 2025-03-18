package eu.ciambella.sanisettes.data.sanisette.mapper

import eu.ciambella.sanisettes.data.network.entity.FieldsEntity
import eu.ciambella.sanisettes.data.network.entity.ResultEntity
import eu.ciambella.sanisettes.domain.location.model.Location
import eu.ciambella.sanisettes.domain.logger.LoggerProvider
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.domain.utils.DistanceUtils

class SanisetteMapper(
    private val loggerProvider: LoggerProvider
) {

    companion object {
        private const val TAG = "SanisetteResponseMapper"
        private const val TRUE = "Oui"
    }

    fun map(
        result: FieldsEntity?,
        currentLocation: Location?,
    ): Sanisette? {
        if (result?.adresse == null || result.geoPoint2d == null) {
            loggerProvider.w(TAG, "Mandatory field is null")
            return null
        }
        val location = Location(
            latitude = result.geoPoint2d[0],
            longitude = result.geoPoint2d[1]
        )
        return Sanisette(
            address = formatAddress(result.adresse),
            isPmr = result.accesPmr == TRUE,
            openingHours = result.horaire,
            location = location,
            distanceInMeter = calcDistance(
                currentLocation = currentLocation,
                sanisetteLocation = location
            )
        )
    }

    fun map(
        result: ResultEntity?,
        currentLocation: Location?,
    ): Sanisette? {
        if (result?.adresse == null || result.geoPoint2d == null) {
            loggerProvider.w(TAG, "Mandatory field is null")
            return null
        }
        val location = Location(
            latitude = result.geoPoint2d.lat,
            longitude = result.geoPoint2d.lon
        )
        return Sanisette(
            address = formatAddress(result.adresse),
            isPmr = result.accesPmr == TRUE,
            openingHours = result.horaire,
            location = location,
            distanceInMeter = calcDistance(
                currentLocation = currentLocation,
                sanisetteLocation = location
            )
        )
    }

    private fun formatAddress(
        input: String,
    ) = input.trim().replace(Regex("\\s+"), " ")

    private fun calcDistance(
        currentLocation: Location?,
        sanisetteLocation: Location,
    ): Double? {
        if (currentLocation == null) {
            return null
        }
        return DistanceUtils.calcHaversineDistance(
            locationA = currentLocation,
            locationB = sanisetteLocation
        )
    }
}
