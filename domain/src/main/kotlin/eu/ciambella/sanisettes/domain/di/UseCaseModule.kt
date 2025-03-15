package eu.ciambella.sanisettes.domain.di

import eu.ciambella.sanisettes.domain.sanisette.usecase.GetSanisettesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetSanisettesUseCase(get()) }
}
