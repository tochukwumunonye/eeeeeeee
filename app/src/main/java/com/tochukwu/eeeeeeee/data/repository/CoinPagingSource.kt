package com.tochukwu.eeeeeeee.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tochukwu.eeeeeeee.data.remote.CoinDto
import com.tochukwu.eeeeeeee.data.remote.CoinPaprikaApi


/**


private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class CoinPagingSource(
    private val  api : CoinPaprikaApi
)  : PagingSource<Int, CoinDto>(){
    override fun getRefreshKey(state: PagingState<Int, CoinDto>): Int? {


    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CoinDto> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
        return try{
            val response = api.getCoins(position, params.loadSize)
            val coinx = response.body()

            LoadResult.Page(
                data =
                prevKey = if(position == UNSPLASH_STARTING_PAGE_INDEX ) null else position -1
            )
        }
    }


}

/**

private const val UNSPLASH_STARTING_PAGE_INDEX = 1


override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX

return try {
val response = unsplashApi.searchPhotos(query, position, params.loadSize)
val photos = response.results

LoadResult.Page(
data = photos,
prevKey = if ( position == UNSPLASH_STARTING_PAGE_INDEX) null else position - 1,
nextKey =  if (photos.isEmpty()) null else position + 1
)
} catch (exception: IOException){
LoadResult.Error(exception)
} catch (exception: HttpException){
LoadResult.Error(exception)
}

}
}
        **/