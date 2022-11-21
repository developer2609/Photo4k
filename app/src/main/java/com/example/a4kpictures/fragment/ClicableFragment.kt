package com.example.a4kpictures.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a4kpictures.R
import com.example.a4kpictures.databinding.FragmentClicableBinding
import com.example.a4kpictures.models.ItemRv
import com.example.a4kpictures.models.MyDate

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ClicableFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var binding:FragmentClicableBinding
    private val TAG = "ClickableFragment"
    private var like=0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentClicableBinding.inflate(layoutInflater)
        val item=arguments?.getSerializable("key") as ItemRv
        binding.image.setImageResource(item.img)

        MyDate.likeList.forEach {
            if (item.equals(it)){
                binding.imgHeart.setImageResource(R.drawable.heart_red)
            }
        }

        //backstack
        binding.back.setOnClickListener {
            fragmentManager?.popBackStack()
        }


        //share
        binding.share.setOnClickListener {
        }

        //like
        binding.heart.setOnClickListener {
            if (MyDate.likeList.contains(item)){
                MyDate.likeList.remove(item)
                binding.imgHeart.setImageResource(R.drawable.heart_icon)
            }else{
                MyDate.likeListData(item)
                binding.imgHeart.setImageResource(R.drawable.heart_red)
            }
            Log.d(TAG, "onCreateView: ${MyDate.likeList}")
        }


        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ClicableFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}