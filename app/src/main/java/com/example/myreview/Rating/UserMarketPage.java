package com.example.myreview.Rating;

import android.os.Bundle;

import com.example.myreview.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.myreview.Rating.ui.main.SectionsPagerAdapter;

public class UserMarketPage extends AppCompatActivity {

    private SectionsPageAdapter sectionsPageAdapter;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_market_page);
        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        viewPager = (ViewPager) findViewById(R.id.container);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
        setTabIcon();
    }


    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FollowingFragment(), "For Sale");
        adapter.addFragment(new FollowerFragment(), "For Rent");
        viewPager.setAdapter(adapter);
    }

    private void setTabIcon(){
        tabLayout.getTabAt(0).setIcon(R.drawable.for_sale);
        tabLayout.getTabAt(1).setIcon(R.drawable.for_rent);

    }
}