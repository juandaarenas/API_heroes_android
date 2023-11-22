package com.example.apiheroes.Controladores

import com.example.apiheroes.modelos.Equipo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface EquipoControl {
    @GET("equipo")
    fun get(): Call<List<Equipo>>

    @GET("equipo/{id}")
    fun getById(@Path("id") id : Long): Call<Equipo>

    @POST("equipo")
    fun insert(@Body equipo: Equipo)

    @PUT("equipo/{id}")
    fun Update(@Path("id") id : Long, @Body equipo: Equipo)

    @DELETE("equipo/{id}")
    fun Delete(@Path("id") id : Long)
}