package com.example.underradarandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DatabaseManager.refresh()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration(
            setOf( R.id.homeFragment, R.id.playerListFragment, R.id.collegeListFragment, R.id.clubListFragment),
            binding.drawerLayout
        )
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNav.setupWithNavController(navController)
        binding.navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.termsAndConditions) {
            val action = NavGraphDirections.actionGlobalTermsFragment()
            navController.navigate(action)
            true
        } else {
            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
//
//import android.net.Uri
//import android.os.Bundle
//import com.google.android.material.bottomnavigation.BottomNavigationView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.setupActionBarWithNavController
//import androidx.navigation.ui.setupWithNavController
//import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
//import com.example.underradarandroid.Resources.DatabaseManager.getEventForId
//import com.example.underradarandroid.Resources.DatabaseManager.getUserForId
//import com.example.underradarandroid.databinding.ActivityMainBinding
//
//
//class MainActivity : AppCompatActivity() {
//
//    // region Private
//    private lateinit var binding: ActivityMainBinding
//    // endregion Private
//
//    // region LifeCycle
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        DatabaseManager.refresh()
//
//        val navView: BottomNavigationView = binding.navView
//
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_players, R.id.navigation_collegeList, R.id.navigation_clubs, R.id.navigation_more
//            )
//        )
//
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
//
//        handleDeepLink()
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
//    // endregion LifeCycle
//
//    // region DeepLinks
//    private fun handleDeepLink() {
//        val uri = intent.data
//        uri?.let {
//            if (uri.toString().contains("open-event")) {
//                handleOpenEvent(uri)
//            } else if (uri.toString().contains("open-user")) {
//                handleOpenUser(uri)
//            }
//        }
//    }
//
//    private fun handleOpenEvent(uri: Uri) {
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        val id = uri.getQueryParameter("id")
//        id?.let {
//            val event = DatabaseManager.getEventForId(id)
//            event?.let {
//                val bundle = Bundle()
//                bundle.putSerializable("event", event)
//                navController.navigate(R.id.action_navigation_home_to_eventFragment, bundle)
//            }
//        }
//    }
//
//    private fun handleOpenUser(uri: Uri) {
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        val id = uri.getQueryParameter("id")
//        id?.let {
//            val user = DatabaseManager.getUserForId(id)
//            user?.let {
//                val bundle = Bundle()
//                bundle.putSerializable("user", user)
//                navController.navigate(R.id.action_navigation_home_to_eventFragment, bundle)
//            }
//        }
//    }
//    // endregion DeepLinks
//}

