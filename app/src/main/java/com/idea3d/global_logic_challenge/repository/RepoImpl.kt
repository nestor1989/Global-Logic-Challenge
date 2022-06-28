package com.idea3d.global_logic_challenge.repository

import com.idea3d.global_logic_challenge.core.Resource
import com.idea3d.global_logic_challenge.data.DataSource
import com.idea3d.global_logic_challenge.model.Laptop

class RepoImpl(private val dataSource: DataSource):Repo {
    override suspend fun getLaptopList(): Resource<List<Laptop>> {
        return dataSource.getLaptopList()
    }


}