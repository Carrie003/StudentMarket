package com.example.myreview.Rating;

import android.os.Bundle;

import com.example.myreview.R;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import java.util.ArrayList;

public class FollowingAndFollowerPage extends AppCompatActivity {
 private static final String TAG = "MainActivity";

    private SectionsPageAdapter sectionsPageAdapter;

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private Data source;
//    private FollowingFragment fragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Log.d(TAG, "onCreate: Starting.");

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
//        ArrayList<Objs> followingList = source.getUserFollowingsMap().get(source.getUser());

//        fragment.setArrayList(followingList);
        adapter.addFragment(new FollowingFragment(), "Following");
//        ArrayList<Objs> followersList = source.getUserFollowingsMap().get(source.getUser());
//        fragment.setArrayList(followersList);
        adapter.addFragment(new FollowerFragment(), "Followers");
        viewPager.setAdapter(adapter);
    }

    private void setTabIcon(){
        tabLayout.getTabAt(0).setIcon(R.drawable.following);
        tabLayout.getTabAt(1).setIcon(R.drawable.followers);

    }

}