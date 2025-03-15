package eu.ciambella.toilettest.di

import eu.ciambella.toilettest.present.common.mapper.NavigationBarPropertyMapper
import eu.ciambella.toilettest.present.common.mapper.ScaffoldPropertyMapper
import eu.ciambella.toilettest.present.common.mapper.ToiletCardMapper
import eu.ciambella.toilettest.present.screen.list.ToiletListScreenMapper
import eu.ciambella.toilettest.present.screen.maps.ToiletMapsScreenMapper
import org.koin.dsl.module

val uiMapperModule = module {
    single { ScaffoldPropertyMapper() }
    single { NavigationBarPropertyMapper() }
    single { ToiletListScreenMapper(get(), get()) }
    single { ToiletMapsScreenMapper(get()) }
    single { ToiletCardMapper() }
}
