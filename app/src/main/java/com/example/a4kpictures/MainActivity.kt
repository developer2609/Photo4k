package com.example.a4kpictures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a4kpictures.databinding.ActivityMainBinding
import com.example.a4kpictures.models.MyDate
import com.example.a4kpictures.models.MySharedPraference

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        MySharedPraference.init(this)

        MyDate.allListData()
        MyDate.techListData()
        MyDate.animalListData()
        MyDate.gradientListData()
        MyDate.natureListData()
        MyDate.blackListData()

        MyDate.likeList=MySharedPraference.obektString

    }

    override fun onStop() {
        super.onStop()
        MySharedPraference.obektString=MyDate.likeList
    }
}