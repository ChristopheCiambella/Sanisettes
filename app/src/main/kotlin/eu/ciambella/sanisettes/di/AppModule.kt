package eu.ciambella.sanisettes.di

import eu.ciambella.sanisettes.domain.utils.CoroutineDispatcherProvider
import eu.ciambella.sanisettes.present.common.navigation.ActionHandler
import eu.ciambella.sanisettes.present.common.navigation.MainNavigator
import eu.ciambella.sanisettes.present.common.navigation.NavigationConsumer
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::CoroutineDispatcherProvider)
    singleOf(::NavigationConsumer)
    singleOf(::MainNavigator)
    singleOf(::ActionHandler)
}
