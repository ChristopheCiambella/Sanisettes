package eu.ciambella.toilettest.di

import eu.ciambella.toilettest.present.screen.list.ToiletListViewModel
import eu.ciambella.toilettest.present.screen.maps.ToiletMapsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::ToiletListViewModel)
    viewModelOf(::ToiletMapsViewModel)
}
