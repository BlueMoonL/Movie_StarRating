package com.bluemoonl.ch29_movie_starrating.data.repository

import com.bluemoonl.ch29_movie_starrating.data.api.ReviewApi
import com.bluemoonl.ch29_movie_starrating.domain.model.Review
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class ReviewRepositoryImpl(
    private val reviewApi: ReviewApi,
    private val dispatchers: CoroutineDispatcher
) : ReviewRepository {

    override suspend fun getLatestReview(movieId: String): Review? = withContext(dispatchers) {
        reviewApi.getLatestReview(movieId)
    }
}