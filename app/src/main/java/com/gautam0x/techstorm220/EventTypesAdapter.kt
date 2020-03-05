package com.gautam0x.techstorm220

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.islamkhsh.CardSliderAdapter
import kotlinx.android.synthetic.main.event_type_thumbnail.view.*

class EventTypesAdapter (private val events : ArrayList<EventTypes>,val context:Context) : CardSliderAdapter<EventTypesAdapter.MovieViewHolder>() {

    private val eventCounts = ArrayList<String>()

    init {
        eventCounts.add("7")
        eventCounts.add("4")
        eventCounts.add("4")
        eventCounts.add("2")
    }

    override fun getItemCount() = events.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_type_thumbnail, parent, false)
        return MovieViewHolder(view)
    }

    override fun bindVH(holder: MovieViewHolder, position: Int) {

        holder.itemView.run{
            thumbnail_picture.setImageResource(events[position].eventThumbnail)
            event_type_text.text=events[position].eventType
            event_counter_text.text= eventCounts[position]
            btn_dive_in.setOnClickListener {
                val intent = Intent(context,EventCardSlideActivity::class.java)
                intent.putExtra("jsonFileName",events[position].eventJson)
                intent.putExtra("eventType",events[position].eventType)
                context.startActivity(intent)
            }
        }
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view)
}