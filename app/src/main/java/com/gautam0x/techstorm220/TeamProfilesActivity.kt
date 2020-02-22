package com.gautam0x.techstorm220

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_event_card_swipe.*
import kotlinx.android.synthetic.main.activity_team_profiles.*
import kotlinx.android.synthetic.main.activity_team_profiles.toolbar

class TeamProfilesActivity : AppCompatActivity() {

    var teamList = ArrayList<TeamDataModel>()
    var adapter:TeamProfilesAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_profiles)

        // Add Back Button on toolbar
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { finish() }

        teamList.add(TeamDataModel(R.drawable.scarlett,"Scarlett Johansson"))
        teamList.add(TeamDataModel(R.drawable.elizabeth,"Elizabeth olsen"))
        teamList.add(TeamDataModel(R.drawable.rdj,"Robert Downey"))
        teamList.add(TeamDataModel(R.drawable.scarlett,"Scarlett Johansson"))
        teamList.add(TeamDataModel(R.drawable.elizabeth,"Elizabeth olsen"))
        teamList.add(TeamDataModel(R.drawable.rdj,"Robert Downey"))
        teamList.add(TeamDataModel(R.drawable.scarlett,"Scarlett Johansson"))
        teamList.add(TeamDataModel(R.drawable.elizabeth,"Elizabeth olsen"))
        teamList.add(TeamDataModel(R.drawable.rdj,"Robert Downey"))
        teamList.add(TeamDataModel(R.drawable.scarlett,"Scarlett Johansson"))
        teamList.add(TeamDataModel(R.drawable.elizabeth,"Elizabeth olsen"))
        teamList.add(TeamDataModel(R.drawable.rdj,"Robert Downey"))
        teamList.add(TeamDataModel(R.drawable.scarlett,"Scarlett Johansson"))
        teamList.add(TeamDataModel(R.drawable.elizabeth,"Elizabeth olsen"))
        teamList.add(TeamDataModel(R.drawable.rdj,"Robert Downey"))
        teamList.add(TeamDataModel(R.drawable.scarlett,"Scarlett Johansson"))
        teamList.add(TeamDataModel(R.drawable.elizabeth,"Elizabeth olsen"))
        teamList.add(TeamDataModel(R.drawable.rdj,"Robert Downey"))
        teamList.add(TeamDataModel(R.drawable.scarlett,"Scarlett Johansson"))
        teamList.add(TeamDataModel(R.drawable.elizabeth,"Elizabeth olsen"))
        teamList.add(TeamDataModel(R.drawable.rdj,"Robert Downey"))
        teamList.add(TeamDataModel(R.drawable.scarlett,"Scarlett Johansson"))
        teamList.add(TeamDataModel(R.drawable.elizabeth,"Elizabeth olsen"))
        teamList.add(TeamDataModel(R.drawable.rdj,"Robert Downey"))

        adapter = TeamProfilesAdapter(this,teamList)
        gridViewId.adapter = adapter
    }
}
