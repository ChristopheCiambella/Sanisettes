package eu.ciambella.sanisettes.di

import eu.ciambella.sanisettes.present.screen.details.DetailsViewModel
import eu.ciambella.sanisettes.present.screen.list.ListViewModel
import eu.ciambella.sanisettes.present.screen.maps.MapsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::ListViewModel)
    viewModelOf(::MapsViewModel)
    viewModelOf(::DetailsViewModel)
}
