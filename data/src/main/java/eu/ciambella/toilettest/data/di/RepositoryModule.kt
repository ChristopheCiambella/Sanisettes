package eu.ciambella.toilettest.data.di

import eu.ciambella.toilettest.data.toilet.ToiletRepositoryImpl
import eu.ciambella.toilettest.domain.toilet.ToiletRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ToiletRepository> { ToiletRepositoryImpl(get()) }
}
