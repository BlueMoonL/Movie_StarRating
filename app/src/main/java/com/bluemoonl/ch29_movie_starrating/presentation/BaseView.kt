package com.bluemoonl.ch29_movie_starrating.presentation

interface BaseView<PresenterT : BasePresenter> {

    val presenter: PresenterT
}