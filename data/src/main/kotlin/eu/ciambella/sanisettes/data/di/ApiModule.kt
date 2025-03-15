package eu.ciambella.sanisettes.data.di

import eu.ciambella.sanisettes.data.network.SanisettesParisApiService
import eu.ciambella.sanisettes.data.network.SanisettesParisWebService
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
    single<SanisettesParisApiService> { SanisettesParisWebService(get()).api }
}
