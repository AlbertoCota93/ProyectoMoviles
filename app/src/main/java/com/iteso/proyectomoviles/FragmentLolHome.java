package com.iteso.proyectomoviles;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iteso.proyectomoviles.Beans.Summoner;
import com.squareup.picasso.Picasso;


public class FragmentLolHome extends android.support.v4.app.Fragment {

    ImageView summonerIcon;
    TextView summonerName, summonerLevel, summonerTier;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_lol_home, container, false);
        summonerIcon = view.findViewById(R.id.activity_lol_home_perfil);
        summonerName = view.findViewById(R.id.activity_lol_home_text_summonerd);
        summonerLevel = view.findViewById(R.id.activity_lol_home_level);
        summonerTier = view.findViewById(R.id.activity_lol_home_rank_text);

        Summoner summoner = new Summoner();

        Log.e("HOME", "ENTRO A HOME");

        Bundle summonerBundle = getArguments();
        Log.e("FRAGMENTICON", summonerBundle.getString("IconId"));
        Log.e("FRAGMENTICON", summonerBundle.getString("level"));
        Log.e("FRAGMENTICON", summonerBundle.getString("id"));
        Log.e("FRAGMENTICON", summonerBundle.getString("name"));

        summoner.setSummonerIcon(summonerBundle.getString("IconId"));
        summoner.setSummoner(summonerBundle.getString("name"));
        summoner.setLevel(summonerBundle.getString("level"));
        summoner.setId(summonerBundle.getString("id"));
        summoner.setRank(summonerBundle.getString("rank"));
        summoner.setTier(summonerBundle.getString("tier"));

        String urlIcon = "http://ddragon.leagueoflegends.com/cdn/8.23.1/img/profileicon/" + summoner.getSummonerIcon() + ".png";
        Picasso.with(getActivity().getApplicationContext()).load(urlIcon).fit().into(summonerIcon);
        summonerName.setText(summoner.getSummoner());
        summonerLevel.setText("Level " + summoner.getLevel());
        summonerTier.setText(summoner.getTier() + " " + summoner.getRank());



        return view;
    }


}

