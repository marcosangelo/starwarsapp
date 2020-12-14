package br.com.apinteractive.starwarsapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.apinteractive.starwarsapp.data.adapter.ItemClickListener
import br.com.apinteractive.starwarsapp.data.adapter.MovieAdapter
import br.com.apinteractive.starwarsapp.data.model.Movie
import br.com.apinteractive.starwarsapp.databinding.MainFragmentBinding
import br.com.apinteractive.starwarsapp.ui.helpers.getNavControllerMain

class MainFragment : Fragment() {


    lateinit var binding: MainFragmentBinding

    private val viewModel: MainViewModel by viewModels()
    private val navController by lazy { getNavControllerMain(requireActivity()) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.allMovies.observe(viewLifecycleOwner, {
            if (it != null) {
                setUpRecyclerView(it)
            }
        })
    }


    private fun setUpRecyclerView(movies: List<Movie>) {
        val movieAdapter = MovieAdapter(movies)
        binding.rcMovies.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(activity)
        }
        movieAdapter.notifyDataSetChanged()
        movieAdapter.itemClickListener(object :
            ItemClickListener {
            override fun onItemClick(
                view: View, position: Int
            ) {
                val action =
                    MainFragmentDirections.actionNavigationHomeToMovieDetailFragment(movie = movies[position])
                navController.navigate(action)
            }
        })
    }

}