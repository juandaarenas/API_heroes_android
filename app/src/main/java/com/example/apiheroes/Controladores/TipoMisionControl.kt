package com.example.apiheroes.Controladores

import com.example.apiheroes.modelos.TipoMision
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TipoMisionControl {

    @GET("tipoMision")
    fun get(): Call<MutableList<TipoMision>>

    @GET("tipoMision/{id}")
    fun getById(@Path("id") id : Int): Call<MutableList<TipoMision>>

    @POST("tipoMision")
    fun insert(@Body tipoMision: TipoMision): Call<TipoMision>

    @PUT("tipoMision/{id}")
    fun Update(@Path("id") id : Int, @Body tipoMision: TipoMision)

    @DELETE("tipoMision/{id}")
    fun Delete(@Path("id") id : Int)

}