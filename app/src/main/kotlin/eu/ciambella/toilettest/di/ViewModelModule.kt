package eu.ciambella.toilettest.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import eu.ciambella.toilettest.present.screen.list.ToiletListViewModel

val viewModelModule = module {
    viewModelOf(::ToiletListViewModel)
}
