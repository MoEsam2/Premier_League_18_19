package com.example.premier_league_18_19.data

import com.example.premier_league_18_19.data.domain.Match

object DataManager {

    private val matchList = mutableListOf<Match>()
    val matches: List<Match>
        get() = matchList.toList()

    fun addMatch(match: Match) {
        matchList.add(match)
    }

    private var firstMatchCheck = 0
    fun addMatchAtIndex(match: Match, index: Int) {
        if (firstMatchCheck == 0) {
            matchList.add(index, match)
            firstMatchCheck += 1
        }
    }


}