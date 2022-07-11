package com.bluemoonl.ch29_movie_starrating.data.api

import com.bluemoonl.ch29_movie_starrating.domain.model.Movie

interface MovieApi {

    suspend fun getAllMovies(): List<Movie>
}