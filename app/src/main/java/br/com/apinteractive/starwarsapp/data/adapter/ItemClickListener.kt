package br.com.apinteractive.starwarsapp.data.adapter

import android.view.View

interface ItemClickListener {
    fun onItemClick(view: View, position: Int)
}