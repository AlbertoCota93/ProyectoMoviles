package com.iteso.proyectomoviles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.iteso.proyectomoviles.Beans.Summoner;

import java.util.ArrayList;

public class ActivityInGame extends AppCompatActivity {

    ArrayList<Summoner> summonersRed = new ArrayList<Summoner>();
    ArrayList<Summoner> summonersBlue = new ArrayList<Summoner>();
    AdapterSummoner adapterSummoner, adapterSummonerBlue;
    RecyclerView recyclerView, recyclerViewBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        Summoner sum1 = new Summoner();
        sum1.setSummoner("Reius");
        sum1.setChampion("https://i.pinimg.com/originals/3c/27/be/3c27be4ee097331a1a28c970c2fc4894.png");
        sum1.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum1.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum2 = new Summoner();
        sum2.setSummoner("Jumbee");
        sum2.setChampion("https://i.pinimg.com/originals/3c/27/be/3c27be4ee097331a1a28c970c2fc4894.png");
        sum2.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum2.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");


        Summoner sum3 = new Summoner();
        sum3.setSummoner("TheKoots");
        sum3.setChampion("https://i.pinimg.com/originals/3c/27/be/3c27be4ee097331a1a28c970c2fc4894.png");
        sum3.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum3.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum4 = new Summoner();
        sum4.setSummoner("Cytedal");
        sum4.setChampion("https://i.pinimg.com/originals/3c/27/be/3c27be4ee097331a1a28c970c2fc4894.png");
        sum4.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum4.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum5 = new Summoner();
        sum5.setSummoner("Vegx");
        sum5.setChampion("https://i.pinimg.com/originals/3c/27/be/3c27be4ee097331a1a28c970c2fc4894.png");
        sum5.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum5.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum6 = new Summoner();
        sum6.setSummoner("Gerald");
        sum6.setChampion("https://vignette.wikia.nocookie.net/league-of-legends-lol/images/3/36/Brand_OriginalLoading.jpg/revision/latest?cb=20130927145302&path-prefix=es");
        sum6.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum6.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum7 = new Summoner();
        sum7.setSummoner("Uzi");
        sum7.setChampion("https://vignette.wikia.nocookie.net/league-of-legends-lol/images/3/36/Brand_OriginalLoading.jpg/revision/latest?cb=20130927145302&path-prefix=es");
        sum7.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum7.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum8 = new Summoner();
        sum8.setSummoner("Faker");
        sum8.setChampion("https://vignette.wikia.nocookie.net/league-of-legends-lol/images/3/36/Brand_OriginalLoading.jpg/revision/latest?cb=20130927145302&path-prefix=es");
        sum8.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum8.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum9 = new Summoner();
        sum9.setSummoner("Sneaky");
        sum9.setChampion("https://vignette.wikia.nocookie.net/league-of-legends-lol/images/3/36/Brand_OriginalLoading.jpg/revision/latest?cb=20130927145302&path-prefix=es");
        sum9.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum9.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum10 = new Summoner();
        sum10.setSummoner("Rekkles");
        sum10.setChampion("https://vignette.wikia.nocookie.net/league-of-legends-lol/images/3/36/Brand_OriginalLoading.jpg/revision/latest?cb=20130927145302&path-prefix=es");
        sum10.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum10.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        summonersRed.add(sum1);
        summonersRed.add(sum2);
        summonersRed.add(sum3);
        summonersRed.add(sum4);
        summonersRed.add(sum5);
        summonersBlue.add(sum6);
        summonersBlue.add(sum7);
        summonersBlue.add(sum8);
        summonersBlue.add(sum9);
        summonersBlue.add(sum10);

        recyclerView = findViewById(R.id.activity_inGame_recycler_red);
        recyclerViewBlue = findViewById(R.id.activity_inGame_recycler_blue);

        adapterSummoner = new AdapterSummoner(summonersRed);
        adapterSummonerBlue = new AdapterSummoner(summonersBlue);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerBlue
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerViewBlue.setLayoutManager(layoutManagerBlue);
        recyclerViewBlue.setAdapter(adapterSummonerBlue);
        recyclerView.setAdapter(adapterSummoner);


    }
}
