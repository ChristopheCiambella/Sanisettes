package eu.ciambella.sanisettes.data.di

import eu.ciambella.sanisettes.data.sanisette.SanisettesRepositoryImpl
import eu.ciambella.sanisettes.domain.sanisette.SanisettesRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<SanisettesRepository> { SanisettesRepositoryImpl(get()) }
}
