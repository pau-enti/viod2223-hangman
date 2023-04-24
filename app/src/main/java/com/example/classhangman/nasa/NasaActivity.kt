package com.example.classhangman.nasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.classhangman.databinding.ActivityNasaBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NasaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNasaBinding
    private val theOutside = Retrofit.Builder()
        .baseUrl("https://images-api.nasa.gov/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNasaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val api = theOutside.create(APINasa::class.java)
        val call = api.searchNasaImages("Milky Way")

        call.enqueue(object : Callback<NasaImagesCollection> {
            override fun onResponse(
                call: Call<NasaImagesCollection>,
                response: Response<NasaImagesCollection>
            ) {
                val imagesList = response.body()?.collection?.items?.mapNotNull {
                    val title = it.data?.getOrNull(0)?.title ?: return@mapNotNull null
                    val desc = it.data?.getOrNull(0)?.description ?: return@mapNotNull null
                    val link = it.links?.getOrNull(0)?.href ?: return@mapNotNull null

                    NasaImage(title, desc, link)
                }

                imagesList?.forEach {
                    println(it.link)
                }


//                println(imageLink)
//
//                Picasso.Builder(this@NasaActivity)
//                    .build()
//                    .load(imageLink)
//                    .into(binding.imageView)
            }

            override fun onFailure(call: Call<NasaImagesCollection>, t: Throwable) {

            }

        })

    }
}