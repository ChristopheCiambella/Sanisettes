package eu.ciambella.toilettest.data.di

import eu.ciambella.toilettest.data.toilet.datastore.SanisettesDatastore
import org.koin.dsl.module

val datastoreModule = module {
    single<SanisettesDatastore> { SanisettesDatastore(get(), get(), get()) }
}
