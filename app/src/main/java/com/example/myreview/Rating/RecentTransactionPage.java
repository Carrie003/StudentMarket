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

public class RecentTransactionPage extends AppCompatActivity {

    private SectionsPageAdapter sectionsPageAdapter;

    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_transaction_page);

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
//        adapter.addFragment(new FollowingFragment(), "Bought");
        adapter.addFragment(new FollowerFragment(), "For Sale");
        adapter.addFragment(new FollowingFragment(), "For Rent");
//        adapter.addFragment(new FollowerFragment(), "Rented Out");
        viewPager.setAdapter(adapter);
    }

    private void setTabIcon(){
//        tabLayout.getTabAt(0).setIcon(R.drawable.buy);
        tabLayout.getTabAt(0).setIcon(R.drawable.sell);
        tabLayout.getTabAt(1).setIcon(R.drawable.rent);
//        tabLayout.getTabAt(3).setIcon(R.drawable.rent_out);
    }


}