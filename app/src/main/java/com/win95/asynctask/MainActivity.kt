package com.win95.asynctask

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.win95.asynctask.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {
    val change : TextView
    get() = findViewById(R.id.change)

    val imageView : ImageView
    get() = findViewById(R.id.imageView)
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.time.observe(this,{
            change.text = it.toString()
        })
        Log.d("time","call again 1"+viewModel.toString())
        viewModel.image.observe(this,{
            if(it.equals("img1")) {
                imageView.setImageResource(R.drawable.img1)
            }else if(it.equals("img2")){
                imageView.setImageResource(R.drawable.img2)
            }else{
                imageView.setImageResource(R.drawable.img3)
            }
        })
        viewModel.startThread()
    }
}