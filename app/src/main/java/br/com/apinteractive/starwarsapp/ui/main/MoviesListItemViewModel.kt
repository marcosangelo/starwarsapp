package br.com.apinteractive.starwarsapp.ui.main

import br.com.apinteractive.starwarsapp.data.model.MoviesHeader

class MoviesListItemViewModel(val header: MoviesHeader) {

    private var cb: (() -> Any?)? = null

    fun onClick(cab: () -> Any?) {
        cb = cab
    }

    fun triggerClick() {
        cb?.invoke()
    }
}