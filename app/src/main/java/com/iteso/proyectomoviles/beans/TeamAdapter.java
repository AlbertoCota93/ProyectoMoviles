package com.iteso.proyectomoviles.beans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iteso.proyectomoviles.R;

public class TeamAdapter extends BaseAdapter {

    private Context context;
    private TeamList teams;
    public  TeamAdapter(Context context, TeamList teams){
        this.context = context;
        this.teams = teams;
    }
    @Override
    public int getCount() {
        return teams.size();
    }

    @Override
    public Object getItem(int position) {
        return teams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return teams.get(position).getId();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProTeam team = teams.get(position);
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View teamView = layoutInflater.inflate(R.layout.pro_teams_layout,null);


        TextView teamName = teamView.findViewById(R.id.pro_team_name);
        TextView teamRegion = teamView.findViewById(R.id.pro_team_region);
        ImageView teamIcon = teamView.findViewById(R.id.pro_team_logo);


        teamName.setText(team.getName());
        teamRegion.setText(team.getRegion());

        Drawable drawable = context.getResources().getDrawable(R.drawable.liquidlogo);
        Drawable drawable1 = context.getResources().getDrawable(R.drawable.h2klogo);
        Drawable drawable2= context.getResources().getDrawable(R.drawable.s04logo);
        Drawable drawable3 = context.getResources().getDrawable(R.drawable.uniconrslogo);
        Drawable drawable4 = context.getResources().getDrawable(R.drawable.vitalitylogo);
        teamIcon.setImageDrawable(drawable1);
        teamIcon.setImageDrawable(drawable2);
        teamIcon.setImageDrawable(drawable3);
        teamIcon.setImageDrawable(drawable4);
        teamIcon.setImageDrawable(drawable);
        return teamView;
    }
}
