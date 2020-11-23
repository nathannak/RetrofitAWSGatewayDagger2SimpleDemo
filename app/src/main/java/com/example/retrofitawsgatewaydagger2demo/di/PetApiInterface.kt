package com.example.retrofitawsgatewaydagger2demo.di

import com.example.retrofitawsgatewaydagger2demo.model.Pet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers


interface PetApiInterface {

    //ADD YOUR API KEY
    @Headers("x-api-key: ")
    @GET("pets")
    suspend fun getPets(): Response<Pet>

}