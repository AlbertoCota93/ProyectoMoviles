package com.iteso.proyectomoviles.beans;

import com.iteso.proyectomoviles.R;

import java.util.ArrayList;

public class TeamList extends ArrayList<ProTeam> {
    public TeamList(){
    add(new ProTeam("Team Liquid", R.drawable.liquidlogo, "Europe", 1));
    }

    public TeamList(int game) {
        add(new ProTeam("H2K", R.drawable.h2klogo, "Europe", 1));
        add(new ProTeam("Vitality", R.drawable.vitalitylogo, "Europe", 2));
        add(new ProTeam("Unicorns of Love", R.drawable.uniconrslogo, "Europe", 3));
        add(new ProTeam("S04", R.drawable.s04logo, "Europe", 4));
    }
}
