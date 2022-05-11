package com.johnson.movlix

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnson.commons.utils.Constants
import com.johnson.domain.models.Actors.Actors
import com.johnson.domain.models.TrendingResponse
import com.johnson.domain.usecases.MoviesUseCase
import com.johnson.domain.utils.NetworkResource
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel(val moviesUseCase: MoviesUseCase): ViewModel() {

    init {
        getTrendingMovies()
    }

    val _trendingMovies = MutableLiveData<NetworkResource<Response<TrendingResponse>>>()
    var trendingMovies: LiveData<NetworkResource<Response<TrendingResponse>>> = _trendingMovies

    val _movieActorsResponse = MutableLiveData<NetworkResource<Response<Actors>>>()
    var movieActorsResponse: LiveData<NetworkResource<Response<Actors>>> = _movieActorsResponse



   fun getTrendingMovies()=viewModelScope.launch {
       val moviesResponse = moviesUseCase.trendingMovies(
           Constants.MEDIA_TYPE_ALL,
           Constants.TIME_WINDOW_WEEK,
           Constants.API_KEY,
           Constants.LANG_US
       )
       _trendingMovies.value = moviesResponse
   }


    fun getMovieActors(movieId:Int)=viewModelScope.launch {
        val moviesActors = moviesUseCase.fetchMovieActors(
            movieId,
            Constants.API_KEY,
            Constants.LANG_US
        )
        _movieActorsResponse.value = moviesActors
    }




}