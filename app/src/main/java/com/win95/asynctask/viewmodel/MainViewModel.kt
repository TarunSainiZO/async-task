package com.win95.asynctask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {
    val time = MutableLiveData<Int>()
    val image = MutableLiveData<String>()
    var tm = 1
    lateinit var asyncStart : async
    fun startThread(){
        if(!this::asyncStart.isInitialized) {
            asyncStart = async(this)
            asyncStart.execute()
        }
    }

    fun changetime( ){
        tm = (tm%3+1)
        this.time.value = tm
    }
    var imageCount = 1

    fun change(){
        imageCount = ((imageCount+1)%3+1)
        this.image.value = "img"+imageCount.toString()
    }

}