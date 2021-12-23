package com.tochukwu.eeeeeeee.data.repository

import com.tochukwu.eeeeeeee.common.Resource
import com.tochukwu.eeeeeeee.data.remote.CoinDetailDto
import com.tochukwu.eeeeeeee.data.remote.CoinDto
import com.tochukwu.eeeeeeee.data.remote.CoinPaprikaApi
import com.tochukwu.eeeeeeee.domain.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): Resource<List<CoinDto>> {

        return try{
            val response = api.getCoins()
            if(response.isSuccessful){
                response.body()?.let{
                    return@let Resource.success(it)
                }?: Resource.error("An unknown error occurred", null)
            } else {
                Resource.error("An unknown error occurred", null)
            }
        } catch(e: Exception){
            Resource.error("Network Error, check your connection", null)
        }
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }


}

