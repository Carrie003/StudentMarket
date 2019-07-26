package com.example.myreview.Rating;

import android.content.Intent;
import android.os.Bundle;

import com.example.myreview.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class UserPage extends AppCompatActivity implements View.OnClickListener {
    private TextView mTextMessage;
    private Map<String, Integer> titleImageMap;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    public void initiliazeFavoritesListView(){



//        titleImageMap = new HashMap<>();
//        titleImageMap.put("land explorer", R.drawable.land_explorer);
//        titleImageMap.put("book shelf", R.drawable.book_shlef);
//        titleImageMap.put("shopping cart", R.drawable.shopping_cart);
//        titleImageMap.put("wish list", R.drawable.wish_list);

        View view;


    }

//    public void initializeFollowingsListView(){
//        titleImageMap = new HashMap<>();
//        titleImageMap.put("following", R.drawable.following);
//
//
//
////        titleImageMap.put("book shelf", R.drawable.book_shlef);
////        titleImageMap.put("shopping cart", R.drawable.shopping_cart);
//    }



//    public void initializeActivitiesListView(){
//        titleImageMap.put("house exploring", R.drawable.house_exploring);
//        titleImageMap.put("book activities", R.drawable.book_shlef);
//        titleImageMap.put("item shopping", R.drawable.shopping_cart);
//        titleImageMap.put("wish list", R.drawable.wish_list);
//    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case (R.id.landExplore):
                goToDetailPage(RatingMain.class); //TODO change all class names
                break;
            case(R.id.bookShelf):
                goToDetailPage(RatingMain.class);
                break;
            case(R.id.shoppingCart):
                goToDetailPage(RatingMain.class);
                break;
            case(R.id.wishList):
                goToDetailPage(RatingMain.class);
                break;
            case (R.id.followings):
                goToDetailPage(RatingMain.class);
                break;
            case(R.id.messageBox):
                goToDetailPage(RatingMain.class);
                break;
            case(R.id.recentActivities):
                goToDetailPage(RatingMain.class);
                break;
            case(R.id.data):
                goToDetailPage(RatingMain.class);
                break;

        }

    }

    public void goToDetailPage(Class c){
        Intent intent = new Intent(getApplicationContext(), c);
        startActivity(intent);
    }
}
