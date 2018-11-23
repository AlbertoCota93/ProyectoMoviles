package com.iteso.proyectomoviles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.iteso.proyectomoviles.Beans.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.net.ssl.HttpsURLConnection;

public class ActivitySplashScreen extends AppCompatActivity {

    public static final String MYPREFERENCES = "com.iteso.proyectomoviles.PREFERENCES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                User user = loadPreferences();
                if(user.isLogged()) {
                    Intent intent = new Intent(ActivitySplashScreen.this, ActivityMain.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(ActivitySplashScreen.this, ActivityLogin.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 2000);

    }

    public User loadPreferences() {
        SharedPreferences sharedPreferences =
                getSharedPreferences(MYPREFERENCES, MODE_PRIVATE);

        User user = new User();
        user.setEmail(sharedPreferences.getString("EMAIL", "UNKNOWN"));
        user.setPassword(sharedPreferences.getString("PWD", "1234"));
        user.setLogged(sharedPreferences.getBoolean("LOGGER", false));
        return user;
    }

    class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {

                Log.e("MyASYNCTASKMONIT", "Entro");

                String key = "RGAPI-007cfc79-42da-4f1a-bcc1-aecbd212c712";
                String urlProfile = "https://la1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+ "Reius" + "?api_key=" + key;

                URL url = new URL(urlProfile);
                String result = downloadUrl(url);

                JSONObject jsonObject = new JSONObject(result);

                Log.e("JSONOBJECTRES", jsonObject.toString());

                Log.e("JSONOBJECTRES", jsonObject.optString("profileIconId"));
                Log.e("JSONOBJECTRES", jsonObject.optString("summonerLevel"));

                String urlIcon = "http://ddragon.leagueoflegends.com/cdn/8.23.1/img/profileicon/" + jsonObject.optString("profileIconId") + ".png";
                Log.e("URLICON", urlIcon);


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
