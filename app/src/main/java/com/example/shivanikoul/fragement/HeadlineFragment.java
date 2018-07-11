package com.example.shivanikoul.fragement;

import android.app.Fragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HeadlineFragment extends Fragment {

    TextView headline;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v =inflater.inflate(R.layout.headline_frag,container,false);

        headline =v.findViewById(R.id.headingtextview);
        Bundle bundle =getArguments();
        
        headline.setText("Meet Israel first female tank commander");

        headline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        return v;
    }
}
