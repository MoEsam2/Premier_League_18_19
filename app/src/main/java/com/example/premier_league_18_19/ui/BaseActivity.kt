package com.example.premier_league_18_19.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    abstract val bindingInflater: (LayoutInflater) -> VB
    private lateinit var _binding : ViewBinding

    protected val binding
        get() =_binding as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = bindingInflater(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(_binding.root)
        setUp()
        addCallBack()

    }
    abstract fun setUp()

    abstract fun addCallBack()
}