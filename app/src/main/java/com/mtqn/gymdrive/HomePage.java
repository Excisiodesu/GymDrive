package com.mtqn.gymdrive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    private RecyclerView commandRV;
    private RecyclerView.Adapter commandAdpater;
    private RecyclerView.LayoutManager commandLM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ArrayList<CommandItem> commandeList = new ArrayList<>();
        commandeList.add(new CommandItem(R.drawable.ic_drink, 3.20f, 2, "Coca-Cola"));
        commandeList.add(new CommandItem(R.drawable.ic_drink, 3.00f, 1, "Iced-Tea"));
        commandeList.add(new CommandItem(R.drawable.ic_food, 5.20f, 4, "Big-Mac extra large"));

        commandRV = findViewById(R.id.rv_commande);
        commandRV.setHasFixedSize(true);
        commandLM = new LinearLayoutManager(this);
        commandAdpater = new CommandAdapter(commandeList);

        commandRV.setLayoutManager(commandLM);
        commandRV.setAdapter(commandAdpater);



        onServerStart();

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
        Toast.makeText(this, "Connecté", Toast.LENGTH_SHORT).show();
    }
    public static SQL getSqlConnection() {
        return sqlConnection;
    }

}
