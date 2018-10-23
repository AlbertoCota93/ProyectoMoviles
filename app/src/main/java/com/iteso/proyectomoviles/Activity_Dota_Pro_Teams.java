package com.iteso.proyectomoviles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.iteso.proyectomoviles.beans.TeamAdapter;
import com.iteso.proyectomoviles.beans.TeamList;

public class Activity_Dota_Pro_Teams extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__dota__pro__teams);

        listView = findViewById(R.id.activity_dota_proTeams_list);

        final TeamList teamList = new TeamList();
        TeamAdapter teamAdapter = new TeamAdapter(this,teamList);
        listView.setAdapter(teamAdapter);
    }
}
