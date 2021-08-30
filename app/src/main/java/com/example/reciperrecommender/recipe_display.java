package com.example.reciperrecommender;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

public class recipe_display extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ImageButton side_nave1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_display);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.recipe_display);
        side_nave1 = (ImageButton) findViewById(R.id.side_nave);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        side_nave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDrawerLayout.openDrawer(Gravity.LEFT);

            }
        });
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.b1_pantry) {

            Intent intent = new Intent(this, pantry.class);
            startActivity(intent);

        } else if (id == R.id.b2_basket) {
            Intent intent = new Intent(this, Basket.class);
            startActivity(intent);

        } else if (id == R.id.b3_list) {
            Intent intent = new Intent(this, Shopping_List.class);
            startActivity(intent);

        } else if (id == R.id.b4_favourite) {
            Intent intent = new Intent(this, favourite_recipes.class);
            startActivity(intent);

        } else if (id == R.id.b5_settings) {
            Intent intent = new Intent(this, Settings.class);
            startActivity(intent);

        } else if (id == R.id.b6_logout) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        return true;

    }
}