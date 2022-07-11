package com.bluemoonl.ch29_movie_starrating.data.repository

import com.bluemoonl.ch29_movie_starrating.domain.model.Review

interface ReviewRepository {

    suspend fun getLatestReview(movieId: String): Review?
}