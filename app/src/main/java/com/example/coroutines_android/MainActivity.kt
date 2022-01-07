package com.example.coroutines_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity()
{
    companion object
    {
        const val TAG = "Coroutines"
    }

    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }
    }

    private suspend fun printFollowers()
    {
        var fbFollowers = 0
        val job = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers = getFollowers()
        }
        job.join()
        Log.d(TAG , "MainActivity :: printFollowers :: fbFollowers : $fbFollowers")
    }

    private suspend fun getFollowers() : Int
    {
        delay(5000)
        return 54
    }
}
