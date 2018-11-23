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

    ImageView summonerIcon;
    TextView summonerName, summonerLevel, summonerTier;
    RadioButton queue;

    Summoner summoner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_lol_home, container, false);
        summonerIcon = view.findViewById(R.id.activity_lol_home_perfil);
        summonerName = view.findViewById(R.id.activity_lol_home_text_summonerd);
        summonerLevel = view.findViewById(R.id.activity_lol_home_level);
        summonerTier = view.findViewById(R.id.activity_lol_home_rank_text);
        queue = view.findViewById(R.id.activity_lol_home_ranked);

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
        Picasso.with(getActivity().getApplicationContext()).load(urlIcon).fit().into(summonerIcon);
        summonerName.setText(summoner.getSummoner());
        summonerLevel.setText("Level " + summoner.getLevel());

        summonerTier.setText(summoner.getTierSolo() + " " + summoner.getRankSolo());

        queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!queue.isSelected()) {

                    summonerTier.setText(summoner.getTierSolo() + " " + summoner.getRankSolo());

                    queue.setChecked(true);
                    queue.setSelected(true);
                } else {

                    summonerTier.setText(summoner.getTierFlex());

                    queue.setChecked(false);
                    queue.setSelected(false);
                }
            }
        });

        return view;
    }



}

