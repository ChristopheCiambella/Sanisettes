package eu.ciambella.sanisettes.domain.di

import eu.ciambella.sanisettes.domain.sanisette.usecase.GetSanisettesUseCase
import eu.ciambella.sanisettes.domain.sanisette.usecase.SearchSanisettesUseCase
import eu.ciambella.sanisettes.domain.sanisette.usecase.ShouldFetchNewLocationDataUseCase
import eu.ciambella.sanisettes.domain.settings.usecase.ChangeOnlyFilterEnableUseCase
import eu.ciambella.sanisettes.domain.settings.usecase.PmrOnlyFilterEnableUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::GetSanisettesUseCase)
    singleOf(::SearchSanisettesUseCase)
    singleOf(::ShouldFetchNewLocationDataUseCase)
    singleOf(::PmrOnlyFilterEnableUseCase)
    singleOf(::ChangeOnlyFilterEnableUseCase)
}
