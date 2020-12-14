package br.com.apinteractive.starwarsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setSupportActionBar(findViewById(R.id.include_toolbar_appbar))

        val navHostActivityMain = navHostActivityMain as NavHostFragment

        navHostActivityMain.navController
            .addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.navigation_home,
                    R.id.movieDetailFragment -> {
                    }
                    else -> {
                        supportActionBar?.elevation = 4f
                    }
                }
            }

    }

    override fun onSupportNavigateUp() = findNavController(R.id.navHostActivityMain).navigateUp()

}