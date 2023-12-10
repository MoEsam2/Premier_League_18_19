package com.example.premier_league_18_19.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.premier_league_18_19.R
import com.example.premier_league_18_19.data.domain.Match
import com.example.premier_league_18_19.databinding.ItemMatchBinding
import com.example.premier_league_18_19.databinding.ItemMatchesHeaderBinding

class MatchAdapter(private var list: List<Match> , val listener: MatchInteractionListener) :
    RecyclerView.Adapter<MatchAdapter.BaseViewHolder>() {

    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class MatchViewHolder(itemView: View) : BaseViewHolder(itemView) {
        val binding = ItemMatchBinding.bind(itemView)
    }

    class HeaderViewHolder(itemView: View) : BaseViewHolder(itemView) {
        val binding = ItemMatchesHeaderBinding.bind(itemView)
    }

    companion object {
        const val VIEW_TYPE_HEADER = 11
        const val VIEW_TYPE_MATCH = 12
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when (viewType) {
            VIEW_TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_matches_header, parent, false)
                return HeaderViewHolder(view)
            }

            VIEW_TYPE_MATCH -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
                return MatchViewHolder(view)
            }
        }
        return super.createViewHolder(parent, viewType)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            VIEW_TYPE_HEADER
        } else {
            VIEW_TYPE_MATCH
        }
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentMatch = list[position]
        when (holder) {
            is MatchViewHolder -> {
                holder.binding.apply {
                    textDate.text = currentMatch.date
                    textHomeTeam.text = currentMatch.homeTeamName
                    textAwayTeam.text = currentMatch.awayTeamName
                    textHomeGoal.text = currentMatch.homeTeamGoal.toString()
                    textAwayGoal.text = currentMatch.awayTeamGoal.toString()
                    textHomeTeam.setOnClickListener { listener.onCLickTeamName(currentMatch.homeTeamName) }
                    textAwayTeam.setOnClickListener { listener.onCLickTeamName(currentMatch.awayTeamName) }
                }
            }

            is HeaderViewHolder -> {

            }
        }
    }

    fun setData(newList:List<Match>){
        val diffResult = DiffUtil.calculateDiff(MatchDiffUtil(list , newList))
        list = newList
        diffResult.dispatchUpdatesTo(this)
    }
}