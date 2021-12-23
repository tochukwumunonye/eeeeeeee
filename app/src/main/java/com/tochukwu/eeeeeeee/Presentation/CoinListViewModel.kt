package com.tochukwu.eeeeeeee.Presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tochukwu.eeeeeeee.common.Event
import com.tochukwu.eeeeeeee.common.Resource
import com.tochukwu.eeeeeeee.data.remote.CoinDto
import com.tochukwu.eeeeeeee.data.remote.CoinPaprikaApi
import com.tochukwu.eeeeeeee.domain.Coin
import com.tochukwu.eeeeeeee.domain.CoinRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CoinListViewModel  @Inject constructor(
    private val repository: CoinRepository
) : ViewModel() {

    private val _coinz = MutableLiveData<Event<Resource<List<CoinDto>>>>()

    var coinz: MutableLiveData<Event<Resource<List<CoinDto>>>> = _coinz


    fun getCoins(){

        viewModelScope.launch{
            val  response = repository.getCoins()
            _coinz.value = Event(response)

        }

    }

}

/**
 *  fun deleteShoppingItem(shoppingItem : ShoppingItem) = viewModelScope.launch {
repository.deleteShoppingItem(shoppingItem)



fun getCoins(){

viewModelScope.launch{
val  response = repository.getCoins()
_coinz.value = Event(response)
}
}
}

 */



/**

init{
getCoins()
}

private val _state = MutableStateFlow(CoinListState())
val state : StateFlow<CoinListState> = _state

fun getCoins(){
getCoinsUseCase().onEach{result ->
when(result){
is Resource.Success ->{
_state.value = CoinListState(coins = result.data ?: emptyList())
}
is Resource.Error -> {
_state.value = CoinListState(
error = result.message ?: "An unexpected error occurred"
)
}

is Resource.Loading -> {
_state.value = CoinListState(isLoading = true)
}
}
}.launchIn(viewModelScope)
        **/