package eu.ciambella.toilettest.di

import eu.ciambella.toilettest.domain.utils.CoroutineDispatcherProvider
import eu.ciambella.toilettest.navigation.NavigationConsumer
import eu.ciambella.toilettest.present.common.navigation.ActionHandler
import eu.ciambella.toilettest.present.common.navigation.MainNavigator
import org.koin.dsl.module

val appModule = module {
    single { CoroutineDispatcherProvider() }
    single { NavigationConsumer() }
    single { MainNavigator() }
    single { ActionHandler(get()) }
}
