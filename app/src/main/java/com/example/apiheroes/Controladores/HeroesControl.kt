package com.example.apiheroes.Controladores

import com.example.apiheroes.modelos.Heroes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface HeroesControl {
    @GET("heroe")
    fun get():Call<MutableList<Heroes>>

    @GET("heroe/{id}")
    fun getById(@Path("id") id : Int):Call<MutableList<Heroes>>

    @POST("heroe")
    fun insert(@Body heroe:Heroes):Call<Heroes>

    @PUT("heroe/{id}")
    fun Update(@Path("id") id : Int , @Body heroe: Heroes ):Call<Heroes>

    @DELETE("heroe/{id}")
    fun Delete(@Path("id") id : Int):Call<Heroes>
}