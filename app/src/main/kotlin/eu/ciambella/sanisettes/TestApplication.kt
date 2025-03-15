package eu.ciambella.sanisettes

import android.app.Application
import eu.ciambella.sanisettes.data.di.apiModule
import eu.ciambella.sanisettes.data.di.dataMapperModule
import eu.ciambella.sanisettes.data.di.datasourceModule
import eu.ciambella.sanisettes.data.di.datastoreModule
import eu.ciambella.sanisettes.data.di.repositoryModule
import eu.ciambella.sanisettes.di.appModule
import eu.ciambella.sanisettes.di.presentModule
import eu.ciambella.sanisettes.di.uiMapperModule
import eu.ciambella.sanisettes.di.viewModelModule
import eu.ciambella.sanisettes.domain.di.useCaseModule
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
