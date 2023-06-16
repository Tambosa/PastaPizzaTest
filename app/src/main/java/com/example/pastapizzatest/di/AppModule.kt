package com.example.pastapizzatest.di

import com.example.pastapizzatest.data.PastaApi
import com.example.pastapizzatest.data.PastaRepositoryImpl
import com.example.pastapizzatest.data.RetrofitConstants
import com.example.pastapizzatest.domain.model.PastaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePastaApi(): PastaApi {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .build()

        return Retrofit.Builder()
            .baseUrl(RetrofitConstants.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PastaApi::class.java)
    }

    @Provides
    @Singleton
    fun providePastaRepository(api: PastaApi): PastaRepository = PastaRepositoryImpl(api)
}