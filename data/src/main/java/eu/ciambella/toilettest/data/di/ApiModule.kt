package eu.ciambella.toilettest.data.di

import eu.ciambella.toilettest.data.network.ToiletApiService
import eu.ciambella.toilettest.data.network.ToiletWebService
import org.koin.dsl.module

val apiModule = module {
    single<ToiletApiService> { ToiletWebService().api }
}
