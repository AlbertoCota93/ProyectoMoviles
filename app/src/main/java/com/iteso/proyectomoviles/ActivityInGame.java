package com.iteso.proyectomoviles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iteso.proyectomoviles.Beans.Summoner;

import java.util.ArrayList;

public class ActivityInGame extends AppCompatActivity {

    ArrayList<Summoner> summoners = new ArrayList<>();
    AdapterSummoner adapterSummoner;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);


        Summoner sum1 = new Summoner();
        sum1.setSummoner("Reius");
        sum1.setChampion("https://i.pinimg.com/originals/3c/27/be/3c27be4ee097331a1a28c970c2fc4894.png");
        sum1.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum1.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        summoners.add(sum1);


        recyclerView = findViewById(R.id.activity_inGame_recycler);

        adapterSummoner = new AdapterSummoner(summoners);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterSummoner);

    }
}
