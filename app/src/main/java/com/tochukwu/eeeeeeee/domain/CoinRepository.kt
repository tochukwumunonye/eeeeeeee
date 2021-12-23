package com.tochukwu.eeeeeeee.domain

import com.tochukwu.eeeeeeee.common.Resource
import com.tochukwu.eeeeeeee.data.remote.CoinDetailDto
import com.tochukwu.eeeeeeee.data.remote.CoinDto

interface CoinRepository {



    suspend fun getCoins(): Resource<List<CoinDto>>

    suspend fun getCoinById(coinId: String) : CoinDetailDto
}