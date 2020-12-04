package com.example.pokedex.screens.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.pokemon.PokemonAttack
import kotlinx.android.synthetic.main.rv_item_attack.view.*

class AttackRecyclerViewAdapter(
    private var pokemonAttackList: ArrayList<PokemonAttack>
) : RecyclerView.Adapter<AttackRecyclerViewAdapter.AttackListRecycleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttackListRecycleViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_attack, parent, false)

        return AttackListRecycleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AttackListRecycleViewHolder, position: Int) {
        val context = holder.itemView.context
        val currentItem = pokemonAttackList[position]

        holder.attackNameTV.text = currentItem.name
        holder.attackTypeIV.setImageResource(currentItem.elementType.image)
        holder.attackLevelTV.text =
            context.getString(R.string.attack_level, currentItem.levelNeeded.toString())
        holder.attackPpTV.text = context.getString(R.string.attack_pp, currentItem.pp.toString())
        holder.attackPowerTV.text =
            context.getString(R.string.attack_power, currentItem.power.toString())
        holder.attackAccTV.text =
            context.getString(R.string.attack_acc, currentItem.accuracy.toString())

    }

    override fun getItemCount() = pokemonAttackList.size

    class AttackListRecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val attackNameTV: TextView = itemView.attackNameTV
        val attackTypeIV: ImageView = itemView.attackTypeIV
        val attackLevelTV: TextView = itemView.attackLevelTV
        val attackPpTV: TextView = itemView.attackPpTV
        val attackPowerTV: TextView = itemView.attackPowerTV
        val attackAccTV: TextView = itemView.attackAccTV

    }
}