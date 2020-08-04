package com.khs.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.khs.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val student = getStudent()
        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
    }

    private fun getStudent(): Student{
        return Student(1,"Alex","alex@gmail.com")
    }
}