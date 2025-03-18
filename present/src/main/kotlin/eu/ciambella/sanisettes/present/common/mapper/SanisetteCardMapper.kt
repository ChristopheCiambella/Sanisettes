package eu.ciambella.sanisettes.present.common.mapper

import android.content.Context
import eu.ciambella.sanisettes.design.components.SanisetteCardProperty
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette
import eu.ciambella.sanisettes.present.R

class SanisetteCardMapper(
    private val context: Context
) {
    companion object {
        private const val DISTANCE_FORMAT = "%.3fkm"
    }

    fun map(
        sanisette: Sanisette,
        onClick: () -> Unit,
    ) = SanisetteCardProperty(
        address = sanisette.address,
        openingHours = sanisette.openingHours ?: context.getString(R.string.unavailable),
        isPmr = sanisette.isPmr,
        distance = formatDistance(sanisette.distanceInMeter),
        onClick = onClick
    )

    private fun formatDistance(
        distanceInMeters: Double?,
    ): String {
        if (distanceInMeters == null) {
            return DISTANCE_FORMAT
        }
        return if (distanceInMeters < 1000) {
            "${distanceInMeters.toInt()}m"
        } else {
            val distanceInKm = distanceInMeters / 1000.0
            DISTANCE_FORMAT.format(distanceInKm)
        }
    }
}
