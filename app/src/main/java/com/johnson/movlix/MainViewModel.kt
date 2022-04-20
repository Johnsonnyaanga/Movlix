package com.johnson.movlix

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnson.commons.models.Trending.TrendingResponse
import com.johnson.commons.utils.Constants
import com.johnson.commons.utils.NetworkResource
import com.johnson.remote.repository.MoviesRepository
import com.johnson.remote.usecases.MoviesUseCase
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel(val moviesUseCase: MoviesUseCase):ViewModel() {

    init {
        getTrendingMovies()
    }

    val _trendingMovies = MutableLiveData<NetworkResource<Response<TrendingResponse>>>()
    var trendingMovies:LiveData<NetworkResource<Response<TrendingResponse>>> = _trendingMovies



   fun getTrendingMovies()=viewModelScope.launch {
       val moviesResponse = moviesUseCase.invoke(
           Constants.MEDIA_TYPE_ALL,
           Constants.TIME_WINDOW_DAY,
           Constants.API_KEY,
           Constants.LANG_US
       )
       _trendingMovies.value = moviesResponse
   }
}