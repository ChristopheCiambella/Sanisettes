package eu.ciambella.sanisettes.data.di

import eu.ciambella.sanisettes.data.sanisette.datastore.SanisettesDatastore
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val datastoreModule = module {
    singleOf(::SanisettesDatastore)
}
