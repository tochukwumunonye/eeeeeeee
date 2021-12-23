package com.tochukwu.eeeeeeee.Presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.viewModelScope
import com.tochukwu.eeeeeeee.MainCoroutineRule
import com.tochukwu.eeeeeeee.common.Status
import com.tochukwu.eeeeeeee.repositories.FakeCoinRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import com.google.common.truth.Truth.assertThat
import com.tochukwu.eeeeeeee.common.Event
import com.tochukwu.eeeeeeee.data.remote.CoinDto
import com.tochukwu.eeeeeeee.getOrAwaitValueTest
import kotlinx.coroutines.currentCoroutineContext
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CoinListViewModelTest{

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

   private lateinit var viewModel: CoinListViewModel
  //  private  var fakeRepo = FakeCoinRepository()

    @Before
    fun setup(){

        viewModel = CoinListViewModel(FakeCoinRepository())
    }

    @Test
    fun `get data should fail`(){

        var fakeRepo = FakeCoinRepository()
        fakeRepo.setShouldReturnNetworkError(true)

        viewModel.getCoins()


        assertThat(viewModel.coinz.value?.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)

       // assertThat(viewModel.coinz.getOrAwaitValueTest()).isEqualTo(null)
    }



}
/**


//  viewModel.coinz.value  = Event(cc)
// val value = viewModel.coinz.getOrAwaitValueTest()

//  viewModel.coinz.value = Event(cc)
val  = viewModel.insertShoppingItemStatus.getOrAwaitValueTest()

// assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)


@Rule
public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();


PayoneerViewModel payoneerViewModel;

@Before
public void setup(){
/*FakeRepository fakeRepository =  new FakeRepository();
fakeRepository.errorNetwork = true;
payoneerViewModel = new PayoneerViewModel(fakeRepository);*/
}

@Test
public void getDataShouldFail() {
FakeRepository fakeRepository =  new FakeRepository();
fakeRepository.errorNetwork = true;
payoneerViewModel = new PayoneerViewModel(fakeRepository);
Assert.assertEquals(payoneerViewModel.getRemoteData().getValue().getStatus(), APIWrapper.Status.FAILURE);
}

@Test
public void getDataShouldSucceed() {
FakeRepository fakeRepository =  new FakeRepository();
fakeRepository.errorNetwork = false;
payoneerViewModel = new PayoneerViewModel(fakeRepository);
Assert.assertEquals(payoneerViewModel.getRemoteData().getValue().getStatus(), APIWrapper.Status.SUCCESS);

}

@Test
public void verifySuccessNotNull() {
FakeRepository fakeRepository =  new FakeRepository();
fakeRepository.errorNetwork = false;
payoneerViewModel = new PayoneerViewModel(fakeRepository);
Assert.assertNotNull(payoneerViewModel.getRemoteData().getValue().getData());

}



}










package com.example.shoppinglist.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.data.local.ShoppingItem
import com.example.shoppinglist.data.remote.responses.ImageResponse
import com.example.shoppinglist.other.Resource

class FakeShoppingRepository : ShoppingRepository {

val shoppingItems = mutableListOf<ShoppingItem>()

private val observableShoppingItems = MutableLiveData<List<ShoppingItem>>(shoppingItems)

private val observableTotalPrice = MutableLiveData<Float>()

private var shouldReturnNetworkError = false

fun setShouldReturnNetworkError(value: Boolean) {
shouldReturnNetworkError = value
}

private fun refreshLiveData() {
observableShoppingItems.postValue(shoppingItems)
observableTotalPrice.postValue(getTotalPrice())
}

private fun getTotalPrice() : Float {
return shoppingItems.sumByDouble { it.price.toDouble() }.toFloat()
}

override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
shoppingItems.add(shoppingItem)
refreshLiveData()
}

override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
shoppingItems.remove(shoppingItem)
refreshLiveData()
}

override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
return observableShoppingItems
}

override fun observeTotalPrice(): LiveData<Float> {
return observableTotalPrice
}

override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
return if(shouldReturnNetworkError) {
Resource.error("Error", null)
} else {
Resource.success(ImageResponse(listOf(), 0, 0))
}
}
}



**/