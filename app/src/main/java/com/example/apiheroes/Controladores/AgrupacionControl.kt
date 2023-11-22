package com.example.apiheroes.Controladores

import com.example.apiheroes.modelos.Agrupacion
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AgrupacionControl {
    @GET("agrupacion")
    fun get(): Call<List<Agrupacion>>

    @GET("agrupacion/{id}")
    fun getById(@Path("id") id : Long): Call<Agrupacion>

    @POST("agrupacion")
    fun insert(@Body agrupacion: Agrupacion)

    @PUT("agrupacion/{id}")
    fun Update(@Path("id") id : Long, @Body agrupacion: Agrupacion)

    @DELETE("agrupacion/{id}")
    fun Delete(@Path("id") id : Long)
}