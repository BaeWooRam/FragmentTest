package com.example.fragmenttest

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.fragmenttest.databinding.ActivityViewpagerBinding
import com.example.fragmenttest.viewpager.FragmentAdapter
import com.example.fragmenttest.viewpager.ZoomOutPageTransformer

class ViewPager2Activity : FragmentActivity() {
    private val binding:ActivityViewpagerBinding by lazy {
        ActivityViewpagerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.pager.adapter =
            FragmentAdapter(this)
        binding.pager.setPageTransformer(ZoomOutPageTransformer())
    }
}
