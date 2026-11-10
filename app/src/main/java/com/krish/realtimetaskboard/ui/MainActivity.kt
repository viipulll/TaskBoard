package com.krish.realtimetaskboard.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.krish.realtimetaskboard.R
import com.krish.realtimetaskboard.databinding.ActivityMainBinding
import com.krish.realtimetaskboard.ui.activity.ActivityFragment
import com.krish.realtimetaskboard.ui.board.BoardFragment
import com.krish.realtimetaskboard.ui.dashboard.DashboardFragment
import com.krish.realtimetaskboard.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val dashboardFragment = DashboardFragment()
    private val boardFragment = BoardFragment()
    private val activityFragment = ActivityFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.navHostFragment, dashboardFragment)
                .commit()
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.nav_home -> dashboardFragment
                R.id.nav_board -> boardFragment
                R.id.nav_activity -> activityFragment
                R.id.nav_profile -> profileFragment
                else -> dashboardFragment
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.navHostFragment, selectedFragment)
                .commit()
            true
        }
    }
}
