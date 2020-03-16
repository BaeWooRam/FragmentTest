package com.example.fragmenttest.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class BaseFragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("onCreateView","${javaClass.simpleName} start")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i("onViewCreated","${javaClass.simpleName} start")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("onCreate","${javaClass.simpleName} start")
        super.onCreate(savedInstanceState)
    }

    override fun onPause() {
        Log.i("onPause","${javaClass.simpleName} start")
        super.onPause()
    }

    override fun onStart() {
        Log.i("onStart","${javaClass.simpleName} start")
        super.onStart()
    }

    override fun onResume() {
        Log.i("onResume","${javaClass.simpleName} start")
        super.onResume()
    }

    override fun onDestroy() {
        Log.i("onDestroy","${javaClass.simpleName} start")
        super.onDestroy()
    }
}