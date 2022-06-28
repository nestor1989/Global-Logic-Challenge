package com.idea3d.global_logic_challenge.repository

import com.idea3d.global_logic_challenge.core.Resource
import com.idea3d.global_logic_challenge.model.Laptop

interface Repo {
    suspend fun getLaptopList(): Resource<List<Laptop>>
}