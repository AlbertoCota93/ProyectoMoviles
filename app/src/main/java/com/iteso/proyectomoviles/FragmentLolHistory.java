package com.iteso.proyectomoviles;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.iteso.proyectomoviles.beans.Match;
import com.iteso.proyectomoviles.beans.MatchAdapter;
import com.iteso.proyectomoviles.beans.MatchList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentLolHistory extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_lol_history,container,false);

        Bundle matchBundle = getArguments();

        Log.e("MatchesHistory", matchBundle.getString("matches"));
        Log.e("MatchesHistory", matchBundle.getString("matchParticipants"));

        ListView listView = (ListView)view.findViewById(R.id.fragment_lol_matchHistory_list);

        final MatchList matchList = new MatchList();


        try {
            JSONArray matches = new JSONArray(matchBundle.getString("matches"));
            JSONArray matchParticipants = new JSONArray(matchBundle.getString("matchParticipants"));

            for(int i = 0; i < matches.length(); i++){

                String champion = "";
                String lane = "";
                String kills = "";
                String deaths = "";
                String assists = "";
                int matchId = 0;

                JSONObject temp = matches.getJSONObject(i);

                champion = temp.optString("champion");

                lane = temp.getString("lane");

                if(lane.equals("NONE"))
                    lane = "ARAM";

                matchId = i + 1;

                JSONObject tempJ = matchParticipants.getJSONObject(i);
                JSONObject tempStats = tempJ.getJSONObject("stats");

                deaths = tempStats.optString("deaths");
                kills = tempStats.optString("kills");
                assists = tempStats.optString("assists");

                String kda = kills + "-" + deaths + "-" + assists;
                String championIconUrl = "https://raw.communitydragon.org/latest/plugins/rcp-be-lol-game-data/global/default/v1/champion-icons/" + champion + ".png";

                Match tempMatch = new Match(matchId, lane, championIconUrl, kda);
                matchList.add(tempMatch);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        MatchAdapter matchAdapter = new MatchAdapter(getActivity(),matchList);

        listView.setAdapter(matchAdapter);
        // Inflate the layout for this fragment
        return view;
    }
}
