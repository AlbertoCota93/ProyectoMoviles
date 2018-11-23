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
import android.widget.TextView;

//import com.iteso.proyectomoviles.beans.Summoner;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class FragmentLolHome extends android.support.v4.app.Fragment {

    ImageView summonerIcon;
    TextView summonerName;

    //Summoner summoner = new Summoner();
    String urlProfile;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_lol_home, container, false);
        String key = "RGAPI-007cfc79-42da-4f1a-bcc1-aecbd212c712";
        //summoner.setSummoner("Reius");
        //summoner.setSummonerIcon("3799");

        //Log.e("SUMMONER", summoner.getSummonerIcon());

        Context c = getActivity().getApplicationContext();
        //String urlIcon = "http://ddragon.leagueoflegends.com/cdn/8.23.1/img/profileicon/" + summoner.getSummonerIcon() + ".png";

        //Picasso.with(c).load(urlIcon).fit().into(summonerIcon); //Cuando se tenga el splashscreen descomente, porque si no truena alv

        urlProfile = "https://la1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+ "3799" + "?api_key=" + key;
        summonerIcon = view.findViewById(R.id.activity_lol_home_perfil);
        summonerName = view.findViewById(R.id.activity_lol_home_text_summonerd);



        summonerName.setText("Reius");

        return view;
    }

}

