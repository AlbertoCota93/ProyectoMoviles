package com.iteso.proyectomoviles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iteso.proyectomoviles.beans.MatchAdapter;
import com.iteso.proyectomoviles.beans.MatchList;

import java.util.ArrayList;

public class ActivityDotaHistory extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dota_history);

        listView = findViewById(R.id.activity_dota_matchHistory_list);

      final MatchList matchList = new MatchList();
        MatchAdapter matchAdapter = new MatchAdapter(this,matchList);
        listView.setAdapter(matchAdapter);
    }


}
