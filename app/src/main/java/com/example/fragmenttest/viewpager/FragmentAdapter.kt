package com.example.fragmenttest.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragmenttest.fragment.Fragment1
import com.example.fragmenttest.fragment.Fragment2
import com.example.fragmenttest.fragment.Fragment3

class FragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragmentHashMap = hashMapOf(
        Pair(0, Fragment1()),
        Pair(1, Fragment2()),
        Pair(2, Fragment3())
    )

    override fun getItemCount(): Int {
        return fragmentHashMap.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentHashMap[position] ?: createTestFragment(position)
    }

    private fun createTestFragment(position: Int):Fragment{
        return when(position){
            0 -> Fragment1()
            1 -> Fragment2()
            2 -> Fragment3()
            else -> throw Throwable("Fragment Position Error")
        }
    }
}