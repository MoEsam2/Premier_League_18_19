package com.example.premier_league_18_19.ui


import android.view.LayoutInflater
import android.widget.Toast
import com.example.premier_league_18_19.data.DataManager
import com.example.premier_league_18_19.data.domain.Match
import com.example.premier_league_18_19.databinding.ActivityMainBinding
import com.example.premier_league_18_19.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader


class MainActivity : BaseActivity<ActivityMainBinding>(), MatchInteractionListener {
    private lateinit var matchAdapter: MatchAdapter
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun setUp() {
        parseFile()
        matchAdapter = MatchAdapter(DataManager.matches, this)
        binding.recyclerMatch.adapter = matchAdapter
    }

    private fun parseFile() {
        val inputStream = assets.open("premier_league_18-19.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val csvParser = CsvParser()
        buffer.forEachLine {
            val currentMatch = csvParser.parser(it)
            DataManager.addMatch(currentMatch)
        }

    }

    override fun addCallBack() {
        binding.apply {
            fabAdd.setOnClickListener {
                addFirstMatch()
            }
        }

    }

    private fun addFirstMatch() {
        val firstMatch = Match(
            date = "10/08/2018",
            homeTeamName = "10/08/2018",
            awayTeamName = "Leicester",
            homeTeamGoal = 2,
            awayTeamGoal = 1
        )
        DataManager.addMatchAtIndex(firstMatch, 0)
        matchAdapter.setData(DataManager.matches)
    }

    override fun onCLickTeamName(name: String) {
        Toast.makeText(applicationContext, name, Toast.LENGTH_SHORT).show()
    }


}