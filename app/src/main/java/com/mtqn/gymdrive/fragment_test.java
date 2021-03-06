package com.mtqn.gymdrive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;


public class fragment_test extends Fragment {

    private RecyclerView commandRV;
    private RecyclerView.Adapter commandAdpater;
    private RecyclerView.LayoutManager commandLM;
    private Button btnfrg;

    public fragment_test() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragment_test, container, false);
        ArrayList<CommandItem> commandeList = new ArrayList<>();
        commandeList.add(new CommandItem(R.drawable.ic_drink, 3.20f, 2, "Coca-Cola"));
        commandeList.add(new CommandItem(R.drawable.ic_drink, 3.00f, 1, "Iced-Tea"));
        commandeList.add(new CommandItem(R.drawable.ic_food, 5.20f, 4, "Big-Mac extra large"));

        commandRV = v.findViewById(R.id.rv_commande);
        commandRV.setHasFixedSize(true);
        commandLM = new LinearLayoutManager(getActivity());
        commandAdpater = new CommandAdapter(commandeList);

        commandRV.setLayoutManager(commandLM);
        commandRV.setAdapter(commandAdpater);
        btnfrg = (Button)v.findViewById(R.id.button_S);
        btnfrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), voiture.class);
                startActivity(myIntent);
            }
        });

        return v;
    }




    public static SQL sqlConnection = null;
    public void onServerStart() {
        //For testing purposes, address changed
        sqlConnection = new SQL("jdbc:mysql://oberon-serveurs.fr", "jorel", "jorel", "1ReANZZeUuQZhUcG", 3306);
        try {
            sqlConnection.getConnection();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        Toast.makeText(getActivity(), "Connecté", Toast.LENGTH_SHORT).show();
    }
    public static SQL getSqlConnection() {
        return sqlConnection;
    }


}
