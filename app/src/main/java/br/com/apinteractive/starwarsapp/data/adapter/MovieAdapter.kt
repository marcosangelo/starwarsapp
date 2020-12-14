package br.com.apinteractive.starwarsapp.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.apinteractive.starwarsapp.R
import br.com.apinteractive.starwarsapp.data.model.Movie
import kotlinx.android.synthetic.main.list_item_movies.view.*

class MovieAdapter(
    private val Film: List<Movie>,
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_movies,
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun getItemCount() = Film.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(Film[position])
    }

    fun itemClickListener(ic: ItemClickListener) {
        this.itemClickListener = ic
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        fun bindView(film: Movie) {
            val title = itemView.txtItemTitle
            val director = itemView.txtItemDirector

            itemView.setOnClickListener(this)

            title.text = film.filmTitle
            director.text = film.director
        }

        override fun onClick(view: View?) {
            itemClickListener?.onItemClick(view!!, layoutPosition)
        }
    }
}
