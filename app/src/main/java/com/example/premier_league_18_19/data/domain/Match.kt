package com.example.premier_league_18_19.data.domain

data class Match(
    val year: Int,
    val homeTeamName: String,
    val awayTeamName: String,
    val homeTeamGoal: Int,
    val awayTeamGoal: Int,

    )