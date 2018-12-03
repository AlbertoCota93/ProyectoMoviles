package com.iteso.proyectomoviles;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.iteso.proyectomoviles.Beans.User;
import com.iteso.proyectomoviles.Beans.Utils;

import org.json.JSONArray;
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
    String iconId, level, id, name, tier, rank;
    Boolean islogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if(isNetworkAvailable()) {
            Toast toast = Toast.makeText(ActivitySplashScreen.this,
                    "Necesitas tener conexión a Internet", Toast.LENGTH_LONG);
            toast.show();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                  finishAndRemoveTask();
                  System.exit(0);
                }
            };
            Timer timer = new Timer();
            timer.schedule(task,4000);
        }
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                User user = loadPreferences();
                islogin =  user.isLogged();
                if(user.isLogged()) {
                    new MyAsyncTask().execute();
                } else {
                    new MyAsyncTask().execute();//Quitar esto alv cuando este lo de la base de datos
                    //Intent intent = new Intent(ActivitySplashScreen.this, ActivityLogin.class);
                    //startActivity(intent);
                    //finish();
                }
            }
        };

        Timer timer = new Timer();


        timer.schedule(task, 5000);

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

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {

                String key = Utils.RIOT_KEY;
                String urlProfile = "https://la1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+ "Reius" + "?api_key=" + key;

                URL url = new URL(urlProfile);
                String result = downloadUrl(url);

                JSONObject jsonObject = new JSONObject(result);

                Log.e("JSONOBJECTRES", jsonObject.toString());

                Log.e("RESULT", result);

                iconId = jsonObject.optString("profileIconId");
                level = jsonObject.optString("summonerLevel");
                id = jsonObject.optString("id");
                name = jsonObject.optString("name");

                String urlQ = "https://la1.api.riotgames.com/lol/league/v3/positions/by-summoner/" + id + "?api_key=" + key;

                URL urlQueue = new URL(urlQ);
                String resultQ = downloadUrl(urlQueue);
                String resQ1 = resultQ.replace("[", "");
                String resQ = resQ1.replace("]", "");
                Log.e("RESULTQ", "Esto es resultQ: " + resQ);

                JSONObject jsonObjectQ = new JSONObject(resQ);

                //JSONArray jsonArray = jsonObjectQ.getJSONArray();
                //JSONObject jsonOSum = jsonArray.getJSONObject(0);

                Log.e("JSONQUEUE", jsonObjectQ.toString());

                tier = jsonObjectQ.optString("tier");
                rank = jsonObjectQ.optString("rank");

            } catch (MalformedURLException e) {

            } catch (JSONException e) {

            } catch (IOException e) {

            }

            return null;
        }

        protected void onPostExecute(Void aVoid) {
            Intent intent;
            AccessToken accessToken = AccessToken.getCurrentAccessToken();
            boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
            if(!(islogin || isLoggedIn)) {
                intent = new Intent(ActivitySplashScreen.this, ActivityLogin.class);
            } else {
                intent = new Intent(ActivitySplashScreen.this, ActivityMain.class);
            }
            Bundle mBundle = new Bundle();
            mBundle.putString("IconId", iconId);
            mBundle.putString("level", level);
            mBundle.putString("id", id);
            mBundle.putString("name", name);
            mBundle.putString("tier", tier);
            mBundle.putString("rank", rank);
            intent.putExtras(mBundle);
            startActivity(intent);
            finish();
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
