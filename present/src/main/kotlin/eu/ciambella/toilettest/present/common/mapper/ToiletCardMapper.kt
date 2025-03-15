package eu.ciambella.toilettest.present.common.mapper

import eu.ciambella.design.toilettest.components.ToiletCardProperty
import eu.ciambella.toilettest.domain.toilet.model.Toilet

class ToiletCardMapper {

    fun map(
        toilet: Toilet,
    ) = ToiletCardProperty(
        address = toilet.address,
        openingHours = toilet.openingHours,
        isPmr = toilet.isPmr,
        isBaby = toilet.isBaby,
        distance = toilet.distance
    )

}
