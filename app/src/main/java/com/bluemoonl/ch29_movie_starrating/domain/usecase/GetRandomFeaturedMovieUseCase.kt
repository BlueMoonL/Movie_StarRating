package com.bluemoonl.ch29_movie_starrating.domain.usecase

import com.bluemoonl.ch29_movie_starrating.data.repository.MovieRepository
import com.bluemoonl.ch29_movie_starrating.data.repository.ReviewRepository
import com.bluemoonl.ch29_movie_starrating.domain.model.FeaturedMovie

class GetRandomFeaturedMovieUseCase(
    private val movieRepository: MovieRepository,
    private val reviewRepository: ReviewRepository
) {

    suspend operator fun invoke(): FeaturedMovie? {
        val featuredMovies = movieRepository.getAllMovies()
            .filter { it.id.isNullOrBlank().not() }
            .filter { it.isFeatured == true }

        if (featuredMovies.isNullOrEmpty()) {
            return null
        }

        return featuredMovies.random()
            .let { movie ->
                val latestReview = reviewRepository.getLatestReview(movie.id!!)
                FeaturedMovie(movie, latestReview)
            }
    }
}