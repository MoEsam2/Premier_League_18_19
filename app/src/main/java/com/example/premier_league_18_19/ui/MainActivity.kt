package com.example.premier_league_18_19.ui
import android.view.LayoutInflater

import com.example.premier_league_18_19.databinding.ActivityMainBinding
import java.io.BufferedReader


import java.io.InputStreamReader


class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setUp() {
      parseFile()
    }

    private fun parseFile() {
        val inputStream = assets.open("premier_league_18-19.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        buffer.forEachLine {
            
        }
    }

    override fun addCallBack() {
    }

}