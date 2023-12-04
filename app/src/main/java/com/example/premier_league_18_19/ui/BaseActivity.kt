package com.example.premier_league_18_19.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.premier_league_18_19.R

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    abstract val bindingInflater: (LayoutInflater) -> VB
    private var _binding: ViewBinding? = null

    protected val binding
        get() =_binding as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = bindingInflater(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(requireNotNull(_binding).root)
        setUp()
        addCallBack()

    }
    abstract fun setUp()

    abstract fun addCallBack()
}