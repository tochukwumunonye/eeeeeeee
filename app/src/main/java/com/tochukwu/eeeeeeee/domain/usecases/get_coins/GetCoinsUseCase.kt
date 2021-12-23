package com.tochukwu.eeeeeeee.domain.usecases.get_coins

import com.tochukwu.eeeeeeee.common.Resource
import com.tochukwu.eeeeeeee.data.remote.toCoin
import com.tochukwu.eeeeeeee.domain.Coin
import com.tochukwu.eeeeeeee.domain.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
class GetCoinsUseCase @Inject constructor(
    private val repository :CoinRepository
){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try{
            emit(Resource.Loading())
            val coins = repository.getCoins().map{it.toCoin()}
            emit(Resource.Success(coins))
        }catch(e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: " An unexpected error occurred"))
        }catch(e : IOException){
            emit(Resource.Error("Couldn't reach server.  Check your internet connection"))
        }
    }

}
**/


/**

class GetCoinsUseCase @Inject constructor(
private val repository :CoinRepository
){
operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
try{
emit(Resource.Loading())
val coins = repository.getCoins().map{it.toCoin()}
emit(Resource.Success(coins))
}catch(e : HttpException){
emit(Resource.Error(e.localizedMessage ?: " An unexpected error occurred"))
}catch(e : IOException){
emit(Resource.Error("Couldn't reach server.  Check your internet connection"))
}
}
} **/

