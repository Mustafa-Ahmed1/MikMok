package com.frenchfriesclan.mikmok.ui

import android.os.Bundle
import com.frenchfriesclan.mikmok.R
import com.frenchfriesclan.mikmok.databinding.ActivityMainBinding
import com.frenchfriesclan.mikmok.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MikMok)
    }
}
