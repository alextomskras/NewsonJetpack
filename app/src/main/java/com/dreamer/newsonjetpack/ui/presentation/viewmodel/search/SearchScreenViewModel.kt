package com.dreamer.newsonjetpack.ui.presentation.viewmodel.search


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dreamer.newsonjetpack.model.News
import com.dreamer.newsonjetpack.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val _news = MutableLiveData<List<News>>()

//    fun getNews(): LiveData<List<News>> {
//        viewModelScope.launch(Dispatchers.IO) {
//            val news = repository.getNews("RU")
//            _news.postValue(news)
//        }
//        return _news
//    }
}