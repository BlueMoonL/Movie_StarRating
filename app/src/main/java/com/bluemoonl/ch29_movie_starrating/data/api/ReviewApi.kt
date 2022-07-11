package com.bluemoonl.ch29_movie_starrating.data.api

import com.bluemoonl.ch29_movie_starrating.domain.model.Review

interface ReviewApi {

    suspend fun getLatestReview(movieId: String): Review?
}