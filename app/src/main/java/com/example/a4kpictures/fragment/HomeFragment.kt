package com.example.a4kpictures.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.a4kpictures.R
import com.example.a4kpictures.adapter.StateAdapter
import com.example.a4kpictures.databinding.FragmentHomeBinding
import com.example.a4kpictures.databinding.TabItemViewBinding
import com.example.a4kpictures.models.MyDate
import com.example.a4kpictures.models.PagerItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private val list=ArrayList<PagerItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



            list.add(PagerItem("All"))
            list.add(PagerItem("Technology"))
            list.add(PagerItem("Animals"))
            list.add(PagerItem("Gradient"))
            list.add(PagerItem("Nature"))
            list.add(PagerItem("Black"))


    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var stateAdapters: StateAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater)

        binding.heart.setOnClickListener {
            findNavController().navigate(R.id.likeImageFragment)
        }

        stateAdapters= StateAdapter(list, this)
        binding.myViewpager.adapter=stateAdapters

        binding.appBar.setOnClickListener {
            binding.drawer.open()
        }

        setTab()

        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home->{
                    Toast.makeText(binding.root.context, "Home", Toast.LENGTH_SHORT).show()
                }
                R.id.popular->{
                    Toast.makeText(binding.root.context, "Popular", Toast.LENGTH_SHORT).show()
                }
                R.id.random->{
                    MyDate.allList.shuffle()
                    MyDate.animalList.shuffle()
                    MyDate.natureList.shuffle()
                    MyDate.likeList.shuffle()
                    MyDate.gradientList.shuffle()
                    MyDate.blackList.shuffle()
                    binding.drawer.close()
                }
                R.id.liked->{
                    findNavController().navigate(R.id.likeImageFragment)
                }
                R.id.history->{
                    Toast.makeText(binding.root.context, "History", Toast.LENGTH_SHORT).show()
                }
                R.id.about->{
                    Toast.makeText(binding.root.context, "About", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
        TabLayoutMediator(binding.myTablayout,binding.myViewpager){tab,position->
            val tabItemView= TabItemViewBinding.inflate(layoutInflater)

            tabItemView.tabItemTv.text=list[position].type

            tabItemView.tabItemImg.visibility=View.GONE

            tab.customView = tabItemView.root
        }.attach()

        return binding.root



    }

    private fun setTab() {

        binding.myTablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView=tab?.customView
                customView?.findViewById<ImageView>(R.id.tab_item_img)?.visibility=View.VISIBLE
                customView?.findViewById<TextView>(R.id.tab_item_tv)?.animate()?.alpha(1f)?.setDuration(300)?.start()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView=tab?.customView
                customView?.findViewById<ImageView>(R.id.tab_item_img)?.visibility=View.GONE
                customView?.findViewById<TextView>(R.id.tab_item_tv)?.animate()?.alpha(.5f)?.setDuration(300)?.start()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}