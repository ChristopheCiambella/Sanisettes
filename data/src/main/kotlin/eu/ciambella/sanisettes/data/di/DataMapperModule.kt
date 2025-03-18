package eu.ciambella.sanisettes.data.di

import eu.ciambella.sanisettes.data.sanisette.mapper.RecordsResponseMapper
import eu.ciambella.sanisettes.data.sanisette.mapper.SanisetteMapper
import eu.ciambella.sanisettes.data.sanisette.mapper.SearchResponseMapper
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataMapperModule = module {
    singleOf(::RecordsResponseMapper)
    singleOf(::SearchResponseMapper)
    singleOf(::SanisetteMapper)
}
