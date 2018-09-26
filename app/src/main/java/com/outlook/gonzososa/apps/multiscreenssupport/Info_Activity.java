package com.outlook.gonzososa.apps.multiscreenssupport;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class Info_Activity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.second_activity);

        getSupportFragmentManager()
                .beginTransaction().replace (R.id.container2 , new InfoFragment (getIntent().getIntExtra("id",-1)))
                .commit ();

    }

}
