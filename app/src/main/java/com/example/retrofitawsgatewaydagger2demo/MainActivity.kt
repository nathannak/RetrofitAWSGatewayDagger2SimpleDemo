package com.example.retrofitawsgatewaydagger2demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitawsgatewaydagger2demo.di.PetApiInterface
import com.example.retrofitawsgatewaydagger2demo.di.PetApiService
import com.example.retrofitawsgatewaydagger2demo.model.Pet
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        job = CoroutineScope(Dispatchers.IO).launch {

            val response = PetApiService.getPetsService().getPets()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    for (petItem in response.body()!!) {
                        Log.d("Pet price", petItem.price.toString())
                        Log.d("Pet type",petItem.type)
                    }

                } else {

                }

            }

        }

    }

}
