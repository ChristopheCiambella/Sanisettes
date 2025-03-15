package eu.ciambella.toilettest.data.toilet.mapper

import eu.ciambella.toilettest.data.network.entity.ResultEntity
import eu.ciambella.toilettest.data.network.response.SanisettesResponse
import eu.ciambella.toilettest.domain.toilet.model.Toilet

class ToiletResponseMapper {

    companion object {
        private const val TRUE = "Oui"
    }

    fun mapToToilet(
        response: SanisettesResponse
    ): List<Toilet> = response.results.map(::mapToilet)

    private fun mapToilet(
        result: ResultEntity
    ) = Toilet(
        address = format(result.adresse),
        isPmr = result.accesPmr == TRUE,
        isBaby = result.accesBebe == TRUE,
        openingHours = result.horaire,
        longitude = result.geoPoint2d.lon,
        latitude = result.geoPoint2d.lat,
        distance = "300m"
    )

    private fun format(
        input: String
    ) = input.trim().replace(Regex("\\s+"), " ")

}
