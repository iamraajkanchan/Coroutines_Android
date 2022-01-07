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
            executeTask()
        }
    }

    private suspend fun executeTask()
    {
        Log.d(TAG , "MainActivity :: executeTask :: Before")
        withContext(Dispatchers.IO) {
            delay(1000)
            Log.d(TAG , "MainActivity :: executeTask :: Inside")
        }
        Log.d(TAG , "MainActivity :: executeTask :: After")
    }

}
