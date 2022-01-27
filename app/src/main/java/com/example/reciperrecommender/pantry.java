package com.example.reciperrecommender;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class pantry extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ImageButton side_nave1;
    private DrawerLayout mDrawerLayout;
    private CardView search_recipes;
    private CardView recipe_list1;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);

        side_nave1 = (ImageButton) findViewById(R.id.side_nave);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.pantry);
        search_recipes = (CardView) findViewById(R.id.search_recipes);
        recipe_list1 = (CardView) findViewById(R.id.see_list);

        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        side_nave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        search_recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pantry.this, recipe_display.class));
            }
        });


        recipe_list1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pantry.this, recipe_list.class));
            }
        });
    }

    private void checkUser(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser == null){
            startActivity(new Intent(this, LoginActivity.class));
        }
        else{
            String email = firebaseUser.getEmail();

        }
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
//            Intent intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);
              firebaseAuth.signOut();
              Log.d("myTag", "after firebase signout");
        }
        return true;

    }
}