package com.bluemoonl.ch29_movie_starrating.presentation.home

import com.bluemoonl.ch29_movie_starrating.domain.model.FeaturedMovie
import com.bluemoonl.ch29_movie_starrating.domain.model.Movie
import com.bluemoonl.ch29_movie_starrating.presentation.BasePresenter
import com.bluemoonl.ch29_movie_starrating.presentation.BaseView

interface HomeContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun hideLoadingIndicator()

        fun showErrorDescription(message: String)

        fun showMovies(
            featuredMovie: FeaturedMovie?,
            movies: List<Movie>
        )
    }

    interface Presenter : BasePresenter
}