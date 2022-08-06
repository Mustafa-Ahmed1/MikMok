package com.frenchfriesclan.mikmok.ui

import com.frenchfriesclan.mikmok.databinding.ActivityMainBinding
import com.frenchfriesclan.mikmok.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)
}
