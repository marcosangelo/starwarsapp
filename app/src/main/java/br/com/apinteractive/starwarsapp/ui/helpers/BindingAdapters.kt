package br.com.apinteractive.starwarsapp.ui.helpers

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * Data binding que esconde uma View caso o valor booleano recebido seja true.
 */
@BindingAdapter("app_hidden")
fun hidden(view: View, shouldHide: Boolean) {
    view.visibility = if (shouldHide) View.GONE else View.VISIBLE
}