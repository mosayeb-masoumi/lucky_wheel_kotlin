package com.example.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.testkotlin.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding

//    https://www.youtube.com/watch?v=kAcuqjyTFlA


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.wheelView.titles = Arrays.asList("One" , "Two" , "Three" , "Four" ,"Five" , "Six")
        binding.wheelView.selectListener = object : Function1<Int? , Unit>{
            override fun invoke(index: Int?) {

                if(index !=null){
                    showToast(index)
                }

            }

        }

    }

    private fun showToast(index: Int) {

        Toast.makeText(this@MainActivity , ""+ binding.wheelView.titles[index] , Toast.LENGTH_SHORT).show()
    }
}