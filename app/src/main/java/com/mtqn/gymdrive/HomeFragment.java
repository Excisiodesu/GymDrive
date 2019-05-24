package com.mtqn.gymdrive;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {

    public  HomeFragment(){


    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Toast.makeText(getActivity(),"Hello", Toast.LENGTH_LONG).show();
         View view  = inflater.inflate(R.layout.activity_home_page,container,false);
        Button button_S = (Button) view.findViewById(R.id.button_S);
        button_S.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), HomePage.class);
                in.putExtra("some","somme data");
                startActivity(in);
            }
        });
        return view;
    }

}
