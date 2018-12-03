package com.iteso.proyectomoviles;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iteso.proyectomoviles.Beans.TeamAdapter;
import com.iteso.proyectomoviles.Beans.TeamList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DotaProTeams extends android.support.v4.app.Fragment {


    public DotaProTeams() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dota_pro_teams,container,false);
        ListView listView = (ListView)view.findViewById(R.id.fragment_dota_proTeams_list);


        final TeamList teamList = new TeamList();
        TeamAdapter teamAdapter = new TeamAdapter(getActivity(),teamList);
        listView.setAdapter(teamAdapter);
        return view;
    }

}
