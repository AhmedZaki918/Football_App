package com.example.footballapp.data.local

import androidx.room.TypeConverter
import com.example.footballapp.data.model.*
import com.google.gson.Gson


class Converter {

    // Converter for AwayTeam class
    @TypeConverter
    fun fromAwayTeam(team: AwayTeam?): String? {
        return Gson().toJson(team)
    }

    @TypeConverter
    fun toAwayTeam(shortName: String?): AwayTeam {
        return Gson().fromJson(shortName,AwayTeam::class.java)
    }


    // Converter for Competition class
    @TypeConverter
    fun fromCompetition(competition: Competition): String? {
        return Gson().toJson(competition)
    }

    @TypeConverter
    fun toCompetition(name: String): Competition {
        return Competition(name)
    }


    // Converter for HomeTeam class
    @TypeConverter
    fun fromHomeTeam(team: HomeTeam): String? {
        return Gson().toJson(team)
    }

    @TypeConverter
    fun toHomeTeam(name: String): HomeTeam {
        return HomeTeam(name)
    }


    // Converter for Score class
    @TypeConverter
    fun fromScore(score: Score): String? {
        return score.winner
    }

    @TypeConverter
    fun toScore(name: String): Score {
        return Score(name, name, HalfTime(), FullTime())
    }
}