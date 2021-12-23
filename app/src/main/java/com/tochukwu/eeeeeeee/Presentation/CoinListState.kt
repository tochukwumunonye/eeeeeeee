package com.tochukwu.eeeeeeee.Presentation

import com.tochukwu.eeeeeeee.domain.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""

)