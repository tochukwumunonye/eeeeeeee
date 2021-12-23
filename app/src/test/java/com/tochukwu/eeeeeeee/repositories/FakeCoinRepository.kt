package com.tochukwu.eeeeeeee.repositories

import com.tochukwu.eeeeeeee.common.Resource
import com.tochukwu.eeeeeeee.data.remote.CoinDetailDto
import com.tochukwu.eeeeeeee.data.remote.CoinDto
import com.tochukwu.eeeeeeee.domain.Coin
import com.tochukwu.eeeeeeee.domain.CoinRepository

class FakeCoinRepository : CoinRepository{


    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }

    override suspend fun getCoins(): Resource<List<CoinDto>> {
        return if(shouldReturnNetworkError){
            Resource.error("Error", null)
        } else{
            Resource.success(listOf(CoinDto("doge", true, true, "doge", 1, "dd", "dog")))
        }
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        TODO("Not yet implemented")
    }
}


/**

override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
return if(shouldReturnNetworkError) {
Resource.error("Error", null)
} else {
Resource.success(ImageResponse(listOf(), 0, 0))
}
}
}
        **/