package com.bluemoonl.ch29_movie_starrating

import android.app.Application
import com.bluemoonl.ch29_movie_starrating.di.appModule
import com.bluemoonl.ch29_movie_starrating.di.dataModule
import com.bluemoonl.ch29_movie_starrating.di.domainModule
import com.bluemoonl.ch29_movie_starrating.di.presenterModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class MovieReviewApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.DEBUG
                } else {
                    Level.NONE
                }
            )
            androidContext(this@MovieReviewApplication)
            modules(appModule + dataModule + domainModule + presenterModule)
        }
    }
}