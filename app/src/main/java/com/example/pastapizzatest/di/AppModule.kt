package com.example.pastapizzatest.di

import android.content.Context
import androidx.room.Room
import com.example.pastapizzatest.data.local.PastaCacheRepositoryImpl
import com.example.pastapizzatest.data.local.PastaDao
import com.example.pastapizzatest.data.local.RoomConst
import com.example.pastapizzatest.data.local.RoomDb
import com.example.pastapizzatest.data.remote.PastaApi
import com.example.pastapizzatest.data.remote.PastaRepositoryRemoteImpl
import com.example.pastapizzatest.data.remote.RetrofitConstants
import com.example.pastapizzatest.domain.PastaCacheRepository
import com.example.pastapizzatest.domain.PastaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun providePastaRepository(api: PastaApi): PastaRepository = PastaRepositoryRemoteImpl(api)

    @Provides
    @Singleton
    fun provideRoomDb(@ApplicationContext context: Context): RoomDb {
        return Room.databaseBuilder(
            context,
            RoomDb::class.java,
            RoomConst.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePastaDao(db: RoomDb): PastaDao {
        return db.pastaDao()
    }

    @Provides
    @Singleton
    fun providePastaCacheRepository(
        dao: PastaDao
    ): PastaCacheRepository {
        return PastaCacheRepositoryImpl(dao)
    }
}