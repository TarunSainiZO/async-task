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
    fun toggleThread(){
        asyncStart.toggle()
    }
    var cnt = 0
    fun change( ){
        tm = (tm%3+1)
        cnt = cnt+1
        this.time.postValue(tm)
    }
}