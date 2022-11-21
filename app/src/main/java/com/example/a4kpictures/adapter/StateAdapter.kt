package com.example.a4kpictures.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.a4kpictures.fragment.ViewPagerItemFragment
import com.example.a4kpictures.models.PagerItem

class StateAdapter(val list:ArrayList<PagerItem>, fragment: Fragment)
    : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return ViewPagerItemFragment.newInstance(list[position].type)
    }
}