package com.example.reciperrecommender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class pantry extends AppCompatActivity {

    private ImageButton side_nave1;
    private DrawerLayout mDrawerLayout;
    private CardView search_recipes;
    private CardView recipe_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);

        side_nave1 = (ImageButton) findViewById(R.id.side_nave);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.pantry);
        search_recipes = (CardView) findViewById(R.id.search_recipes);
        recipe_list = (CardView) findViewById(R.id.recipe_list);

        side_nave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

//        search_recipes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(pantry.this, recipe_display.class));
//            }
//        });
//
//
//        recipe_list.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(pantry.this, recipe_list.class));
//            }
//        });
    }
}