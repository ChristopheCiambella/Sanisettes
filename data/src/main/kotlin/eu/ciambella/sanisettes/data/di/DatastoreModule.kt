package eu.ciambella.sanisettes.data.di

import eu.ciambella.sanisettes.data.sanisette.datastore.SanisettesDatastore
import org.koin.dsl.module

val datastoreModule = module {
    single<SanisettesDatastore> { SanisettesDatastore(get(), get(), get()) }
}
