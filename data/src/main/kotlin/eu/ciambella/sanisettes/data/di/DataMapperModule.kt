package eu.ciambella.sanisettes.data.di

import eu.ciambella.sanisettes.data.sanisette.mapper.SanisetteResponseMapper
import org.koin.dsl.module

val dataMapperModule = module {
    single { SanisetteResponseMapper() }
}
