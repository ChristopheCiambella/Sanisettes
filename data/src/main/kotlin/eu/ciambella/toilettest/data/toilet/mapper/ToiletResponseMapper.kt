package eu.ciambella.toilettest.data.toilet.mapper

import eu.ciambella.toilettest.data.network.response.SanisettesResponse
import eu.ciambella.toilettest.domain.toilet.model.Toilet

class ToiletResponseMapper {

    companion object {
        private const val TRUE = "Oui"
    }

    fun mapToToilet(
        response: SanisettesResponse
    ): List<Toilet> = response.results.map {
        Toilet(
            address = it.adresse,
            isPmr = it.accesPmr == TRUE,
            openingHours = it.horaire,
            longitude = it.geoPoint2d.lon,
            latitude = it.geoPoint2d.lat,
        )
    }

}
