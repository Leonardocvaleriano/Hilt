package com.codeplace.daggerhilt.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface MyApi {

    @GET("data")
    suspend fun doNetworkCall():Response<List<*>>

    companion object {
        const val BASE_URL = "https://alphavantage.co"
    }
}

