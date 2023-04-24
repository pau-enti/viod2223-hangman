package com.example.classhangman.nasa

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APINasa {

    @GET("search")
    fun searchNasaImages(@Query("q") query: String): Call<NasaImagesCollection>
}