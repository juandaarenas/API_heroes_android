package com.example.apiheroes.Controladores

import com.example.apiheroes.modelos.PoderesHeroes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PoderesHeroesControl {

    @GET("poderHeroe")
    fun get(): Call<List<PoderesHeroes>>

    @GET("poderHeroe/{id}")
    fun getById(@Path("id") id : Long): Call<PoderesHeroes>

    @POST("poderHeroe")
    fun insert(@Body poderHeroe: PoderesHeroes)

    @PUT("poderHeroe/{id}")
    fun Update(@Path("id") id : Long, @Body poderHeroe: PoderesHeroes)

    @DELETE("poderHeroe/{id}")
    fun Delete(@Path("id") id : Long)

}