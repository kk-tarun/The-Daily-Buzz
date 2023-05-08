package com.example.thedailybuzz

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NotificationCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: Toolbar

    private var viewPagerAdapter:TabsAdapter?=null
    private lateinit var pager: ViewPager
    private lateinit var tab: TabLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.menuBar)
        toolbar = findViewById(R.id.toolbar)

        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener{  menuItem ->
            when (menuItem.itemId) {
                R.id.home ->{
                    Toast.makeText(this@MainActivity, "Home Clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.favorite->{
                    Toast.makeText(this@MainActivity, "Favorite Clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.allCategories->{
                    Toast.makeText(this@MainActivity, "All Categories Clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.login->{
                    Toast.makeText(this@MainActivity, "Login Clicked", Toast.LENGTH_SHORT).show()
                    val intent: Intent = Intent(this, LoginPage::class.java)
                    startActivity(intent)
                }
                R.id.profile->{
                    Toast.makeText(this@MainActivity, "Profile Clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.logout->{
                    Toast.makeText(this@MainActivity, "Logout Successfull!", Toast.LENGTH_SHORT).show()
                    val intent: Intent = Intent(this, LoginPage::class.java)
                    startActivity(intent)
                }
                R.id.settings->{
                    Toast.makeText(this@MainActivity, "Settings Clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.helpFeedback->{
                    Toast.makeText(this@MainActivity, "Help & Feedback Clicked", Toast.LENGTH_SHORT).show()
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        };

        // tab Layout
        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)

        viewPagerAdapter =TabsAdapter(supportFragmentManager)
        pager.adapter=viewPagerAdapter
        tab.setupWithViewPager(pager)


        //Notificaation
        Handler().postDelayed({
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel("channelId", "channelName", NotificationManager.IMPORTANCE_DEFAULT)
                notificationManager.createNotificationChannel(channel)
            }

            val builder = NotificationCompat.Builder(this, "channelId")
                .setSmallIcon(R.drawable.baseline_notifications_active_24)
                .setContentTitle("New update on Sputnik V")
                .setContentText("Russia seeks India's help for Phase 3 trials")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            notificationManager.notify(0, builder.build())
        }, 10*1000)
    }
}
