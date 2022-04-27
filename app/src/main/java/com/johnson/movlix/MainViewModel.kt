package com.johnson.movlix

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnson.commons.utils.Constants
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



   fun getTrendingMovies()=viewModelScope.launch {
       val moviesResponse = moviesUseCase.invoke(
           Constants.MEDIA_TYPE_ALL,
           Constants.TIME_WINDOW_WEEK,
           Constants.API_KEY,
           Constants.LANG_US
       )
       _trendingMovies.value = moviesResponse
   }
}