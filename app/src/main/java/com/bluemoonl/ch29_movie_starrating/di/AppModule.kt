package com.bluemoonl.ch29_movie_starrating.di

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.bluemoonl.ch29_movie_starrating.data.api.MovieApi
import com.bluemoonl.ch29_movie_starrating.data.api.MovieFirestoreApi
import com.bluemoonl.ch29_movie_starrating.data.api.ReviewApi
import com.bluemoonl.ch29_movie_starrating.data.api.ReviewFirestoreApi
import com.bluemoonl.ch29_movie_starrating.data.repository.MovieRepository
import com.bluemoonl.ch29_movie_starrating.data.repository.MovieRepositoryImpl
import com.bluemoonl.ch29_movie_starrating.data.repository.ReviewRepository
import com.bluemoonl.ch29_movie_starrating.data.repository.ReviewRepositoryImpl
import com.bluemoonl.ch29_movie_starrating.domain.usecase.GetAllMoviesUseCase
import com.bluemoonl.ch29_movie_starrating.domain.usecase.GetRandomFeaturedMovieUseCase
import com.bluemoonl.ch29_movie_starrating.presentation.home.HomeFragment
import com.bluemoonl.ch29_movie_starrating.presentation.home.HomeContract
import com.bluemoonl.ch29_movie_starrating.presentation.home.HomePresenter
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val appModule = module {
    single { Dispatchers.IO }
}

val dataModule = module {
    single { Firebase.firestore }

    single<MovieApi> { MovieFirestoreApi(get()) }
    single<ReviewApi> { ReviewFirestoreApi(get()) }

    single<MovieRepository> { MovieRepositoryImpl(get(), get()) }
    single<ReviewRepository> { ReviewRepositoryImpl(get(), get()) }
}

val domainModule = module {
    factory { GetRandomFeaturedMovieUseCase(get(), get()) }
    factory { GetAllMoviesUseCase(get()) }
}

val presenterModule = module {
    scope<HomeFragment> {
        scoped<HomeContract.Presenter> { HomePresenter(getSource()!!, get(), get()) }
    }
}