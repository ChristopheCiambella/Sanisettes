package eu.ciambella.sanisettes.present.common.mapper

import eu.ciambella.sanisettes.design.components.MarkerProperty
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette

class MarkerPropertyMapper {

    fun map(
        sanisette: Sanisette,
        onClick: () -> Unit,
    ) = MarkerProperty(
        latitude = sanisette.location.latitude,
        longitude = sanisette.location.longitude,
        title = sanisette.address,
        onClick = onClick
    )
}
