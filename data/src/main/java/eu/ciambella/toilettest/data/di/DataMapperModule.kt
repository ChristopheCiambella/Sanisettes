package eu.ciambella.toilettest.data.di

import eu.ciambella.toilettest.data.toilet.mapper.ToiletResponseMapper
import org.koin.dsl.module

val dataMapperModule = module {
    single { ToiletResponseMapper() }
}
