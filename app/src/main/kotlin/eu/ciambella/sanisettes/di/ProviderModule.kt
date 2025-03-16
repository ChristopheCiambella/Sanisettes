package eu.ciambella.sanisettes.di

import eu.ciambella.sanisettes.domain.location.LocationProvider
import eu.ciambella.sanisettes.domain.logger.LoggerProvider
import eu.ciambella.sanisettes.provider.location.LocationProviderImpl
import eu.ciambella.sanisettes.provider.logger.AndroidLoggerProvider
import org.koin.dsl.module

val providerModule = module {
    single<LocationProvider> { LocationProviderImpl(get()) }
    single<LoggerProvider> { AndroidLoggerProvider() }
}
