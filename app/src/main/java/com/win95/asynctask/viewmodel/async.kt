package com.win95.asynctask.viewmodel

import android.os.AsyncTask

class async(val mainViewModel: MainViewModel) : AsyncTask<Any, Any, Any>() {

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Any?) {
        var cnt = 0
        while (true) {
            for (i in 0..1000000000) {
                mainViewModel.changetime()
            }
            cnt = cnt + 1
            if (cnt == 3) {
                mainViewModel.change()
                cnt = cnt % 3
            }
        }
    }

    override fun onPostExecute(result: Any?) {
        super.onPostExecute(result)
    }
}
