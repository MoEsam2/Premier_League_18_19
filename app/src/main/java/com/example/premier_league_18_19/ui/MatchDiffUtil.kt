package com.example.premier_league_18_19.ui

import androidx.recyclerview.widget.DiffUtil
import com.example.premier_league_18_19.data.domain.Match

class MatchDiffUtil(private val oldList: List<Match>, private val newList: List<Match>) :
    DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return (oldList[oldItemPosition].homeTeamName == newList[newItemPosition].homeTeamName &&
                oldList[oldItemPosition].awayTeamName == newList[newItemPosition].awayTeamName
                )
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return true
    }
}