package com.example.fragment_03_agung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fragment_03_agung.fragment.HomeFragment
import com.example.fragment_03_agung.fragment.NotificationFragment
import com.example.fragment_03_agung.fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val HomeFragment = HomeFragment()
        val NotificationFragment = NotificationFragment()
        val SettingsFragment = SettingsFragment()

        makeCurrentFragment (HomeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.menu_home -> makeCurrentFragment(HomeFragment)
                R.id.menu_notification -> makeCurrentFragment(NotificationFragment)
                R.id.menu_settings -> makeCurrentFragment(SettingsFragment)
            }

            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }
    }
}