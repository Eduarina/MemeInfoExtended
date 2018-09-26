package com.outlook.gonzososa.apps.multiscreenssupport;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements TouchListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction().replace (R.id.container, new ListadoFragment ())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit ();

        }


    @Override
    public void onTouchImageListener(int image) {
        Intent intent = new Intent(this, Info_Activity.class);
        intent.putExtra("id",image);
        startActivity (intent);

    }
}
