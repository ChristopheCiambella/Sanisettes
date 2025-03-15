package eu.ciambella.toilettest.present.common.mapper

import eu.ciambella.design.toilettest.components.SanisetteCardProperty
import eu.ciambella.toilettest.domain.toilet.model.Sanisette

class SanisetteCardMapper {

    fun map(
        toilet: Sanisette,
        onClick: () -> Unit,
    ) = SanisetteCardProperty(
        address = toilet.address,
        openingHours = toilet.openingHours,
        isPmr = toilet.isPmr,
        distance = toilet.distance,
        onClick = onClick
    )

}
