package com.example.myreview.Rating;

import android.graphics.Color;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.myreview.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import yuku.ambilwarna.AmbilWarnaDialog;

public class RatingMain extends AppCompatActivity implements SearchView.OnQueryTextListener, AdapterView.OnItemClickListener {
    private TextView mTextMessage;
    private SearchView itemSearch;
    private CategoryListViewAdapter clAdapter;
    private RatingMainListViewAdapter rmAdapter;
    private Map<String, ArrayList<String>> allCategoriesMap;
//    private ArrayList<Integer> colo
    private int mDefaultColor;
    private RelativeLayout mLayout; //TODO initialize layout
//    private Button SearchColorButton, SearchBrandButton, FindPriceRangeButton;

//    private Spinner itemSpinner;

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


    public TextView createCategoryTag(String value, String valueColor) {
        TextView categoryValueTag = new TextView(this);
        categoryValueTag.setText(value);
        categoryValueTag.setBackgroundColor(Color.parseColor(valueColor));
        return categoryValueTag;

    }


    public TextView createPriceTag(String priceRange) {
//        switch (priceRange) {
//
//            case "0-10":
//
//            case "10-50":
//
//            case "50-100":
//
//            case "100-300":
//
//            case "300-500":
//
//            case "500-800":
//
//            case "800-1000":
//
//            case "10000-30000":
//
//            case "30000-50000":
//
//            case "50000-80000":
//
//            case "80000-100000":
//
//            case "100000-200000":
//
//            case "200000-300000":
//
//            case ">500000":
//
//
//        }

        Map<String, String> priceRangeColorMap = new HashMap<>();
        List<String> priceRangeColorList, priceRangeList;
        String categoryColorArray[] = new String[]{"#A3E4D7", "#D6EAF8", "#F5CBA7", "#D2B4DE", "#FADBD8", "#F9E79F", "#EC7063"}; //green, blue, orange, purple, pink, yellow, red
        priceRangeColorList = Arrays.asList(categoryColorArray);
        int index = 0;
        priceRangeList = allCategoriesMap.get("price");
        for (String range : priceRangeList) {

                priceRangeColorMap.put(range, priceRangeColorList.get(index));
                index++;
        }

       return createCategoryTag(priceRange, priceRangeColorMap.get(priceRange));
    }


    public TextView createBrandTag(String brandName){
        Map<String, String> brandNameColorMap = new HashMap<>();
        List<String> brandNameColorList, brandList;
        String brandNameColorArray[] = new String[]{"#A3E4D7", "#D6EAF8", "#F5CBA7", "#D2B4DE", "#FADBD8", "#F9E79F", "#EC7063"}; //green, blue, orange, purple, pink, yellow, red
        brandNameColorList = Arrays.asList(brandNameColorArray);
        int index = 0;
        brandList = allCategoriesMap.get("brand");
        for (String brand : brandList) {
            brandNameColorMap.put(brand, brandNameColorList.get(index));
            index++;
        }

        return createCategoryTag(brandName, brandNameColorMap.get(brandName));
    }

    public void filterByBrand(){

    }

    public TextView create(String brandName){
        Map<String, String> brandNameColorMap = new HashMap<>();
        List<String> brandNameColorList, brandList;
        String brandNameColorArray[] = new String[]{"#A3E4D7", "#D6EAF8", "#F5CBA7", "#D2B4DE", "#FADBD8", "#F9E79F", "#EC7063"}; //green, blue, orange, purple, pink, yellow, red
        brandNameColorList = Arrays.asList(brandNameColorArray);
        int index = 0;
        brandList = allCategoriesMap.get("brand");
        for (String brand : brandList) {
            brandNameColorMap.put(brand, brandNameColorList.get(index));
            index++;
        }

        return createCategoryTag(brandName, brandNameColorMap.get(brandName));
    }

    public void openColorPicker(View view){ //TODO add button to layout
        mDefaultColor = ContextCompat.getColor(RatingMain.this, R.color.colorPrimary );
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {

                mDefaultColor = color;
//                createColorTag(color);
                mLayout.addView(createColorTag(color),5, 5);


//                filterByColor(color);


//                colorLabel.setX();







            }
        });
        colorPicker.show();
    }

    public TextView createColorTag(int color){
        TextView colorLabel = new TextView(RatingMain.this);
        colorLabel.setBackgroundColor(color);

        return colorLabel;
    }


    public int getColorValue(int color){
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = Color.alpha(color);
        int colorValue = red+ green+ blue+ alpha;
        return colorValue;
    }


//    public void create
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }



    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        clAdapter.filterAll(text);
        return false;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getAdapter() == clAdapter){
            String attribute = clAdapter.getPositionCategoryMap().get(position);
            String value = clAdapter.getPositionValueMap().get(position);

            if(attribute.equals("price") ){
                rmAdapter.filterAll(attribute, value);
            }


//            switch(attribute){
//                case "":
//
//            }

//            if(attribute.equals("") || attribute.equals()){
//                rmAdapter.filterWithString(value, );
//            }


//            clAdapter.filterAll();
//            rmAdapter.filterWithList();


        }
    }

//    public void addColor

//    public void chooseToFilter(String attribute, String value){
////        if(attribute.equals("brand")){
////            rmAdapter.filterByBrand(value);
//////            rmAdapter.filterWithString(search, attribute);
////
////        }
////        else if(attribute){
////
////        }
////
////        switch(attribute){
////            case "brand":
////                rmAdapter.filterByBrand(value);
////            case "location":
////                rmAdapter.filterByLocation(value);
////            case "brand":
////                rmAdapter.filterBy(value);
////            case "brand":
////                rmAdapter.filterByBrand(value);
////            case "brand":
////                rmAdapter.filterByBrand(value);
//
//
//
//
//
////            case "color":
////                rmAdapter.filterByColor(value);
//
//
//        }



//    }

}


