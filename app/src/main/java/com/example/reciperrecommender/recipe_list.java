package com.example.reciperrecommender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;

public class recipe_list extends AppCompatActivity {

    private ImageButton side_nave1;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.recipe_list);

        side_nave1 = (ImageButton) findViewById(R.id.side_nave);


        side_nave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDrawerLayout.openDrawer(Gravity.LEFT);

            }
        });
    }
}