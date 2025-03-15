package eu.ciambella.toilettest.data.di

import eu.ciambella.toilettest.data.location.LocationRepositoryImpl
import eu.ciambella.toilettest.data.toilet.SanisettesRepositoryImpl
import eu.ciambella.toilettest.domain.location.LocationRepository
import eu.ciambella.toilettest.domain.toilet.SanisettesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<SanisettesRepository> { SanisettesRepositoryImpl(get()) }
    single<LocationRepository> { LocationRepositoryImpl(get()) }
}
