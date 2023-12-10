package com.example.premier_league_18_19.util

import com.example.premier_league_18_19.data.domain.Match

class CsvParser {
    fun parser(line: String): Match {
        val token = line.split(",")
        return Match(
            date = token[Constants.ColumnsIndex.Date],
            homeTeamName = token[Constants.ColumnsIndex.HOME_TEAM_NAME],
            awayTeamName = token[Constants.ColumnsIndex.AWAY_TEAM_NAME],
            homeTeamGoal = token[Constants.ColumnsIndex.HOME_TEAM_GOAL].toInt(),
            awayTeamGoal = token[Constants.ColumnsIndex.AWAY_TEAM_GOAL].toInt()
        )
    }
}