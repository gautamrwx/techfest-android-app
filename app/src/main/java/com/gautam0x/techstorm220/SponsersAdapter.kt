package com.gautam0x.techstorm220

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.islamkhsh.CardSliderAdapter
import kotlinx.android.synthetic.main.ticket_event_card.view.*
import kotlinx.android.synthetic.main.ticket_sponsers_view.view.*

class SponsersAdapter(val sponsers:ArrayList<SponersModel>,val context:Context): CardSliderAdapter<SponsersAdapter.MovieViewHolder>() {

    override fun getItemCount() = sponsers.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_sponsers_view, parent, false)
        return MovieViewHolder(view)
    }

    override fun bindVH(holder: MovieViewHolder, position: Int) {

        holder.itemView.run{
            sp_text_1.text=sponsers[position].sponser_name
            sp_thmub_1.setImageResource(sponsers[position].sponser_thumb)
        }
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view)
}