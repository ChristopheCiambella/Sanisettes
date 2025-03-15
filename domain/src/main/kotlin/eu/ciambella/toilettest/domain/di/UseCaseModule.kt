package eu.ciambella.toilettest.domain.di

import eu.ciambella.toilettest.domain.location.usecase.GetLocationUseCase
import eu.ciambella.toilettest.domain.toilet.usecase.GetToiletUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetToiletUseCase(get()) }
    single { GetLocationUseCase(get()) }
}
