package com.johnson.movlix.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.johnson.domain.utils.NetworkResource
import com.johnson.movlix.InternetConnection
import com.johnson.movlix.MainViewModel
import com.johnson.movlix.R
import com.johnson.movlix.adapter.TrendingMoviesAdapter
import com.johnson.movlix.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!
    val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home,container,false)
      _binding = FragmentHomeBinding.bind(view)

//        val isConnected = InternetConnection.checkConnection(requireContext())
//        Log.d("isconnected",isConnected.toString())
//
//
//
//
//        viewModel.getTrendingMovies()
//
//
//
//
//        viewModel.trendingMovies.observe(viewLifecycleOwner, {
//            val trendingMoviesAdapter = TrendingMoviesAdapter()
//            when(it){
//                is NetworkResource.Success -> {
//                    Log.d("new data", it.value.body()?.results.toString())
//                    trendingMoviesAdapter.differ.submitList(it.value.body()?.results)
//                    val layoutmanager  = GridLayoutManager(requireContext(),4)
//                    binding.recyclerview.adapter = trendingMoviesAdapter
//                    binding.recyclerview.layoutManager = layoutmanager
//
//                }
//                is NetworkResource.Failure ->{
//                    Log.d("new data", it.errorCode.toString())
//                }
//
//                is NetworkResource.Loading ->{
//                    Log.d("new data", "loading")
//                }
//            }
//
//        })


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {

            }
    }
}