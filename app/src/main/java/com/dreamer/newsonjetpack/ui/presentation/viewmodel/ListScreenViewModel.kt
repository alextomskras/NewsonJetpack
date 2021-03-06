package com.dreamer.newsonjetpack.ui.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dreamer.newsonjetpack.model.News
import com.dreamer.newsonjetpack.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val _news = MutableLiveData<List<News>>()

    fun getNews(): LiveData<List<News>> {
        viewModelScope.launch(Dispatchers.IO) {
            val news = repository.getNews("US")
            _news.postValue(news)
        }
        return _news
    }
}