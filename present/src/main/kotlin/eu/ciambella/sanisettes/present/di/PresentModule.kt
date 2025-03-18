package eu.ciambella.sanisettes.present.di

import eu.ciambella.sanisettes.present.screen.maps.MapsViewModel.UseCases
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val presentModule = module {
    singleOf(::UseCases)
}
