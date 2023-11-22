package com.example.apiheroes.Controladores

import com.example.apiheroes.modelos.Planeta
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PlanetaControl {

    @GET("planeta")
    fun get(): Call<List<Planeta>>

    @GET("planeta/{id}")
    fun getById(@Path("id") id : Int): Call<List<Planeta>>

    @POST("planeta")
    fun insert(@Body planeta: Planeta): Call<Planeta>

    @PUT("planeta/{id}")
    fun Update(@Path("id") id : Int, @Body planeta: Planeta)

    @DELETE("planeta/{id}")
    fun Delete(@Path("id") id : Int)

}