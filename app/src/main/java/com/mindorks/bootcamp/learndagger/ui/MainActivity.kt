package com.mindorks.bootcamp.learndagger.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.R
import com.mindorks.bootcamp.learndagger.di.component.DaggerActivityComponent
import com.mindorks.bootcamp.learndagger.di.module.ActivityModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDependencies()

        setContentView(R.layout.activity_main)

        val tvData = findViewById<TextView>(R.id.tvData)
        tvData.text = mainViewModel.getSomeData()

        addHomeFragment()
    }

    private fun addHomeFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, HomeFragment.newInstance(), HomeFragment.TAG)
                .commit()
    }


    private fun getDependencies() {
        DaggerActivityComponent
                .builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((application as MyApplication).applicationComponent)
                .build()
                .inject(this)
    }
}