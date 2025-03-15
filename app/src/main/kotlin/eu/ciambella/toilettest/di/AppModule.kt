package eu.ciambella.toilettest.di

import eu.ciambella.toilettest.domain.utils.CoroutineDispatcherProvider
import org.koin.dsl.module

val appModule = module {
    single { CoroutineDispatcherProvider() }
}
