package com.example.shivanikoul.fragement;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;

import static com.example.shivanikoul.fragement.R.id.Fragment_container;
import static com.example.shivanikoul.fragement.R.id.articlefrag;


public class MainActivity extends AppCompatActivity {
    String article,headline;
//    Fragment head,Fragment_container;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_article);
        RelativeLayout rel =findViewById(R.id.headlinefrag);

        getSupportActionBar().setTitle( Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));
        String json = null;
        try {
            InputStream is = getApplication().getAssets().open("news.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Log.d("TEST",json);
            JSONObject obj = new JSONObject(json);

            headline=obj.getString("headline");
           article =obj.getString("article");


        } catch (Exception ex) {
            ex.printStackTrace();}

        final HeadlineFragment headlineFragment=new HeadlineFragment();
        Bundle bundle=new Bundle();
        bundle.putString("headline",headline);
        headlineFragment.setArguments(bundle);
        FragmentManager fragmentManager;
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.headlinefrag, headlineFragment).commit();
        rel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentFragment newsObj=new ContentFragment();
                Bundle bundle=new Bundle(  );
                bundle.putString("article",article);
                headlineFragment.setArguments(bundle);
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace( R.id.articlefrag,
                       ArticleFragment).commit();
            }
        } );



//        HeadlineFragment headlineFragment =new HeadlineFragment();
//        articleFragment fragmentmanager =new ArticleFragment();
//        fragmentmanager = getFragmentManager();

//        FragmentManager.beginTransaction().add(R.id.fragmentcontainer,headlineFragment).commit();

    }
}
