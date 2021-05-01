package com.aaditya.reciperecommender

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth



class pantry : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    //private var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //auth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_pantry)




//        val open_side_nav = findViewById(R.id.side_nave) as ImageButton
//        open_side_nav.setOnClickListener{
//            val intent = Intent(this, side_nav::class.java)
//            startActivity(intent)
//        }

        val search_recipes = findViewById(R.id.search_recipes) as CardView

        search_recipes.setOnClickListener {
            val intent = Intent(this, recipe_list::class.java)
            startActivity(intent)

        }

        val see_list = findViewById(R.id.see_list) as CardView

        see_list.setOnClickListener {
            val intent = Intent(this, Basket::class.java)
            startActivity(intent)

        }

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val side_btn = findViewById(R.id.side_nave) as ImageButton
        side_btn.setOnClickListener{
            val navDrawer: DrawerLayout = findViewById(R.id.pantry)
            navDrawer.openDrawer(Gravity.LEFT);
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.b1_pantry -> startActivity(Intent(this,pantry::class.java))
            R.id.b2_basket -> startActivity(Intent(this,Basket::class.java))
            R.id.b3_list -> startActivity(Intent(this,Shopping_List::class.java))
            R.id.b4_favourite -> startActivity(Intent(this,favourite_recipes::class.java))
            R.id.b5_settings -> startActivity(Intent(this,MainActivity::class.java))
            /*R.id.b6_logout -> {
                auth?.signOut();
                startActivity(Intent(this,LoginActivity::class.java))
            }*/
        }
//        drawer.closeDrawer(GravityCompat.START)
        return true


    }

}