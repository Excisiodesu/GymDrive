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

import java.util.ArrayList;


public class fragment_test2 extends Fragment {

    private RecyclerView commandRV;
    private RecyclerView.Adapter commandAdpater;
    private RecyclerView.LayoutManager commandLM;
    private Button btnfrg;

    public fragment_test2() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragment_test, container, false);
        ArrayList<CommandItem> commandList = new ArrayList<>();
        commandList.add(new CommandItem(R.drawable.ic_drink, 3.20f, 2, "Coca-Cola"));
        commandList.add(new CommandItem(R.drawable.ic_drink, 3.00f, 1, "Iced-Tea"));

        commandRV = v.findViewById(R.id.rv_commande);
        commandRV.setHasFixedSize(true);
        commandLM = new LinearLayoutManager(getActivity());
        commandAdpater = new CommandAdapter(commandList);

        commandRV.setLayoutManager(commandLM);
        commandRV.setAdapter(commandAdpater);
        btnfrg = (Button)v.findViewById(R.id.button_S);
        btnfrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), fragment_test.class);
                startActivity(myIntent);
            }
        });

        return v;
    }




}
