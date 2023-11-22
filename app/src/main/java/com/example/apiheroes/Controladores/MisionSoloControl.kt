package com.example.apiheroes.Controladores

import com.example.apiheroes.modelos.MisionSolo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MisionSoloControl {

    @GET("misionSolo")
    fun get(): Call<List<MisionSolo>>

    @GET("misionSolo/{id}")
    fun getById(@Path("id") id : Long): Call<MisionSolo>

    @POST("misionSolo")
    fun insert(@Body misionSolo: MisionSolo)

    @PUT("misionSolo/{id}")
    fun Update(@Path("id") id : Long, @Body misionSolo: MisionSolo)

    @DELETE("misionSolo/{id}")
    fun Delete(@Path("id") id : Long)

}