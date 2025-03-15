package eu.ciambella.toilettest.present.common.mapper

import eu.ciambella.design.toilettest.components.ToiletCardProperty
import eu.ciambella.toilettest.domain.toilet.model.Sanisette

class ToiletCardMapper {

    fun map(
        toilet: Sanisette,
    ) = ToiletCardProperty(
        address = toilet.address,
        openingHours = toilet.openingHours,
        isPmr = toilet.isPmr,
        isBaby = toilet.isBaby,
        distance = toilet.distance
    )

}
