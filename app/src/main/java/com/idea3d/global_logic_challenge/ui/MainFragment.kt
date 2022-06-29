package com.idea3d.global_logic_challenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.idea3d.global_logic_challenge.R
import com.idea3d.global_logic_challenge.core.Resource
import com.idea3d.global_logic_challenge.data.DataSource
import com.idea3d.global_logic_challenge.databinding.MainFragmentBinding
import com.idea3d.global_logic_challenge.model.Laptop
import com.idea3d.global_logic_challenge.repository.RepoImpl
import com.idea3d.global_logic_challenge.ui.adapter.MainAdapter
import com.idea3d.global_logic_challenge.ui.viewmodel.MainViewModel
import com.idea3d.global_logic_challenge.ui.viewmodel.VMFactory

class MainFragment : Fragment(), MainAdapter.OnLaptopClickListener {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<MainViewModel>(){ VMFactory(RepoImpl(DataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = MainFragmentBinding.inflate(inflater, container, false)

        setUpRecyclerView()

        viewModel.fetchLaptopList.observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading->{
                    binding.prBar.visibility=View.VISIBLE
                    binding.prError.visibility=View.GONE
                }
                is Resource.Success->{
                    binding.prBar.visibility=View.GONE
                    binding.prError.visibility=View.GONE
                    binding.rvLaptop.adapter=MainAdapter(requireContext(), result.data, this)
                }
                is Resource.Failure->{
                    binding.prBar.visibility=View.GONE
                    binding.prError.visibility=View.VISIBLE
                    Toast.makeText(requireContext(),"Revise su conexión a internet ${result.exception}",Toast.LENGTH_LONG).show()
                }

            }
        })


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun setUpRecyclerView() {
        val appContext = requireContext().applicationContext
        val recyclerView = binding.rvLaptop
        recyclerView.layoutManager= LinearLayoutManager(appContext)
        binding.rvLaptop.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onLaptopClick(laptop: Laptop) {
        val bundle = Bundle()
        bundle.putParcelable("laptop", laptop)
        findNavController().navigate(R.id.detailsFragment, bundle)
    }
}