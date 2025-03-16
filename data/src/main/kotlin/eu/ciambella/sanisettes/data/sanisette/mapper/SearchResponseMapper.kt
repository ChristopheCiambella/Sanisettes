package eu.ciambella.sanisettes.data.sanisette.mapper

import eu.ciambella.sanisettes.data.network.response.SearchResponse
import eu.ciambella.sanisettes.domain.location.model.Location
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

class SearchResponseMapper(
    private val sanisetteMapper: SanisetteMapper,
) {

    fun map(
        response: SearchResponse,
        currentLocation: Location?,
        offset: Int
    ): Sanisettes {
        val nextOffset = offset + response.records.size
        return Sanisettes(
            sanisettes = response.records.mapNotNull {
                sanisetteMapper.map(it.fields, currentLocation)
            },
            nextOffset = if (nextOffset >= response.nhits) {
                null
            } else {
                nextOffset
            }
        )
    }
}
