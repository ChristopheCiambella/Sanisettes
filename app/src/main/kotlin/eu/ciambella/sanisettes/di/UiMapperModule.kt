package eu.ciambella.sanisettes.di

import eu.ciambella.sanisettes.present.common.mapper.ErrorPropertyMapper
import eu.ciambella.sanisettes.present.common.mapper.NavigationBarPropertyMapper
import eu.ciambella.sanisettes.present.common.mapper.SanisetteCardMapper
import eu.ciambella.sanisettes.present.screen.list.SanisetteListScreenMapper
import eu.ciambella.sanisettes.present.screen.maps.SanisetteMapsScreenMapper
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val uiMapperModule = module {
    singleOf(::NavigationBarPropertyMapper)
    singleOf(::SanisetteListScreenMapper)
    singleOf(::SanisetteMapsScreenMapper)
    singleOf(::SanisetteCardMapper)
    singleOf(::ErrorPropertyMapper)
}
