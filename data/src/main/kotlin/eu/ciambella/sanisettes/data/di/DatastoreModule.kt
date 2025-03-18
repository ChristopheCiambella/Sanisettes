package eu.ciambella.sanisettes.data.di

import eu.ciambella.sanisettes.data.sanisette.datastore.RecordsDatastore
import eu.ciambella.sanisettes.data.sanisette.datastore.SearchDatastore
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val datastoreModule = module {
    singleOf(::RecordsDatastore)
    singleOf(::SearchDatastore)
}
