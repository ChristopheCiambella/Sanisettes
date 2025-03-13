package eu.ciambella.toilettest.data.di

import eu.ciambella.toilettest.data.api.DataRatpApiService
import eu.ciambella.toilettest.data.api.DataRatpWebService
import org.koin.dsl.module

val apiModule = module {
    single<DataRatpApiService> { DataRatpWebService().api }
}
