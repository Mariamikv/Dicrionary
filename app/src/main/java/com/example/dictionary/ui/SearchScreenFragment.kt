package com.example.dictionary.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dictionary.adapters.WordsAdapter
import com.example.dictionary.databinding.FragmentSearchScreenBinding
import com.example.dictionary.utils.BaseFragment
import com.example.dictionary.view_models.SearchViewModel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class SearchScreenFragment : BaseFragment<FragmentSearchScreenBinding>(FragmentSearchScreenBinding::inflate) {

    private val viewModel = get<SearchViewModel>()
    private val wordsAdapter =  WordsAdapter()

    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){
        initRecyclerView()

        // get searched word
        binding.searchView.queryHint = "search word"
        binding.searchView.isSubmitButtonEnabled = true
        search()
    }

    private fun search(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewLifecycleOwner.lifecycleScope.launch {
                    if (query != null) {
                        observe(query)
                    }
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewLifecycleOwner.lifecycleScope.launch {
                    if (newText != null) {
                        observe(newText)
                    }
                }
                return true
            }

        })
    }

    private fun initRecyclerView(){
        binding.wordsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = wordsAdapter
        }
    }

    private suspend fun observe(word: String){
        viewModel.getWords(word).observe(viewLifecycleOwner, {
            wordsAdapter.setData(it)
        })
    }
}