package com.example.footballapp.data.local

import androidx.room.TypeConverter
import com.example.footballapp.data.model.AwayTeam
import com.example.footballapp.data.model.Competition
import com.example.footballapp.data.model.HomeTeam
import com.example.footballapp.data.model.Score
import com.google.gson.Gson


class Converter {

    // AwayTeam class
    @TypeConverter
    fun fromAwayTeam(team: AwayTeam): String {
        return Gson().toJson(team)
    }

    @TypeConverter
    fun toAwayTeam(shortName: String): AwayTeam {
        return Gson().fromJson(shortName,AwayTeam::class.java)
    }

    // Competition class
    @TypeConverter
    fun fromCompetition(competition: Competition): String {
        return Gson().toJson(competition)
    }

    @TypeConverter
    fun toCompetition(name: String): Competition {
        return Gson().fromJson(name,Competition::class.java)
    }

    // HomeTeam class
    @TypeConverter
    fun fromHomeTeam(team: HomeTeam): String {
        return Gson().toJson(team)
    }

    @TypeConverter
    fun toHomeTeam(name: String): HomeTeam {
        return Gson().fromJson(name,HomeTeam::class.java)
    }

    // Score class
    @TypeConverter
    fun fromScore(score: Score): String {
        return Gson().toJson(score)
    }

    @TypeConverter
    fun toScore(name: String): Score {
        return Gson().fromJson(name,Score::class.java)
    }
}