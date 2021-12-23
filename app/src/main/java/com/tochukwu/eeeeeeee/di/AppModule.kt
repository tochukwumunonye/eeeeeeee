package com.tochukwu.eeeeeeee.di

import com.tochukwu.eeeeeeee.common.Constants
import com.tochukwu.eeeeeeee.data.remote.CoinPaprikaApi
import com.tochukwu.eeeeeeee.data.repository.CoinRepositoryImpl
import com.tochukwu.eeeeeeee.domain.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providePatrikaApi(): CoinPaprikaApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }


    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi) : CoinRepository {
        return CoinRepositoryImpl(api)
    }
}
