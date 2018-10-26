package com.iteso.proyectomoviles;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.iteso.proyectomoviles.beans.MatchAdapter;
import com.iteso.proyectomoviles.beans.MatchList;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DotaMatchHistory extends android.support.v4.app.Fragment {

    public DotaMatchHistory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_dota__match__history,container,false);
        ListView listView = (ListView)view.findViewById(R.id.fragment_dota_matchHistory_list);

        final MatchList matchList = new MatchList();
        MatchAdapter matchAdapter = new MatchAdapter(getActivity(),matchList);
        listView.setAdapter(matchAdapter);
        // Inflate the layout for this fragment
        return view;
    }

}
