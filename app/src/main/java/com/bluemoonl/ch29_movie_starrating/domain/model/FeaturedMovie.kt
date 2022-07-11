package com.bluemoonl.ch29_movie_starrating.domain.model

data class FeaturedMovie(
    val movie: Movie,
    val latestReview: Review?
)