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
            execute()
        }
    }

    private suspend fun execute()
    {
        val parentJob = GlobalScope.launch(Dispatchers.Main) {
            Log.d(TAG , "MainActivity :: execute :: parentJob :: ${this.coroutineContext}")
            val childJob = launch(Dispatchers.IO) {
                Log.d(TAG , "MainActivity :: execute :: childJob :: ${this.coroutineContext}")
            }
        }
    }
}