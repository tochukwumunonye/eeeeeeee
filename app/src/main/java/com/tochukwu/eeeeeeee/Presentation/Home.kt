package com.tochukwu.eeeeeeee.Presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.tochukwu.eeeeeeee.R
import com.tochukwu.eeeeeeee.common.Adapter
import com.tochukwu.eeeeeeee.common.Status
import com.tochukwu.eeeeeeee.databinding.HomeLayoutBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class Home: Fragment(R.layout.home_layout) {

    private val viewModel: CoinListViewModel by viewModels()

    private var currentBinding: HomeLayoutBinding? = null
    private val binding get() = currentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentBinding = HomeLayoutBinding.bind(view)

        viewModel.getCoins()


        currentBinding = HomeLayoutBinding.bind(view)
        val homeAdapter = Adapter()

        binding?.apply {
            recycler.apply{
                adapter = homeAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
                itemAnimator?.changeDuration = 0
            }

            viewModel.coinz.observe(viewLifecycleOwner, Observer {
                it?.getContentIfNotHandled()?.let{result->
                    when(result.status){
                        Status.SUCCESS ->{
                            val  url = result.data
                            homeAdapter.submitList(url)
                        }
                      }
                    }
                })

            }
        }
    }


    /**
    private fun subscribeToObservers() {


    }
    //private var currentBinding: ActivityHomeBinding? = null
    //private val binding get() = currentBinding



}
/**
 *
 *Observers() {
viewModel.images.observe(viewLifecycleOwner, Observer {
it?.getContentIfNotHandled()?.let {result ->
when(result.status) {
Status.SUCCESS -> {
val urls = result.data?.hits?.map { imageResult -> imageResult.previewURL  }
imageAdapter.images = urls ?: listOf()
progressBar.visibility = View.GONE
}

Status.ERROR -> {
Snackbar.make(
requireActivity().rootLayout,
result.message ?: "An unknown error occurred.",
Snackbar.LENGTH_LONG
).show()
progressBar.visibility = View.GONE
}

Status.LOADING -> {
progressBar.visibility = View.VISIBLE
}
}

}
})
}



override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
super.onViewCreated(view, savedInstanceState)
viewModel = ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)
setupRecyclerView()
subscribeToObservers()

var job: Job? = null
etSearch.addTextChangedListener { editable ->
job?.cancel()
job = lifecycleScope.launch {
delay(300L)
editable?.let {
if(editable.toString().isNotEmpty()){
viewModel.searchForImage(editable.toString())
}
}
}

}

imageAdapter.setOnItemClickListener {
findNavController().popBackStack()
viewModel.setCurImageUrl(it)
}
}

private fun setupRecyclerView() {
rvImages.apply {
adapter = imageAdapter
layoutManager = GridLayoutManager(requireContext(), GRID_SPAN_COUNT)
}
}

}








 **/