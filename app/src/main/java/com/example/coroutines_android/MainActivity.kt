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
        CoroutineScope(Dispatchers.IO).launch {
            val fb = async { getFollowers() }
            val insta = async { getInstaFollowers() }
            Log.d(TAG , "MainActivity :: printFollowers :: fbFollowers : ${fb.await()}")
            Log.d(TAG , "MainActivity :: printFollowers :: instaFollowers : ${insta.await()}")
        }
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
