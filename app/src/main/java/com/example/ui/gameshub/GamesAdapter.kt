package com.example.ui.gameshub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class GamesAdapter(
    private val games: List<GameItem>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<GamesAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.bind(game, onClick)
    }

    override fun getItemCount(): Int = games.size

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView = itemView.findViewById(R.id.gameCardView)
        private val gameIcon: ImageView = itemView.findViewById(R.id.gameIcon)
        private val gameName: TextView = itemView.findViewById(R.id.gameName)

        fun bind(game: GameItem, onClick: (String) -> Unit) {
            cardView.setCardBackgroundColor(itemView.resources.getColor(R.color.default_card_color))
            gameIcon.setImageResource(game.iconResId)
            gameName.text = game.name

            cardView.setOnClickListener {
                onClick(game.id)
            }
        }
    }
}