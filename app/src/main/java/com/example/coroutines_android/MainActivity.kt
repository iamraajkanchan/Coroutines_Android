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
        Log.d(TAG , "Coroutines :: task1 : ${Thread.currentThread().name}")
        Log.d(TAG , "Coroutines :: task1 : Starting Task 1")
        delay(1000)
        Log.d(TAG , "Coroutines :: task1 : Ending Task 1")
        var fbFollowers = 0
        val job = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers = getFollowers()
        }
        job.join()
        Log.d(TAG , "MainActivity :: printFollowers :: fbFollowers : $fbFollowers")
    }

    private suspend fun getFollowers() : Int
    {
        Log.d(TAG , "Coroutines :: task2 : ${Thread.currentThread().name}")
        Log.d(TAG , "Coroutines :: task2 : Starting Task 2")
        delay(1000)
        Log.d(TAG , "Coroutines :: task2 : Ending Task 2")
        delay(5000)
        return 54
    }
}