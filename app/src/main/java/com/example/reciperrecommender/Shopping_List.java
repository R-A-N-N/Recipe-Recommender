package com.example.reciperrecommender;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class Shopping_List extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private ImageButton side_nave1;
    private DrawerLayout mDrawerLayout;
    private Button addBtn;
    private EditText regShoplistItem;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    List<String> shoppingList;
    ListView shopListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping__list);

        shoppingList = new ArrayList<>();

        addBtn = findViewById(R.id.add);
        regShoplistItem = findViewById(R.id.add_item);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("shoppingList");

                // add items to firebase
                String shoplist_item = regShoplistItem.getText().toString();

                shoppingList.add(shoplist_item);

                reference.setValue(shoppingList);


                // retrieve items from firebase to print in app
                ArrayList<String> shopArrayList = new ArrayList<>();

                ArrayAdapter<String> shopArrayAdapter = new ArrayAdapter<String>(Shopping_List.this,android.R.layout.simple_list_item_1,shopArrayList);

                shopListView = (ListView) findViewById(R.id.shoplist);
                shopListView.setAdapter(shopArrayAdapter);

                shopArrayList.clear();

                reference.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        String value = snapshot.getValue(String.class);
                        shopArrayList.add(value);
                        shopArrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                        shopArrayAdapter.notifyDataSetChanged();
                        shopArrayAdapter.clear();
                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        side_nave1 = (ImageButton) findViewById(R.id.side_nave);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.shopping_list);

        side_nave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


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