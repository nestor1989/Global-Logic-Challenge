package com.idea3d.global_logic_challenge.data

import com.idea3d.global_logic_challenge.core.Resource
import com.idea3d.global_logic_challenge.core.RetrofitClient
import com.idea3d.global_logic_challenge.model.Laptop

class DataSource {
    suspend fun getLaptopList (): Resource<List<Laptop>> {
        return Resource.Success(RetrofitClient.webService.GetLaptopList())
    }
}