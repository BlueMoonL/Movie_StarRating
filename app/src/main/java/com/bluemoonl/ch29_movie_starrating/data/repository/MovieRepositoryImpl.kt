package com.bluemoonl.ch29_movie_starrating.data.repository

import com.bluemoonl.ch29_movie_starrating.data.api.MovieApi
import com.bluemoonl.ch29_movie_starrating.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class MovieRepositoryImpl(
    private val movieApi: MovieApi,
    private val dispatchers: CoroutineDispatcher
) : MovieRepository {

    override suspend fun getAllMovies(): List<Movie> = withContext(dispatchers) {
        movieApi.getAllMovies()
    }
}