package com.iteso.proyectomoviles;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iteso.proyectomoviles.beans.MatchAdapter;
import com.iteso.proyectomoviles.beans.MatchList;

public class FragmentLolHistory extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_lol_history,container,false);
        ListView listView = (ListView)view.findViewById(R.id.fragment_lol_matchHistory_list);

        final MatchList matchList = new MatchList();
        MatchAdapter matchAdapter = new MatchAdapter(getActivity(),matchList);
        listView.setAdapter(matchAdapter);
        // Inflate the layout for this fragment
        return view;
    }
}
