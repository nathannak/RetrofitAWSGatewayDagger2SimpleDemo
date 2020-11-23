package com.example.retrofitawsgatewaydagger2demo.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    object PetApiService {

        private val BASE_URL = "https://diu0qlo3n7.execute-api.us-east-2.amazonaws.com/prodd/"

        fun getPetsService(): PetApiInterface {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PetApiInterface::class.java)
        }

    }

