package eu.ciambella.sanisettes.present.di

import eu.ciambella.sanisettes.present.screen.maps.SanisetteMapsViewModel.UseCases
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val presentModule = module {
    singleOf(::UseCases)
}
