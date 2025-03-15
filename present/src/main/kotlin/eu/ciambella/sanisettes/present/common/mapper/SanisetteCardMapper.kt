package eu.ciambella.sanisettes.present.common.mapper

import eu.ciambella.sanisettes.design.components.SanisetteCardProperty
import eu.ciambella.sanisettes.domain.sanisette.model.Sanisette

class SanisetteCardMapper {

    fun map(
        sanisette: Sanisette,
        onClick: () -> Unit,
    ) = SanisetteCardProperty(
        address = sanisette.address,
        openingHours = sanisette.openingHours,
        isPmr = sanisette.isPmr,
        distance = sanisette.distance,
        onClick = onClick
    )

}
