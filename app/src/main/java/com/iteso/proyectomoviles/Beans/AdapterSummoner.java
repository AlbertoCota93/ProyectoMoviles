package com.iteso.proyectomoviles.Beans;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.iteso.proyectomoviles.R;

import com.squareup.picasso.Picasso;

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


        Picasso.with( myViewHolder.champion.getContext().getApplicationContext()).load(summoner.getChampion()).fit().into(myViewHolder.champion);
        Picasso.with( myViewHolder.spell1.getContext().getApplicationContext()).load(summoner.getSpell1()).fit().into(myViewHolder.spell1);
        Picasso.with( myViewHolder.spell2.getContext().getApplicationContext()).load(summoner.getSpell2()).fit().into(myViewHolder.spell2);

    }

    @Override
    public int getItemCount(){

        return summoners.size();

    }


}


