package com.idea3d.global_logic_challenge.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.idea3d.global_logic_challenge.core.Resource
import com.idea3d.global_logic_challenge.repository.Repo
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repo: Repo):ViewModel() {

    val fetchLaptopList= liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getLaptopList())
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }
}