package com.gautam0x.techstorm220

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RulesAdapter(data_arg:ArrayList<RulesDataModel>, context_arg: Context) : RecyclerView.Adapter<RulesAdapter.ViewHolder>(){

    // initialize Using Primary Constructor
    var data = data_arg
    var context = context_arg


    // Create Inner Class To Hold Cards
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        internal var titleTextView: TextView?= null
        internal var descTextView: TextView?=null

        init {
            titleTextView = itemView.findViewById(R.id.ruleTitleTxt)
            descTextView = itemView.findViewById(R.id.ruleDescTxt)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.ticket_rules,parent,false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView!!.text= data[position].ruleTitle
        holder.descTextView!!.text=data[position].ruleDescription
    }
}