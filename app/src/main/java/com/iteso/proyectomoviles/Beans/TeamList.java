package com.iteso.proyectomoviles.Beans;

import com.iteso.proyectomoviles.R;

import java.util.ArrayList;

public class TeamList extends ArrayList<ProTeam> {
    public TeamList(){
    add(new ProTeam("Team Liquid", R.drawable.liquidlogo, "Europe", 1));
    }
}
