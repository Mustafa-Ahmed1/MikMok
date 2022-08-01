package com.frenchfriesclan.mikmok.ui

import android.util.Log
import com.frenchfriesclan.mikmok.databinding.ActivityMainBinding
import com.frenchfriesclan.mikmok.model.DataManagerImpl
import com.frenchfriesclan.mikmok.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)

    private val dataManger = DataManagerImpl()
    override fun onStart() {
        super.onStart()
        dataManger.requestVideoFeed() { isSuccess ->
            val feeds = if (isSuccess) {
                dataManger.getFeeds()
            } else {
                mutableListOf()
            }
            Log.i("MAIN_ACTIVITY",feeds.toString())
        }
    }
}
