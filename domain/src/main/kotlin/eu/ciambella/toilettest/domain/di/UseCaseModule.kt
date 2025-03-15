package eu.ciambella.toilettest.domain.di

import eu.ciambella.toilettest.domain.toilet.usecase.GetSanisettesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetSanisettesUseCase(get()) }
}
