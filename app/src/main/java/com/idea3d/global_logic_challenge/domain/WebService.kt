package com.idea3d.global_logic_challenge.domain

import com.idea3d.global_logic_challenge.model.LaptopList
import retrofit2.http.GET

interface WebService {
    @GET("/list")
    suspend fun GetLaptopList(): LaptopList
}