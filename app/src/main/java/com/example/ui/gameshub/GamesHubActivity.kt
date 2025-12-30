package com.example.ui.gameshub

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ui.gameshub.databinding.ActivityGamesHubBinding

class GamesHubActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGamesHubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGamesHubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fetch star score from SharedPreferences
        val sharedPreferences: SharedPreferences = getSharedPreferences("wonderplay_prefs", Context.MODE_PRIVATE)
        val starScore = sharedPreferences.getInt("TOTAL_STARS", 0)
        binding.starScore.text = starScore.toString()

        // Setup RecyclerView with games
        val gamesList = listOf(
            GameItem("1", "Memory Match", R.drawable.ic_memory_match),
            GameItem("2", "Balloon Math", R.drawable.ic_balloon_math),
            GameItem("3", "Shape Sorter", R.drawable.ic_shape_sorter),
            GameItem("4", "Pattern Train", R.drawable.ic_pattern_train),
            GameItem("5", "Word Builder", R.drawable.ic_word_builder),
            GameItem("6", "Drawing Pad", R.drawable.ic_drawing_pad)
        )

        val adapter = GamesAdapter(gamesList) { gameId ->
            launchGame(gameId)
        }
        binding.recyclerViewGames.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerViewGames.adapter = adapter
    }

    private fun launchGame(gameId: String) {
        // Stub function, implement navigation if required
    }
}