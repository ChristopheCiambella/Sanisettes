package eu.ciambella.sanisettes.data.di

import eu.ciambella.sanisettes.data.network.DataRATPParisApiService
import eu.ciambella.sanisettes.data.network.DataRATPParisWebService
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
    single<DataRATPParisApiService> { DataRATPParisWebService(get()).api }
}
