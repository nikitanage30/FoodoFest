package com.example.foodofest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity2 : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_menu.setNavigationItemSelectedListener(this)



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)

        when (item.itemId){
            R.id.profile -> {
                setToolbarTitle("Profile")
                changeFragment(ProfileFragment())
            }
            R.id.my_orders -> {
                setToolbarTitle("My Orders")
                changeFragment(OrdersFragment())
            }
            R.id.orders_history -> {
                setToolbarTitle("Orders History")
                changeFragment(OrdersHistoryFragment())
            }
            R.id.logout -> {
                setToolbarTitle("Logout")
                changeFragment(LogoutFragment())
            }

        }

        return true
    }

    fun setToolbarTitle(title : String) {
        supportActionBar?.title = title
    }

    fun changeFragment(frag : Fragment) {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container,frag).commit()

    }
}