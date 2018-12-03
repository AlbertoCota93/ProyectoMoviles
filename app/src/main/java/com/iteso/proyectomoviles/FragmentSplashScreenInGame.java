package com.iteso.proyectomoviles;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;

import java.util.Timer;
import java.util.TimerTask;

public class FragmentSplashScreenInGame extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                new LoadInGameAsyncTask().execute();
            }
        };

        Timer timer = new Timer();

        timer.schedule(task, 5000);

        return inflater.inflate(R.layout.fragment_fragment_splash_screen_in_game, container, false);
    }

    class LoadInGameAsyncTask  extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {

            } catch (Exception e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, new FragmenInGame()).commit();
        }
    }
}
