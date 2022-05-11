package com.johnson.movlix.ui.fragments.MovieDetailsFragment

import ActorsListAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.johnson.commons.utils.Constants
import com.johnson.domain.utils.NetworkResource
import com.johnson.movlix.MainViewModel
import com.johnson.movlix.R
import com.johnson.movlix.databinding.FragmentMovieDetailBinding
import org.koin.android.ext.android.inject


class MovieDetailFragment : Fragment() {
    val args by navArgs<MovieDetailFragmentArgs>()
    private var _binding: FragmentMovieDetailBinding?=null
    private val binding get() = _binding!!
    val viewModel: MainViewModel by inject()
    private lateinit var circularProgressDrawable:CircularProgressDrawable




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie_detail, container, false)
        _binding = FragmentMovieDetailBinding.bind(view)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = args.movie.original_title

        circularProgressDrawable = CircularProgressDrawable(requireActivity())
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        viewModel.getMovieActors(args.movie.id)

        updateUI()




        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun updateUI(){
        binding.movieDetailsTitle.text = args.movie.title
        binding.movieDetailsOverviewText.text = args.movie.overview
        binding.movieRate.text = args.movie.vote_average.toString()
        Glide.with(requireContext())
            .load(Constants.IMG_URL_INIT_PATH +args.movie.poster_path)
            .placeholder(circularProgressDrawable)
            .into(binding.movieDetailsBackDropImage)
        Glide.with(requireContext())
            .load(Constants.IMG_URL_INIT_PATH +args.movie.backdrop_path)
            .placeholder(circularProgressDrawable )
            .into(binding.movieDetailsSmallImage)

        viewModel.movieActorsResponse.observe(viewLifecycleOwner, Observer {
            val actorsAdapter = ActorsListAdapter()
            when(it){
                is NetworkResource.Success -> {
                    actorsAdapter.differ.submitList(it.value.body()?.crew)
                    binding.actorsRecyclerView.apply {
                        adapter = actorsAdapter
                    }


                }
                is NetworkResource.Failure ->{
                    Log.d("new data", it.errorCode.toString())
                }

                is NetworkResource.Loading ->{
                    Log.d("new data", "loading")
                }
            }

        })

    }


}