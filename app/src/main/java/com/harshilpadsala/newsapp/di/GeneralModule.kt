package com.harshilpadsala.newsapp.di

import com.harshilpadsala.newsapp.constants.Params
import com.harshilpadsala.newsapp.data.remote.NewsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


val generalModule = module {
    single { provideHttpLogginInterceptor() }
    single { provideRetrofit(get()) }
    single { provideOkHttpClient(get()) }
    single { provideNewsService(get()) }

}


fun provideHttpLogginInterceptor() : HttpLoggingInterceptor{
    var loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return loggingInterceptor
}

fun provideNewsService(retrofit: Retrofit) : NewsService{
    return retrofit.create(NewsService::class.java)
}

fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit{
    return Retrofit.Builder().baseUrl(Params.BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor
) : OkHttpClient{
    return OkHttpClient().newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .build()
}