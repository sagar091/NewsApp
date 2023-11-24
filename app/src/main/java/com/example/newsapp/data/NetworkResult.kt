package com.example.newsapp.data

sealed class NetworkResult<T> {

    // We'll wrap our data in this 'Success'
    // class in case of success response from api
    data class Success<T>(val data: T) : NetworkResult<T>()

    // We'll pass error message wrapped in this 'Error'
    // class to the UI in case of failure response
    data class Error<T>(val message: String) : NetworkResult<T>()

    // We'll just pass object of this Loading
    // class, just before making an api call
    class Loading<T>(val isLoading: Boolean) : NetworkResult<T>()

    // We'll just pass object of this NoInternet
    // class to the UI in case of no internet
    class NoInternet<T> : NetworkResult<T>()
}