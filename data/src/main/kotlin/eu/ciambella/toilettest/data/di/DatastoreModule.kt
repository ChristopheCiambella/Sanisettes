package eu.ciambella.toilettest.data.di

import eu.ciambella.toilettest.data.toilet.datastore.ToiletDatastore
import org.koin.dsl.module

val datastoreModule = module {
    single<ToiletDatastore> { ToiletDatastore(get(), get()) }
}
