package com.tochukwu.eeeeeeee.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinPaprikaApi {


    @GET("/v1/coins")
    suspend fun getCoins(
    ) : Response<List<CoinDto>>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

}