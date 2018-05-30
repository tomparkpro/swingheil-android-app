package pro.tompark.swingheil.controller

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import pro.tompark.swingheil.R
import pro.tompark.swingheil.adapter.EventAdapter
import pro.tompark.swingheil.service.EventService

class MainActivity : AppCompatActivity() {

    private val tag = MainActivity::class.simpleName

    private lateinit var eventAdapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        setupAdapter()

        EventService.getEvents(this) { findSuccess ->
            if (findSuccess) {
                Log.d(tag, "found ${EventService.events.size} events")
                eventAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun setupAdapter() {
        eventAdapter = EventAdapter(this, EventService.events)
        eventListView.adapter = eventAdapter
        eventListView.layoutManager = LinearLayoutManager(this)
    }

}
