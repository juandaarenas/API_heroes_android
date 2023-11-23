package com.example.apiheroes.Controladores

import com.example.apiheroes.modelos.Poderes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PoderesControl {

    @GET("poderes")
    fun get(): Call<MutableList<Poderes>>

    @GET("poderes/{id}")
    fun getById(@Path("id") id : Int): Call<MutableList<Poderes>>

    @POST("poderes")
    fun insert(@Body poderes: Poderes): Call<Poderes>

    @PUT("poderes/{id}")
    fun Update(@Path("id") id : Int, @Body poderes: Poderes)

    @DELETE("poderes/{id}")
    fun Delete(@Path("id") id : Int)

}