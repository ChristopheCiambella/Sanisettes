package eu.ciambella.sanisettes.di

import eu.ciambella.sanisettes.present.screen.list.SanisetteListViewModel
import eu.ciambella.sanisettes.present.screen.maps.SanisetteMapsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::SanisetteListViewModel)
    viewModelOf(::SanisetteMapsViewModel)
}
