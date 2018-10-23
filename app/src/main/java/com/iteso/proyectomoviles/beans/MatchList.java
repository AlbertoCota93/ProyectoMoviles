package com.iteso.proyectomoviles.beans;

import com.iteso.proyectomoviles.R;

import java.util.ArrayList;

public class MatchList extends ArrayList<Match>{
    public MatchList(){
        add(new Match(1,"EarthShaker", R.drawable.last_game_hero, "5/3/20"));
        add(new Match(2,"EarthShaker", R.drawable.last_game_hero, "1/6/10"));
    }
}
