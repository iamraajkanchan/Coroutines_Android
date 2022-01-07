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
        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }
        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }
    }

    private suspend fun task1()
    {
        Log.d(TAG , "Coroutines :: task1 : ${Thread.currentThread().name}")
        Log.d(TAG , "Coroutines :: task1 : Starting Task 1")
        yield()
        Log.d(TAG , "Coroutines :: task1 : Ending Task 1")
    }

    private suspend fun task2()
    {
        Log.d(TAG , "Coroutines :: task2 : ${Thread.currentThread().name}")
        Log.d(TAG , "Coroutines :: task2 : Starting Task 2")
        yield()
        Log.d(TAG , "Coroutines :: task2 : Ending Task 2")
    }
}