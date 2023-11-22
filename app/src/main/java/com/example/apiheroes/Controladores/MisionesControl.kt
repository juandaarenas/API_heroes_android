package com.example.apiheroes.Controladores

import com.example.apiheroes.modelos.Misiones
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MisionesControl {

    @GET("mision")
    fun get(): Call<List<Misiones>>

    @GET("mision/{id}")
    fun getById(@Path("id") id : Long): Call<List<Misiones>>

    @POST("mision")
    fun insert(@Body mision: Misiones): Call<Misiones>

    @PUT("mision/{id}")
    fun Update(@Path("id") id : Long, @Body mision: Misiones)

    @DELETE("mision/{id}")
    fun Delete(@Path("id") id : Long)

}