package com.bignerdranch.android.firstcomposeproject

import androidx.compose.foundation.lazy.LazyColumn
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val initialList  =
        mutableListOf<InstagramModel>().apply {
            repeat(500){
                add(
                    InstagramModel(
                    id = it,
                    title = "Title: $it",
                    isFollowed = Random.nextBoolean()
                )
                )
            }
        }

    private val _models = MutableLiveData<List<InstagramModel>>(initialList)
    val models: LiveData<List<InstagramModel>> = _models

    fun updateFollow(model: InstagramModel){
       val modifiedModels =
           _models.value?.toMutableList() ?: mutableListOf()
        modifiedModels.replaceAll {
            if (it == model){
                it.copy(isFollowed = !it.isFollowed)
            } else {
                it
            }
        }
            _models.value = modifiedModels
    }
//    private val _isFollowing = MutableLiveData<Boolean>()
//    val isFollowing: LiveData<Boolean> = _isFollowing

//    fun ChangeFollow() {
//        val wasFollowing = _isFollowing.value ?: false
//        _isFollowing.value = !wasFollowing
//    }

}