package com.example.footballapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.footballapp.R
import com.example.footballapp.data.local.Constants.SPACE
import com.example.footballapp.data.local.Constants.ZERO_SCORE
import com.example.footballapp.data.model.MatchesItem
import com.example.footballapp.databinding.ListItemMatchesBinding
import com.example.footballapp.util.Status

class MainViewHolder(
    private val binding: ListItemMatchesBinding
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(currentItem: MatchesItem) {
        binding.apply {
            currentItem.apply {

                val time = utcDate?.substring(11, 16)
                tvHomeTeam.text = homeTeam.shortName
                tvAwayTeam.text = awayTeam.shortName
                tvCompetitionName.text = competition.name


                // Display a different color for each match status
                when (status) {
                    Status.IN_PLAY.status, Status.LIVE.status -> {
                        tvMatchStatus.setBackgroundResource(R.color.red)
                    }
                    Status.CANCELLED.status -> tvMatchStatus.setBackgroundResource(R.color.brown)
                    Status.FINISHED.status -> tvMatchStatus.setBackgroundResource(R.color.pink)
                    Status.TIMED.status -> tvMatchStatus.setBackgroundResource(R.color.medium_pink)
                    Status.PAUSED.status -> tvMatchStatus.setBackgroundResource(R.color.brown)
                }


                // In case the score received from server (null) set it to 0
                if (score.fullTime.home == null && score.fullTime.away == null) {
                    tvHomeScore.text = ZERO_SCORE
                    tvAwayScore.text = ZERO_SCORE
                } else {
                    tvHomeScore.text = score.fullTime.home.toString()
                    tvAwayScore.text = score.fullTime.away.toString()
                }


                // Rename TIMED status to NOT START
                tvMatchStatus.text = if (status == Status.TIMED.status){
                    root.context.getString(R.string.status_not_start)
                } else status


                // Display (Started) Or (Start)
                if (status == Status.FINISHED.status) {
                    val startedAt = root.context.getString(R.string.started_at) + SPACE + time
                    tvMatchTime.text = startedAt
                } else {
                    val startAt = root.context.getString(R.string.start_at) + SPACE + time
                    tvMatchTime.text = startAt
                }
            }
        }
    }
}