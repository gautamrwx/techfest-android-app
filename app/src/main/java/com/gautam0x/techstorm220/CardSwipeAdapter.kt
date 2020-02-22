package com.gautam0x.techstorm220

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CardSwipeAdapter : BaseAdapter {

    var cardList = ArrayList<CardSwipeData>()
    var context: Context? = null


    constructor(cList: ArrayList<CardSwipeData>, context: Context) {
        this.cardList = cList
        this.context = context
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val eventView = inflater.inflate(R.layout.ticket_event_card_swipe, parent, false)

        val evNameTextView = eventView.findViewById<TextView>(R.id.event_name)
        val evDescTextView = eventView.findViewById<TextView>(R.id.event_short_desc)
        val evPrizeTextView = eventView.findViewById<TextView>(R.id.prize_worth)
        val evImageVw = eventView.findViewById<ImageView>(R.id.card_event_banner)

        // Attach Image Of Event
        evImageVw.setImageResource(cardList[position].bannerDrawableResId)

        // Attach text to event card
        evNameTextView.text = cardList[position].eventName
        evDescTextView.text = cardList[position].eventShortDesc
        evPrizeTextView.text = cardList[position].prizeWorth

        return eventView
    }

    override fun getItem(position: Int): Any {
        return cardList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return cardList.size
    }
}
