package eu.ciambella.toilettest.data.toilet.mapper

import eu.ciambella.toilettest.data.network.response.ToiletResponse
import eu.ciambella.toilettest.domain.toilet.model.Toilet

class ToiletResponseMapper {

    companion object {
        private const val LONGITUDE_INDEX = 0
        private const val LATITUDE_INDEX = 1
    }

    fun mapToToilet(
        response: ToiletResponse
    ): List<Toilet> = response.records.map {
        Toilet(
            address = it.fields.adresse,
            longitude = it.geometry.coordinates[LONGITUDE_INDEX],
            latitude = it.geometry.coordinates[LATITUDE_INDEX]
        )
    }

}
