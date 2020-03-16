package com.example.fragmenttest

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.example.fragmenttest.databinding.ActivityMainBinding
import com.example.fragmenttest.fragment.Fragment1
import com.example.fragmenttest.fragment.Fragment2
import com.example.fragmenttest.fragment.Fragment3
import kotlinx.android.synthetic.main.fragment_main.view.*


class ReplaceFragmentActivity : FragmentActivity(), View.OnClickListener{
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val fragmentHashMap = hashMapOf(
        Pair(0, Fragment1()),
        Pair(1, Fragment2()),
        Pair(2, Fragment3())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button1 ->{
                val fragment = fragmentHashMap[0] ?: createFragment(0)
                showFragment(fragment,0)
            }

            R.id.button2 ->{
                val fragment = fragmentHashMap[1] ?: createFragment(1)
                showFragment(fragment,1)
            }

            R.id.button3 ->{
                val fragment = fragmentHashMap[2] ?: createFragment(2)
                showFragment(fragment,2)
            }
        }
    }

    private fun showFragment(fragment: Fragment, tag:Int){
        val fragmentTag = "$tag"
        val target = supportFragmentManager.findFragmentByTag(fragmentTag)
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        if(target == null)
            transaction.add(R.id.container, fragment, fragmentTag).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)

        for(index in 0 until fragmentHashMap.size){
            val temp = fragmentHashMap[index]

            temp?.let {
                if(tag == index)
                    transaction.attach(it)
                else
                    transaction.detach(it)
            }
        }

        transaction.commit()
    }


    private fun createFragment(position: Int):Fragment{
        return when(position){
            0 -> Fragment1()
            1 -> Fragment2()
            2 -> Fragment3()
            else -> throw Throwable("Fragment Position Error")
        }
    }
}
