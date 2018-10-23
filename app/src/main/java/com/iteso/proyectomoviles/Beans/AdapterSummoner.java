package com.iteso.proyectomoviles.beans;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

<<<<<<< HEAD:app/src/main/java/com/iteso/proyectomoviles/Beans/AdapterSummoner.java
import com.iteso.proyectomoviles.R;
=======
>>>>>>> f0fbbcca7f5e610b8e99332d7b095195f334e53f:app/src/main/java/com/iteso/proyectomoviles/AdapterSummoner.java

import java.io.InputStream;
import java.util.List;

public class AdapterSummoner extends RecyclerView.Adapter<AdapterSummoner.MyViewHolder> {


    private List<Summoner> summoners;

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView summonerName;
        ImageView champion, spell1, spell2;

        MyViewHolder(View view){

            super(view);

            summonerName = view.findViewById(R.id.item_summoners_name);
            champion = view.findViewById(R.id.item_champion);
            spell1 = view.findViewById(R.id.item_spell1);
            spell2 = view.findViewById(R.id.item_spell2);
        }

    }

    public AdapterSummoner(List<Summoner> summoners){

        this.summoners = summoners;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_summoner, parent, false);

        return new MyViewHolder(item);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position){

        Summoner summoner = summoners.get(position);

        Log.d("Summoners", String.valueOf("Pinta a " + summoner.getSummoner()));

        myViewHolder.summonerName.setText(summoner.getSummoner());

        new DownloadImageTask(myViewHolder.champion).execute(summoner.getChampion());
        new DownloadImageTask(myViewHolder.spell1).execute(summoner.getSpell1());
        new DownloadImageTask(myViewHolder.spell2).execute(summoner.getSpell2());


    }

    @Override
    public int getItemCount(){

        return summoners.size();

    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap bmp = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                bmp = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bmp;
        }
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

}


