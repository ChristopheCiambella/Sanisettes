package eu.ciambella.toilettest.data.di

import eu.ciambella.toilettest.data.network.ToiletApiService
import eu.ciambella.toilettest.data.network.ToiletWebService
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val apiModule = module {
    single {
        Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
            explicitNulls = false
        }
    }
    single<ToiletApiService> { ToiletWebService(get()).api }
}
