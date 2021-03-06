package studio.akse.dpiexample;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TestUser (256-0010)");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
        //if (id == R.id.action_settings) {
          //  return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        displaySelectedScreen(item.getItemId());
        int id = item.getItemId();

       // if (id == R.id.nav_logout) {
         //   logoutUser();
        //}

        return true;
    }
    private void displaySelectedScreen(int itemId) {





        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_profile:
                Intent profile = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(profile);
                break;
            case R.id.nav_notif:
                Intent notif = new Intent(MainActivity.this,NotifActivity.class);
                startActivity(notif);
                break;
            case R.id.nav_quick:
                Intent quick = new Intent(MainActivity.this,QuickActivity.class);
                startActivity(quick);
                break;
            case R.id.nav_pay:
                Intent dpipay = new Intent(MainActivity.this,DpipayActivity.class);
                startActivity(dpipay);
                break;
            case R.id.nav_project:
                Intent projrt = new Intent(MainActivity.this,ProjectActivity.class);
                startActivity(projrt);
                break;
            case R.id.nav_land:
                Intent land = new Intent(MainActivity.this,LandActivity.class);
                startActivity(land);
                break;
            case R.id.nav_logout:
                Intent logout = new Intent(MainActivity.this, SplashActivity.class);
                startActivity(logout);
                finish();
                break;
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
