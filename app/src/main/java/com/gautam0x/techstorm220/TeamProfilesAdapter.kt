package com.gautam0x.techstorm220

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.ticket_team_profile.view.*


class TeamProfilesAdapter: BaseAdapter {

    var context: Context?=null
    var dataList = ArrayList<TeamDataModel>()

    constructor(context: Context, dataList:ArrayList<TeamDataModel>){
        this.context = context
        this.dataList = dataList
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var person = dataList[position]

        var inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var personView = inflater.inflate(R.layout.ticket_team_profile,null)

        personView.personName.text = person.personName
        personView.profile_picture.setImageResource(person.profilePicDrawable)

        return personView
    }

    override fun getItem(position: Int): Any {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataList.size
    }

}