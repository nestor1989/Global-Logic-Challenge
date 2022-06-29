package com.idea3d.global_logic_challenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.idea3d.global_logic_challenge.R
import com.idea3d.global_logic_challenge.databinding.FragmentDetailsBinding
import com.idea3d.global_logic_challenge.model.Laptop

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var laptop: Laptop

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireArguments().let{
            laptop=it.getParcelable("laptop")!!
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext())
            .load(laptop.image).centerCrop().into(_binding!!.imageView)
        _binding!!.tvTitle.text=laptop.title
        _binding!!.tvDesc.text= laptop.description
        _binding!!.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.mainFragment)
        }

    }
}