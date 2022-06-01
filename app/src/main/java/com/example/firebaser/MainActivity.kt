package com.example.firebaser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.json.JSONArray
import com.example.firebaser.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val database = Firebase.database
        val dataRef = database.reference
        binding.BtnInsertar.setOnClickListener{
            dataRef.child("Peliculas").child(binding.ID.text.toString()).setValue(
                Peliculas(
                    binding.EnTitulo.text.toString(),
                    binding.EnAo.text.toString(),
                    binding.EnIMBDID.text.toString(),
                    binding.EnTipo.text.toString(),
                    binding.EnProductor.text.toString(),
                    binding.EnPais.text.toString(),
                    binding.EnGenero.text.toString()
                )
            )
            dataRef.child("Peliculas").get().addOnSuccessListener {respuesta ->
                Log.d("respuesta", respuesta.value.toString())
                val lista = JSONArray(respuesta.value.toString())
                binding.RPelicula.adapter = MainAdapter(lista)
            }
        }
1
    }
}