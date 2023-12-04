package com.example.premier_league_18_19.data

import com.example.premier_league_18_19.data.domain.Match

object DataManager {

    private val matchList = mutableListOf<Match>()
    val matches: List<Match>
        get() = matchList

    fun addMatch(match: Match) {
        matchList.add(match)
    }


}