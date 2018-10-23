package com.iteso.proyectomoviles;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.proyectomoviles.beans.AdapterSummoner;
import com.iteso.proyectomoviles.beans.Summoner;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmenInGame.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmenInGame#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmenInGame extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<Summoner> summonersRed = new ArrayList<Summoner>();
    ArrayList<Summoner> summonersBlue = new ArrayList<Summoner>();
    AdapterSummoner adapterSummoner, adapterSummonerBlue;
    RecyclerView recyclerViewRed, recyclerViewBlue;

    public FragmenInGame() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmenInGame.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmenInGame newInstance(String param1, String param2) {
        FragmenInGame fragment = new FragmenInGame();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_in_game, container, false);
        recyclerViewRed = view.findViewById(R.id.fragment_inGame_recycler_red);
        recyclerViewBlue = view.findViewById(R.id.fragment_inGame_recycler_blue);

        Summoner sum1 = new Summoner();
        sum1.setSummoner("Reius");
        sum1.setChampion("https://i.pinimg.com/originals/3c/27/be/3c27be4ee097331a1a28c970c2fc4894.png");
        sum1.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum1.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum2 = new Summoner();
        sum2.setSummoner("Jumbee");
        sum2.setChampion("https://i.pinimg.com/originals/3c/27/be/3c27be4ee097331a1a28c970c2fc4894.png");
        sum2.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum2.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");


        Summoner sum3 = new Summoner();
        sum3.setSummoner("TheKoots");
        sum3.setChampion("https://i.pinimg.com/originals/3c/27/be/3c27be4ee097331a1a28c970c2fc4894.png");
        sum3.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum3.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum4 = new Summoner();
        sum4.setSummoner("Cytedal");
        sum4.setChampion("https://i.pinimg.com/originals/3c/27/be/3c27be4ee097331a1a28c970c2fc4894.png");
        sum4.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum4.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum5 = new Summoner();
        sum5.setSummoner("Vegx");
        sum5.setChampion("https://i.pinimg.com/originals/3c/27/be/3c27be4ee097331a1a28c970c2fc4894.png");
        sum5.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum5.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum6 = new Summoner();
        sum6.setSummoner("Gerald");
        sum6.setChampion("https://vignette.wikia.nocookie.net/league-of-legends-lol/images/3/36/Brand_OriginalLoading.jpg/revision/latest?cb=20130927145302&path-prefix=es");
        sum6.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum6.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum7 = new Summoner();
        sum7.setSummoner("Uzi");
        sum7.setChampion("https://vignette.wikia.nocookie.net/league-of-legends-lol/images/3/36/Brand_OriginalLoading.jpg/revision/latest?cb=20130927145302&path-prefix=es");
        sum7.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum7.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum8 = new Summoner();
        sum8.setSummoner("Faker");
        sum8.setChampion("https://vignette.wikia.nocookie.net/league-of-legends-lol/images/3/36/Brand_OriginalLoading.jpg/revision/latest?cb=20130927145302&path-prefix=es");
        sum8.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum8.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum9 = new Summoner();
        sum9.setSummoner("Sneaky");
        sum9.setChampion("https://vignette.wikia.nocookie.net/league-of-legends-lol/images/3/36/Brand_OriginalLoading.jpg/revision/latest?cb=20130927145302&path-prefix=es");
        sum9.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum9.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        Summoner sum10 = new Summoner();
        sum10.setSummoner("Rekkles");
        sum10.setChampion("https://vignette.wikia.nocookie.net/league-of-legends-lol/images/3/36/Brand_OriginalLoading.jpg/revision/latest?cb=20130927145302&path-prefix=es");
        sum10.setSpell1("https://vignette.wikia.nocookie.net/leagueoflegends/images/5/5c/Flash_HD.png/revision/latest?cb=20180516213311");
        sum10.setSpell2("http://pm1.narvii.com/6568/db3d5344fb7f2db1474cdcf61f7353844c509ca9_00.jpg");

        summonersRed.add(sum1);
        summonersRed.add(sum2);
        summonersRed.add(sum3);
        summonersRed.add(sum4);
        summonersRed.add(sum5);
        summonersBlue.add(sum6);
        summonersBlue.add(sum7);
        summonersBlue.add(sum8);
        summonersBlue.add(sum9);
        summonersBlue.add(sum10);

        adapterSummoner = new AdapterSummoner(summonersRed);
        adapterSummonerBlue = new AdapterSummoner(summonersBlue);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerBlue
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerViewRed.setLayoutManager(layoutManager);
        recyclerViewBlue.setLayoutManager(layoutManagerBlue);
        recyclerViewBlue.setAdapter(adapterSummonerBlue);
        recyclerViewRed.setAdapter(adapterSummoner);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
