package com.idea3d.global_logic_challenge.core

import com.google.gson.GsonBuilder
import com.idea3d.global_logic_challenge.domain.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val webService by lazy{
        Retrofit.Builder()
            .baseUrl("http://private-f0eea-mobilegllatam.apiary-mock.com")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }

}