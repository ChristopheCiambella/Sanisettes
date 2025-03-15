package eu.ciambella.toilettest

import android.app.Application
import eu.ciambella.toilettest.data.di.apiModule
import eu.ciambella.toilettest.data.di.dataMapperModule
import eu.ciambella.toilettest.data.di.datasourceModule
import eu.ciambella.toilettest.data.di.datastoreModule
import eu.ciambella.toilettest.data.di.repositoryModule
import eu.ciambella.toilettest.di.appModule
import eu.ciambella.toilettest.di.presentModule
import eu.ciambella.toilettest.di.uiMapperModule
import eu.ciambella.toilettest.di.viewModelModule
import eu.ciambella.toilettest.domain.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@TestApplication)
            modules(
                listOf(
                    useCaseModule,
                    appModule,
                    apiModule,
                    datasourceModule,
                    datastoreModule,
                    dataMapperModule,
                    repositoryModule,
                    viewModelModule,
                    uiMapperModule,
                    presentModule,
                )
            )
        }
    }

}
