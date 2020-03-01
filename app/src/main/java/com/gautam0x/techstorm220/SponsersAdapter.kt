package com.gautam0x.techstorm220

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.islamkhsh.CardSliderAdapter
import kotlinx.android.synthetic.main.ticket_sponsers_view.view.*


class SponsersAdapter(val sponsers:ArrayList<SponersModel>,val context:Context): CardSliderAdapter<SponsersAdapter.MovieViewHolder>() {

    var loopPosition = 0

    override fun getItemCount() = sponsers.size/3

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ticket_sponsers_view, parent, false)
        return MovieViewHolder(view)
    }

    override fun bindVH(holder: MovieViewHolder, position: Int) {

        loopPosition = position*3

        holder.itemView.run{
            sp1_wrapper.setVisibility(sponsers[loopPosition].visiblity)
            sp_text_1.text=sponsers[loopPosition].sponser_name
            sp_thmub_1.setImageResource(sponsers[loopPosition].sponser_thumb)

            sp2_wrapper.setVisibility(sponsers[loopPosition+1].visiblity)
            sp_text_2.text=sponsers[loopPosition+1].sponser_name
            sp_thumb_2.setImageResource(sponsers[loopPosition+1].sponser_thumb)

            sp3_wrapper.setVisibility(sponsers[loopPosition+2].visiblity)
            sp_text_3.text=sponsers[loopPosition+2].sponser_name
            sp_thumb_3.setImageResource(sponsers[loopPosition+2].sponser_thumb)
        }
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view)
}