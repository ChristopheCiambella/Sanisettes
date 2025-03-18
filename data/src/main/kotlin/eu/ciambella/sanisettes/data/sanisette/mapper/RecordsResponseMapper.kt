package eu.ciambella.sanisettes.data.sanisette.mapper

import eu.ciambella.sanisettes.data.network.response.RecordsResponse
import eu.ciambella.sanisettes.domain.location.model.Location
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisettes

class RecordsResponseMapper(
    private val sanisetteMapper: SanisetteMapper
) {

    fun map(
        response: RecordsResponse,
        currentLocation: Location?,
        offset: Int
    ): Sanisettes {
        val nextOffset = offset + response.results.size
        return Sanisettes(
            sanisettes = response.results.mapNotNull {
                sanisetteMapper.map(it, currentLocation)
            },
            nextOffset = if (nextOffset >= response.totalCount) {
                null
            } else {
                nextOffset
            }
        )
    }
}
