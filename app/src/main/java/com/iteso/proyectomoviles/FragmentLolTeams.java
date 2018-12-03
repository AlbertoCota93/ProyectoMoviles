package com.iteso.proyectomoviles;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iteso.proyectomoviles.Beans.TeamAdapter;
import com.iteso.proyectomoviles.Beans.TeamList;


public class FragmentLolTeams extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_lol_teams,container,false);
        ListView listView = (ListView)view.findViewById(R.id.fragment_lol_proTeams_list);


        final TeamList teamList = new TeamList();
        TeamAdapter teamAdapter = new TeamAdapter(getActivity(),teamList);
        listView.setAdapter(teamAdapter);
        return view;
    }
}
