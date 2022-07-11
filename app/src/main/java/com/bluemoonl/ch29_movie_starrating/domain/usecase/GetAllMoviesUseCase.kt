package com.bluemoonl.ch29_movie_starrating.domain.usecase

import com.bluemoonl.ch29_movie_starrating.data.repository.MovieRepository
import com.bluemoonl.ch29_movie_starrating.domain.model.Movie

class GetAllMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(): List<Movie> = movieRepository.getAllMovies()
}