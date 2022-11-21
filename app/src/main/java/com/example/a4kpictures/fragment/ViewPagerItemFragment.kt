package com.example.a4kpictures.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.a4kpictures.R
import com.example.a4kpictures.adapter.RvAdapter
import com.example.a4kpictures.databinding.FragmentViewPagerItemBinding
import com.example.a4kpictures.models.ItemRv
import com.example.a4kpictures.models.MyDate
private const val ARG_PARAM1 = "param1"

class ViewPagerItemFragment : Fragment() , RvAdapter.RvClick {
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    private lateinit var binding: FragmentViewPagerItemBinding
    private lateinit var rvAdapter: RvAdapter
    private lateinit var list:ArrayList<ItemRv>
    private val TAG = "ViewpagerItemFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding= FragmentViewPagerItemBinding.inflate(layoutInflater)

        list= ArrayList()

        if (param1.toString()=="All"){
            Log.d(TAG, "onCreateView: ${MyDate.allList}")
            list=MyDate.allList
            list.shuffle()
            rvAdapter= RvAdapter(list, this)
            binding.myRecycleview.adapter=rvAdapter
        }
        if (param1.toString()=="Technology"){
            Log.d(TAG, "onCreateView: ${MyDate.allList}")
            list=MyDate.techList
            list.shuffle()
            rvAdapter= RvAdapter(list, this)
            binding.myRecycleview.adapter=rvAdapter
        }
        if (param1.toString()=="Animals"){
            Log.d(TAG, "onCreateView: ${MyDate.allList}")
            list=MyDate.animalList
            list.shuffle()
            rvAdapter= RvAdapter(list, this)
            binding.myRecycleview.adapter=rvAdapter
        }
        if (param1.toString()=="Gradient"){
            Log.d(TAG, "onCreateView: ${MyDate.allList}")
            list=MyDate.gradientList
            list.shuffle()
            rvAdapter= RvAdapter(list, this)
            binding.myRecycleview.adapter=rvAdapter
        }
        if (param1.toString()=="Nature"){
            Log.d(TAG, "onCreateView: ${MyDate.allList}")
            list=MyDate.natureList
            list.shuffle()
            rvAdapter= RvAdapter(list, this)
            binding.myRecycleview.adapter=rvAdapter
        }
        if (param1.toString()=="Black"){
            Log.d(TAG, "onCreateView: ${MyDate.allList}")
            list=MyDate.blackList
            list.shuffle()
            rvAdapter= RvAdapter(list, this)
            binding.myRecycleview.adapter=rvAdapter
        }


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            ViewPagerItemFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }


    override fun onClick(itemRv: ItemRv) {
        findNavController().navigate(R.id.clicableFragment, bundleOf("key" to itemRv))
    }
}