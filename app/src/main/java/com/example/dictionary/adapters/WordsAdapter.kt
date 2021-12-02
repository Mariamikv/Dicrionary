package com.example.dictionary.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.databinding.WordsDisplayLayoutBinding
import com.example.dictionary.models.Words

class WordsAdapter: RecyclerView.Adapter<WordsAdapter.ViewHolder>() {

    private val wordsData = mutableListOf<Words>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = WordsDisplayLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(holder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = wordsData.size

    inner class ViewHolder(private val binding: WordsDisplayLayoutBinding): RecyclerView.ViewHolder(binding.root){
        private lateinit var dataModel: Words
        fun bind(){
            dataModel = wordsData[adapterPosition]
            with(binding){
                word.text = dataModel.word
                definition.text = dataModel.origin
                example.text = dataModel.meanings?.get(0)?.definitions?.get(0)?.example
                partOfSpeech.text = dataModel.meanings?.get(0)?.definitions?.get(0)?.definition
            }
        }
    }

    fun setData(data: List<Words>){
        wordsData.clear()
        wordsData.addAll(data)
        notifyDataSetChanged()
    }
}