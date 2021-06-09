package com.win95.asynctask.viewmodel

import android.os.AsyncTask

class async(val mainViewModel: MainViewModel) : AsyncTask<Any, Any, Any>() {

    override fun onPreExecute() {
        super.onPreExecute()
    }
    var toggle = true
    fun toggle(){
        toggle = !toggle
    }
    override fun doInBackground(vararg params: Any?) {
        var cnt = 0
        while (true) {
            for (i in 0..100000000) {
                while(toggle==false){
                    Thread.sleep(500)
                }
            }
            cnt = cnt + 1
            if (cnt == 3) {
                mainViewModel.change()
                cnt = 0
            }
        }
    }

    override fun onPostExecute(result: Any?) {
        super.onPostExecute(result)
    }
}
