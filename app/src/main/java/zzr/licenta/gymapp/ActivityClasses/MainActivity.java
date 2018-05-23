package zzr.licenta.gymapp.ActivityClasses;

import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import zzr.licenta.gymapp.Configs.Constants;
import zzr.licenta.gymapp.Fragments.Plans;
import zzr.licenta.gymapp.Model.NoName;
import zzr.licenta.gymapp.MyLocalDataBase.DatabaseSQLite;
import zzr.licenta.gymapp.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedFragment(R.id.nav_plans);

        Constants.DATABASE = new DatabaseSQLite(getApplicationContext());
        if(Constants.DATABASE.numberOfRowsGroups()<1 || Constants.DATABASE.numberOfRowsExercise()<1) {
            for (NoName noname : Constants.initializeazaNoName()) {
                Constants.DATABASE.insertNoName(noname);
            }
        }

        Calendar cal = Calendar.getInstance();
        int currentWeekOfYear = cal.get(Calendar.WEEK_OF_YEAR);

        SharedPreferences sharedPreferences= this.getSharedPreferences("appInfo", 0);
        int weekOfYear = sharedPreferences.getInt("weekOfYear", 0);

        if(weekOfYear != currentWeekOfYear){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("weekOfYear", currentWeekOfYear);
            editor.commit();
            // Your once a week code here
            List<NoName> listGroups = Constants.DATABASE.getGroupsList();
            for (NoName no : listGroups) {
                Constants.DATABASE.updateStatusExerciseByGroupID(no.getId(),false);

            }
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedFragment(int id){
        Fragment fragment = new Plans();

        switch (id){
            case R.id.nav_plans:
                fragment = new Plans();
                break;
        }

        if(fragment!=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.drawer_layout,fragment);
            fragmentTransaction.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        displaySelectedFragment(id);



        return true;
    }
}
