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

import com.iteso.proyectomoviles.beans.Summoner;
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

    Summoner summoner = new Summoner();
    String urlProfile;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment_lol_home, container, false);
        String key = "RGAPI-007cfc79-42da-4f1a-bcc1-aecbd212c712";
        summoner.setSummoner("Reius");
        //summoner.setSummonerIcon("3799");

        //Log.e("SUMMONER", summoner.getSummonerIcon());

        Context c = getActivity().getApplicationContext();
        //Picasso.with(c).load(urlIcon).fit().into(summonerIcon); //Cuando se tenga el splashscreen descomente, porque si no truena alv

        urlProfile = "https://la1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+ summoner.getSummoner() + "?api_key=" + key;
        summonerIcon = view.findViewById(R.id.activity_lol_home_perfil);
        summonerName = view.findViewById(R.id.activity_lol_home_text_summonerd);



        summonerName.setText(summoner.getSummoner());

        Log.e("SUMMONCREATE", "Este es el summoner icon: " + summoners.get(0));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        new MyAsyncTask().execute();

    }

    class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {

                Log.e("MyASYNCTASKMONIT", "Entro");

                URL url = new URL(urlProfile);
                String result = downloadUrl(url);


                JSONObject jsonObject = new JSONObject(result);

                Log.e("JSONOBJECTRES", jsonObject.toString());

                summoner.setSummonerIcon(jsonObject.optString("profileIconId"));
                summoner.setLevel(jsonObject.optString("summonerLevel"));

                String urlIcon = "http://ddragon.leagueoflegends.com/cdn/8.23.1/img/profileicon/" + summoner.getSummonerIcon() + ".png";
                Log.e("URLICON", urlIcon);
                Log.e("SUMMONER", summoner.getLevel());

                URL url = new URL(urlProfile);
                String result = downloadUrl(url);


                JSONObject jsonObject = new JSONObject(result);

                Log.e("JSONOBJECTRES", jsonObject.toString());


            } catch (MalformedURLException e) {

            } catch (JSONException e) {

            } catch (IOException e) {

            }

            return null;
        }

        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
        }


        private String downloadUrl(URL url) throws IOException {
            InputStream stream = null;
            HttpsURLConnection connection = null;
            String result = null;
            try {
                connection = (HttpsURLConnection) url.openConnection();
                // Timeout for reading InputStream arbitrarily set to 3000ms.
                connection.setReadTimeout(3000);
                // Timeout for connection.connect() arbitrarily set to 3000ms.
                connection.setConnectTimeout(3000);
                // For this use case, set HTTP method to GET.
                connection.setRequestMethod("GET");
                // Open communications link (network traffic occurs here).
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode != HttpsURLConnection.HTTP_OK) {
                    throw new IOException("HTTP error code: " + responseCode);
                }
                // Retrieve the response body as an InputStream.
                stream = connection.getInputStream();
                if (stream != null) {
                    // Converts Stream to String with max length of 500.
                    result = readStream(stream);
                }
            } finally {
                // Close Stream and disconnect HTTPS connection.
                if (stream != null) {
                    stream.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            }
            return result;
        }

        private String readStream(InputStream stream) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        }
    }
}

