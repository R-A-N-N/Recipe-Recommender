package com.aaditya.reciperecommender

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_shopping__list.*


class Shopping_List : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private var mAdapter: ArrayAdapter<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping__list)

        val Item_name = findViewById(R.id.add_item) as EditText
        val list_view = findViewById(R.id.list) as ListView
        val add = findViewById(R.id.add) as Button


        mAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice)
        list_view.setAdapter(mAdapter)


        add.setOnClickListener {

            val item: String = Item_name.getText().toString()
            mAdapter!!.add(item)
            mAdapter!!.notifyDataSetChanged()
            Item_name.setText("")

        }

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val side_btn = findViewById(R.id.side_nave) as ImageButton
        side_btn.setOnClickListener{
            val navDrawer: DrawerLayout = findViewById(R.id.shopping_list)
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
            //R.id.b6_logout -> startActivity(Intent(this,LoginActivity::class.java))
        }
//        drawer.closeDrawer(GravityCompat.START)
        return true


    }
}