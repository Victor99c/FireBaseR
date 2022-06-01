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
        val dbase = Firebase.database
        val dRef = dbase.reference
        binding.BtnInsertar.setOnClickListener{
            dRef.child("Pelicula").child(binding.ID.text.toString()).setValue(
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
            dRef.child("Pelicula").get().addOnSuccessListener {respuesta ->
                val lista = JSONArray(respuesta.value.toString())
                Log.d("respuesta", respuesta.toString())
                binding.RPelicula.adapter = MainAdapter(lista)
            }
        }
1
    }
}