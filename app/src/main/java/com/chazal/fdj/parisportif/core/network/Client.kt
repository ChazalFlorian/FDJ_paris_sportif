package com.chazal.fdj.parisportif.core.network

import android.util.Log
import com.chazal.fdj.parisportif.core.Constants
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal fun providesClient(): Retrofit {
    val httpLoggingInterceptor = HttpLoggingInterceptor { message -> Log.d("DEBUG", message) }
        .apply { level = HttpLoggingInterceptor.Level.BODY }

    val okHttpBuilder = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    return Retrofit.Builder().baseUrl("${Constants.BASE_URL}${Constants.API_KEY}")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .client(okHttpBuilder)
        .build()
}