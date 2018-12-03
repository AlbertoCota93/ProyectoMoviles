package com.iteso.proyectomoviles;


import android.accounts.Account;
import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.iteso.proyectomoviles.database.AccountHandler;
import com.iteso.proyectomoviles.database.DatabaseHandler;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountSignin extends Fragment {




    public AccountSignin() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_account_signin, container, false);
        final DatabaseHandler dh = DatabaseHandler.getInstance(getActivity());

        final EditText lolAcc = v.findViewById(R.id.fragment_account_lol_user);
        final EditText dotaAcc = v.findViewById(R.id.fragment_account_dota_user);
        Button lolButton = v.findViewById(R.id.fragment_account_lol_button);
        Button dotaButton = v.findViewById(R.id.fragment_account_dota_button);

        lolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountHandler ac = new AccountHandler();
                String acc;
                acc = lolAcc.getText().toString();

                ac.addAccount(acc, "lol",dh);

            }
        });

        dotaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountHandler ac = new AccountHandler();
                String acc;
                acc = dotaAcc.getText().toString();

                ac.addAccount(acc,"dota", dh);
            }
        });
        return v;
    }



}
