package com.mindorks.bootcamp.learndagger.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mindorks.bootcamp.learndagger.MyApplication
import com.mindorks.bootcamp.learndagger.R
import com.mindorks.bootcamp.learndagger.di.component.DaggerFragmentComponent
import com.mindorks.bootcamp.learndagger.di.module.FragmentModule
import javax.inject.Inject

class HomeFragment : Fragment() {
    companion object {
        val TAG = HomeFragment::class.java.canonicalName
        fun newInstance() = HomeFragment()
    }

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDependencies()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, homeViewModel.getSomeData())
    }

    private fun getDependencies() {
        activity?.let {
            DaggerFragmentComponent
                    .builder()
                    .fragmentModule(FragmentModule())
                    .applicationComponent((it.application as MyApplication).applicationComponent)
                    .build()
                    .inject(this)
        }
    }
}