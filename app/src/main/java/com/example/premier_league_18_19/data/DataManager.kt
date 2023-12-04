package com.example.premier_league_18_19.data

import com.example.premier_league_18_19.data.domain.Match

object DataManager {

    private val matchList:List<Match> = mutableListOf()
    val matches :List<Match>
        get() = matchList

}