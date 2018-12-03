package com.iteso.proyectomoviles;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.iteso.proyectomoviles.beans.Summoner;
import com.squareup.picasso.Picasso;


public class FragmentLolHome extends android.support.v4.app.Fragment {

    ImageView summonerIcon, championIcon, flexIcon, soloIcon;
    TextView summonerName, summonerLevel, championLevel, summonerSoloQ, summonerFlexQ;

    Summoner summoner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_lol_home, container, false);
        summonerIcon = view.findViewById(R.id.activity_lol_home_perfil);
        summonerName = view.findViewById(R.id.activity_lol_home_text_summonerd);
        summonerLevel = view.findViewById(R.id.activity_lol_home_level);
        summonerSoloQ = view.findViewById(R.id.activity_lol_home_rank_text);
        summonerFlexQ = view.findViewById(R.id.activity_lol_home_flex_queue_text);
        championIcon = view.findViewById(R.id.activity_lol_home_main);
        championLevel = view.findViewById(R.id.activity_lol_home_text_main);
        flexIcon = view.findViewById(R.id.activity_lol_home_flex_queue);
        soloIcon = view.findViewById(R.id.activity_lol_home_rank);

        //queue = view.findViewById(R.id.activity_lol_home_ranked);

        summoner = new Summoner();

        Log.e("HOME", "ENTRO A HOME");

        Bundle summonerBundle = getArguments();

        summoner.setSummonerIcon(summonerBundle.getString("IconId"));
        summoner.setSummoner(summonerBundle.getString("name"));
        summoner.setLevel(summonerBundle.getString("level"));
        summoner.setId(summonerBundle.getString("id"));
        summoner.setRankSolo(summonerBundle.getString("rankSolo"));
        summoner.setTierSolo(summonerBundle.getString("tierSolo"));
        summoner.setRankFlex(summonerBundle.getString("rankFlex"));
        summoner.setTierFlex(summonerBundle.getString("tierFlex"));

        String urlIcon = "http://ddragon.leagueoflegends.com/cdn/8.23.1/img/profileicon/" + summoner.getSummonerIcon() + ".png";
        String championIconUrl = "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/" + summonerBundle.getString("championId") + ".png";
        Picasso.with(getActivity().getApplicationContext()).load(urlIcon).fit().into(summonerIcon);
        Picasso.with(getActivity().getApplicationContext()).load(championIconUrl).fit().into(championIcon);
        summonerName.setText(summoner.getSummoner());
        summonerLevel.setText("LEVEL " + summoner.getLevel());
        championLevel.setText("MASTERIE " + summonerBundle.getString("championLevel"));

        if (summoner.getTierSolo().equals("UNRANKED"))
            summonerSoloQ.setText(summoner.getTierSolo());
        else
            summonerSoloQ.setText(summoner.getTierSolo() + " " + summoner.getRankSolo());

        if(summoner.getTierFlex().equals("UNRANKED"))
            summonerFlexQ.setText(summoner.getTierFlex());
        else
            summonerFlexQ.setText(summoner.getTierFlex() + " " + summoner.getRankFlex());

        String soloQIcon = summoner.getTierSolo().toLowerCase() + "_" + summoner.getRankSolo().toLowerCase();
        String flexQIcon = summoner.getTierFlex().toLowerCase() + "_" + summoner.getRankFlex().toLowerCase();

        Log.e("RANKS", soloQIcon);

        switch (soloQIcon){

            case "bronze_i": soloIcon.setImageResource(R.drawable.bronze_i); break;
            case "bronze_ii": soloIcon.setImageResource(R.drawable.bronze_ii); break;
            case "bronze_iii": soloIcon.setImageResource(R.drawable.bronze_iii); break;
            case "bronze_iv": soloIcon.setImageResource(R.drawable.bronze_iv); break;
            case "bronze_v": soloIcon.setImageResource(R.drawable.bronze_v); break;
            case "silver_i": soloIcon.setImageResource(R.drawable.silver_i); break;
            case "silver_ii": soloIcon.setImageResource(R.drawable.silver_ii); break;
            case "silver_iii": soloIcon.setImageResource(R.drawable.silver_iii); break;
            case "silver_iv": soloIcon.setImageResource(R.drawable.silver_iv); break;
            case "silver_v": soloIcon.setImageResource(R.drawable.silver_v); break;
            case "gold_i": soloIcon.setImageResource(R.drawable.gold_i); break;
            case "gold_ii": soloIcon.setImageResource(R.drawable.gold_ii); break;
            case "gold_iii": soloIcon.setImageResource(R.drawable.gold_iii); break;
            case "gold_iv": soloIcon.setImageResource(R.drawable.gold_iv); break;
            case "gold_v": soloIcon.setImageResource(R.drawable.gold_v); break;
            case "platinum_i": soloIcon.setImageResource(R.drawable.platinum_i); break;
            case "platinum_ii": soloIcon.setImageResource(R.drawable.platinum_ii); break;
            case "platinum_iii": soloIcon.setImageResource(R.drawable.platinum_iii); break;
            case "platinum_iv": soloIcon.setImageResource(R.drawable.platinum_iv); break;
            case "platinum_v": soloIcon.setImageResource(R.drawable.platinum_v); break;
            case "diamond_i": soloIcon.setImageResource(R.drawable.diamond_i); break;
            case "diamond_ii": soloIcon.setImageResource(R.drawable.diamond_ii); break;
            case "diamond_iii": soloIcon.setImageResource(R.drawable.diamond_iii); break;
            case "diamond_iv": soloIcon.setImageResource(R.drawable.diamond_iv); break;
            case "diamond_v": soloIcon.setImageResource(R.drawable.diamond_v); break;
            case "unranked_unranked": soloIcon.setImageResource(R.drawable.provisional); break;
            case "master_": soloIcon.setImageResource(R.drawable.master); break;
            case "challenger_": soloIcon.setImageResource(R.drawable.challenger); break;

        }

        switch (flexQIcon){

            case "bronze_i": flexIcon.setImageResource(R.drawable.bronze_i); break;
            case "bronze_ii": flexIcon.setImageResource(R.drawable.bronze_ii); break;
            case "bronze_iii": flexIcon.setImageResource(R.drawable.bronze_iii); break;
            case "bronze_iv": flexIcon.setImageResource(R.drawable.bronze_iv); break;
            case "bronze_v": flexIcon.setImageResource(R.drawable.bronze_v); break;
            case "silver_i": flexIcon.setImageResource(R.drawable.silver_i); break;
            case "silver_ii": flexIcon.setImageResource(R.drawable.silver_ii); break;
            case "silver_iii": flexIcon.setImageResource(R.drawable.silver_iii); break;
            case "silver_iv": flexIcon.setImageResource(R.drawable.silver_iv); break;
            case "silver_v": flexIcon.setImageResource(R.drawable.silver_v); break;
            case "gold_i": flexIcon.setImageResource(R.drawable.gold_i); break;
            case "gold_ii": flexIcon.setImageResource(R.drawable.gold_ii); break;
            case "gold_iii": flexIcon.setImageResource(R.drawable.gold_iii); break;
            case "gold_iv": flexIcon.setImageResource(R.drawable.gold_iv); break;
            case "gold_v": flexIcon.setImageResource(R.drawable.gold_v); break;
            case "platinum_i": flexIcon.setImageResource(R.drawable.platinum_i); break;
            case "platinum_ii": flexIcon.setImageResource(R.drawable.platinum_ii); break;
            case "platinum_iii": flexIcon.setImageResource(R.drawable.platinum_iii); break;
            case "platinum_iv": flexIcon.setImageResource(R.drawable.platinum_iv); break;
            case "platinum_v": flexIcon.setImageResource(R.drawable.platinum_v); break;
            case "diamond_i": flexIcon.setImageResource(R.drawable.diamond_i); break;
            case "diamond_ii": flexIcon.setImageResource(R.drawable.diamond_ii); break;
            case "diamond_iii": flexIcon.setImageResource(R.drawable.diamond_iii); break;
            case "diamond_iv": flexIcon.setImageResource(R.drawable.diamond_iv); break;
            case "diamond_v": flexIcon.setImageResource(R.drawable.diamond_v); break;
            case "unranked_unranked": flexIcon.setImageResource(R.drawable.provisional); break;
            case "master_": flexIcon.setImageResource(R.drawable.master); break;
            case "challenger_": flexIcon.setImageResource(R.drawable.challenger); break;

        }

        return view;
    }



}

