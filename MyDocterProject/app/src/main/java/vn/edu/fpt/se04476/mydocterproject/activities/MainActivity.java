package vn.edu.fpt.se04476.mydocterproject.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import vn.edu.fpt.se04476.mydocterproject.R;
import vn.edu.fpt.se04476.mydocterproject.adapters.HomePageFunctionAdapter;
import vn.edu.fpt.se04476.mydocterproject.entities.FunctionType;
import vn.edu.fpt.se04476.mydocterproject.fragments.SearchAroundFragment;
import vn.edu.fpt.se04476.mydocterproject.managers.HeadlinesFragmentManager;
import vn.edu.fpt.se04476.mydocterproject.managers.ScreenManager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, SearchAroundFragment.OnFragmentInteractionListener, HeadlinesFragmentManager.OnHeadlineSelectedListener {
    private List<FunctionType> homePageForGuestList;
    private HomePageFunctionAdapter homePageFunctionAdapter;
    private Button btnSignin;

    private RecyclerView rvFunction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        identifyVariable();
        setupUI();
        setAction();
    }

    private void setAction() {
        btnSignin.setOnClickListener(this);
    }

    @SuppressLint("ResourceType")
    private void identifyVariable() {
        // Add function include image, color background and name to category
        homePageForGuestList = new ArrayList<>();
        homePageForGuestList.add(new FunctionType(
                0,
                getResources().getString(R.string.find_random_medical),
                R.drawable.ic_search_button,
                getResources().getString(R.color.bluePrimaryDark))
        );
        homePageForGuestList.add(new FunctionType(
                1,
                getResources().getString(R.string.sympton_comment),
                R.drawable.ic_sympton,
                getResources().getString(R.color.orangePrimaryDark))
        );
        homePageForGuestList.add(new FunctionType(
                2,
                getResources().getString(R.string.register_medical_service),
                R.drawable.ic_register_emergency,
                getResources().getString(R.color.purpilDark))
        );
        homePageForGuestList.add(new FunctionType(
                3,
                getResources().getString(R.string.find_random_medical),
                R.drawable.ic_about,
                getResources().getString(R.color.blueSecondDark))
        );

    }

    private void setupUI() {
        ButterKnife.bind(this);
        rvFunction = findViewById(R.id.rv_function);
        btnSignin = findViewById(R.id.btn_sign_in);

        //Recycle view function
        //Divide 2 column image here
        homePageFunctionAdapter = new HomePageFunctionAdapter(homePageForGuestList, getApplicationContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                getApplicationContext(),
                2,
                LinearLayoutManager.VERTICAL,
                false
        );
        rvFunction.setAdapter(homePageFunctionAdapter);
        rvFunction.setLayoutManager(gridLayoutManager);
        homePageFunctionAdapter.setOnItemClickListener(this);

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_new_feed) {
            // Handle the camera action
            Intent intentNewFeed = new Intent(this, NewFeedActivity.class);
            startActivity(intentNewFeed);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        try {
        //1. On Click Event for Item
        switch (view.getId()){
            case R.id.btn_sign_in:
                Intent intentSearchAround = new Intent(this, SignInActivity.class);
                startActivity(intentSearchAround);
                break;
        }

        //2. On Click Event for recyclview
        FunctionType functionType = (FunctionType) view.getTag();
        //Move to new Fragment here

            switch (functionType.getTagId()) {
                case 0:
                    Intent intentSearchAround = new Intent(this, SearchAroundActivity.class);
                    startActivity(intentSearchAround);
                    break;

                case 1:
                    Intent intentNewFeed = new Intent(this, PostSymptonActivity.class);
                    startActivity(intentNewFeed);
                    break;

                case 2:

                    break;

                case 3:

                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onArticleSelected(int position) {

    }
}
