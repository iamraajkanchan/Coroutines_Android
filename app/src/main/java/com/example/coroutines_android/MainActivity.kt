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
        var instaFollowers = 0

        val fbJob = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers = getFollowers()
        }
        val instaJob = CoroutineScope(Dispatchers.IO).launch {
            instaFollowers = getInstaFollowers()
        }
        fbJob.join()
        Log.d(TAG , "MainActivity :: printFollowers :: fbFollowers : $fbFollowers")
        instaJob.join()
        Log.d(TAG , "MainActivity :: printFollowers :: instaFollowers : $instaFollowers")
    }

    private suspend fun getFollowers() : Int
    {
        delay(1000)
        return 54
    }

    private suspend fun getInstaFollowers() : Int
    {
        delay(1000)
        return 113
    }
}
