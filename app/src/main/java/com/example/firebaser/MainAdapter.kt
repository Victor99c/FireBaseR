package com.example.firebaser

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject
import com.example.firebaser.databinding.ItemMovieBinding

class MainAdapter(private val peliculas: JSONArray): RecyclerView.Adapter<MainAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int){
        if(peliculas[position].toString() == "null"){
            Log.e("Hola","Entra")
        }else{
            holder.render(peliculas[position] as JSONObject)
        }
    }

    override fun getItemCount(): Int = peliculas.length()

    class MainHolder(val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root){
        fun render(movie: JSONObject){
            binding.ivTitulo.setText(movie.getString("titulo"))
            binding.ivPais.setText(movie.getString("pais"))
            binding.ivGenero.setText(movie.getString("genero"))
            binding.ivAo.setText(movie.getString("ao"))
            binding.ivCartel.setImageResource(R.drawable.movie_item)
        }
    }
}