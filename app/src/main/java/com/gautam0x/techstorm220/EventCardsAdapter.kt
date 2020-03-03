package com.gautam0x.techstorm220

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.github.islamkhsh.CardSliderAdapter
import kotlinx.android.synthetic.main.event_type_thumbnail.view.*
import kotlinx.android.synthetic.main.ticket_event_card.view.*
import kotlinx.android.synthetic.main.ticket_event_card_swipe.view.*

class EventCardsAdapter (private val events : ArrayList<EventCardData>,val context: Context) : CardSliderAdapter<EventCardsAdapter.MovieViewHolder>() {

    override fun getItemCount() = events.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_event_card, parent, false)
        return MovieViewHolder(view)
    }

    override fun bindVH(holder: MovieViewHolder, position: Int) {

        holder.itemView.run{
            card_event_name.text=events[position].eventName
            card_short_desc.text=events[position].eventShortDesc
            card_event_thumb.setImageResource(events[position].eventThumbnail)
            card_more_info_btn.setOnClickListener {
                val intent = Intent(context,EventFullInformationActivity::class.java)
                intent.putExtra("currentJsonFilename",events[position].jsonFileName)
                intent.putExtra("stackPosition",position)
                context.startActivity(intent)
            }
        }
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view)
}