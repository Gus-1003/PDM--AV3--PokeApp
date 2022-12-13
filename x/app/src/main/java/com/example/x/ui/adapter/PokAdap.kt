package com.example.x.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.terceiraprova.model.Pok
import com.example.x.databinding.PokemonViewBinding

class PokAdap  : ListAdapter<Pok, PokAdap.PokemonViewHolder>(PokemonDiffUtilCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val remedio = getItem(position)
        holder.bind(remedio)
    }

    class PokemonViewHolder private constructor(var binding: PokemonViewBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(pokemon: Pok) {
            binding.nomePersonagem.text = pokemon.name

        }

        companion object {
            fun from(parent: ViewGroup): PokemonViewHolder {

                val inflater = LayoutInflater.from(parent.context)
                val binding = PokemonViewBinding.inflate(inflater, parent, false)
                return PokemonViewHolder(binding)
            }
        }
    }

    class PokemonDiffUtilCallback : DiffUtil.ItemCallback<Pok>(){
        override fun areItemsTheSame(oldItem: Pok, newItem: Pok): Boolean {
            return oldItem.name.equals(newItem.name)
        }

        override fun areContentsTheSame(oldItem: Pok, newItem: Pok): Boolean {
            return oldItem.equals(newItem)
        }

    }
}