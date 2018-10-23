package com.iteso.proyectomoviles.beans;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iteso.proyectomoviles.beans.MatchList;
import com.iteso.proyectomoviles.beans.MatchAdapter;

import com.iteso.proyectomoviles.R;

public class MatchAdapter extends BaseAdapter {

    private Context context;
    private MatchList matchList;
    public MatchAdapter(Context context, MatchList matchList){
    this.context = context;
    this.matchList = matchList;

    }
    @Override
    public int getCount() {
        return matchList.size();
    }

    @Override
    public Object getItem(int position) {
        return matchList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return matchList.get(position).getMatchId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Match match = matchList.get(position);
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      View matchView = layoutInflater.inflate(R.layout.match_history_layout,null);

        TextView matchId = matchView.findViewById(R.id.match_history_id);
        TextView matchHero = matchView.findViewById(R.id.match_history_hero);
        TextView matchKda = matchView.findViewById(R.id.match_history_kda);
        ImageView matchIcon = matchView.findViewById(R.id.match_history_hero_pic);

        matchId.setText(String.valueOf(match.getMatchId()));
        matchHero.setText(match.getMatchHero());
        matchKda.setText(match.getMatchKda());

        Drawable drawable = context.getResources().getDrawable(R.drawable.last_game_hero);
        matchIcon.setImageDrawable(drawable);
        return matchView;
    }
}
