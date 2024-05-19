package com.example.gameratis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gameratis.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set toolbar sebagain actionbar
        setSupportActionBar(binding.toolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_contain) as NavHostFragment
        navController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_game, R.id.nav_favorite
        ).build()

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.apply {
            navBottom.setupWithNavController(navController)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}

//@AndroidEntryPoint
//class MainActivity : ComponentActivity() {
//    private lateinit var navController: NavController
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_contain) as NavHostFragment
//        navController = navHostFragment.findNavController()
//
//        val appBarConfiguration = AppBarConfiguration.Builder(
//            R.id.nav_game, R.id.nav_favorite
//        ).build()
//
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        binding.apply {
//            navBottom.setupWithNavController(navController)
//        }
//    }
//}

