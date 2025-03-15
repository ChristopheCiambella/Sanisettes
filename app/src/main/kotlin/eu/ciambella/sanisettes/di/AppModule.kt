package eu.ciambella.sanisettes.di

import eu.ciambella.sanisettes.domain.location.LocationProvider
import eu.ciambella.sanisettes.domain.utils.CoroutineDispatcherProvider
import eu.ciambella.sanisettes.present.common.navigation.NavigationConsumer
import eu.ciambella.sanisettes.present.common.navigation.ActionHandler
import eu.ciambella.sanisettes.present.common.navigation.MainNavigator
import eu.ciambella.sanisettes.provider.LocationProviderImpl
import org.koin.dsl.module

val appModule = module {
    single { CoroutineDispatcherProvider() }
    single { NavigationConsumer(get()) }
    single { MainNavigator() }
    single { ActionHandler(get()) }
    single<LocationProvider> { LocationProviderImpl(get()) }
}
