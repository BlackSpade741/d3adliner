package net.d3adliner.d3adliner.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import net.d3adliner.d3adliner.model.Controller;
import net.d3adliner.deadliner.R;

import java.util.ArrayList;

public class TodayActivity extends MainActivity{
    ListView lvTodos, lvEvents, lvReminders;
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(R.layout.activity_today);

        // Set up list views

        lvTodos = (ListView) findViewById(R.id.lvTodos);
        TextView titleTodo = new TextView(this);
        titleTodo.setText(R.string.todos);
        lvTodos.addHeaderView(titleTodo);
        lvEvents = (ListView) findViewById(R.id.lvEvents);
        TextView titleEvents = new TextView(this);
        titleEvents.setText(R.string.events);
        lvEvents.addHeaderView(titleEvents);
        lvReminders = (ListView) findViewById(R.id.lvReminders);
        TextView titleReminders = new TextView(this);
        titleEvents.setText(R.string.reminders);
        lvReminders.addHeaderView(titleReminders);

        // highlight today in navigation drawer & disable
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_today) {
            return true;
        } else {
            goToActivity(id);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
