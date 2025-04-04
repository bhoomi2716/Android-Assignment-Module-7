package com.example.assignment_7_1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PostViewModel : ViewModel()
{
    private val _posts = MutableLiveData<List<Model>>()
    val posts: LiveData<List<Model>> get() = _posts

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = ApiClient.apiService.getPosts()
                _posts.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}