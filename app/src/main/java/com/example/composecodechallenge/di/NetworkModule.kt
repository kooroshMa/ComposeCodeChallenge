package com.example.composecodechallenge.di

import com.example.composecodechallenge.BuildConfig
import com.example.data.di.Cloud
import com.example.data.di.Mock
import com.example.data.restful.API
import com.example.data.source.cloud.BaseCloudRepository
import com.example.data.source.cloud.CloudMockRepository
import com.example.data.source.cloud.CloudRepository
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Reusable
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Reusable
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
            builder.addNetworkInterceptor(StethoInterceptor())
        }
        builder.connectTimeout(20L, TimeUnit.SECONDS)
        builder.readTimeout(20L, TimeUnit.SECONDS)
        builder.writeTimeout(20L, TimeUnit.SECONDS)
        return builder.build()
    }

    @Reusable
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Reusable
    @Provides
    fun provideService(retrofit: Retrofit): API {
        return retrofit.create(API::class.java)
    }

    @Cloud
    @Provides
    fun provideCloudRepository(apIs: API): BaseCloudRepository {
        return CloudRepository(apIs)
    }

    @Mock
    @Provides
    fun provideCloudMockRepository(): BaseCloudRepository {
        return CloudMockRepository()
    }

}