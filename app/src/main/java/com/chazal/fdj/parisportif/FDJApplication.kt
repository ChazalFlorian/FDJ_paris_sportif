package com.chazal.fdj.parisportif

import android.app.Application
import com.chazal.fdj.parisportif.inject.applicationModule
import com.chazal.fdj.parisportif.inject.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class FDJApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FDJApplication)
            modules(
                applicationModule,
                viewModelModule,
            )
        }
    }
}