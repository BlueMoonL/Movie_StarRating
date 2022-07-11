package com.bluemoonl.ch29_movie_starrating.data.repository

import com.bluemoonl.ch29_movie_starrating.domain.model.Movie

interface MovieRepository {

    suspend fun getAllMovies(): List<Movie>
}