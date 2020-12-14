package br.com.apinteractive.starwarsapp.ui.helpers

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import br.com.apinteractive.starwarsapp.R

fun getNavControllerMain(activity: Activity): NavController {
    return Navigation.findNavController(activity, R.id.navHostActivityMain)
}