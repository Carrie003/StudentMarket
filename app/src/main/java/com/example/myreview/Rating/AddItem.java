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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myreview.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import yuku.ambilwarna.AmbilWarnaDialog;

public class AddItem extends AppCompatActivity implements ListView.OnItemClickListener {
    private TextView mTextMessage;
    private Map<String, ArrayList<String>> allAttributesMap, attributesMap;
    private EditText tagField,  nameEditText, ratingEditText, priceEditText, sizeLowBoundEditText, sizeHighBoundEditText, reviewEditText, suggestionEditText, warningEditText, attributeValueEditText, customizedAttributeValueEditText;
    private String name, rating, price, size, review, suggestion, attributeValue, attribute, customizedAttributeType, customizedAttributeValue, lastColor;
    private Spinner categotySpinner, attributeTypeSpinner;
    private SearchView attributeSearchView;
    private CategoryListViewAdapter adapter;
    private ArrayList<String> colorList;
    private int tagNum;
    private RelativeLayout mLayout;
    private int mDefaultColor;



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
        setContentView(R.layout.activity_add_item);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        attributesMap = new HashMap();
        tagNum = 10;

        lastColor = "";

    }

    public void addButtonClicked(View view){ //TODO add button to layout






//        attributesMap = new HashMap<>();

//        attributesMap.put();

        if(isFilled(nameEditText) && isFilled(reviewEditText) && isFilled(reviewEditText) && isFilled(customizedAttributeValueEditText)){
//            Item item = new Item(name, rating, );
        }

    }

    public void initializeViews(){ //TODO


    }

    public void getAllText(){
        rating = ratingEditText.getText().toString();
        name = nameEditText.getText().toString();
        review = reviewEditText.getText().toString();
        suggestion = suggestionEditText.getText().toString();
        price = priceEditText.getText().toString(); //todo number
        size = sizeLowBoundEditText.getText().toString()+"-"+sizeHighBoundEditText.getText().toString();



//        attribute = attributeEditText.getText().toString();
//        attributeValue = attributeValueEditText.getText().toString();

    }
//    public String getCategory(){
//        Spinner categorySpinner;
//        String category;
//
//    }
//
//    public String getItemName(){
//
////        String name;
//
//        return name;
//    }
//
//
//
//
//    public String getReview(){
////        EditText reviewEditText;
////        String review;
//
//        return review;
//    }
//
//    public String getSuggestion(){
////        EditText suggestionEditText;
////        String suggestion;
//
//        return suggestion;
//
//    }
//
//    public void getAttributes(){
//
//        SearchView attributesSearchView;
//
//    }
//
//
//
//    public void addAttributes(){
//
//    }

    public void addCustomizedFeatureTag(View view){ //TODO add button to layout

//

//        Spinner attributeTypeSpinner;
        EditText customizedValueEditText;
        String attribute;
//        String customizedValue;


//        if(!attributesMap.get("feature").contains(attribute)){
//            allAttributesMap.put("feature", attribute);
//
//        }

//        allAttributesMap.get("feature").add(attribute);
//        if(attributesMap.containsKey(attribute)){
//
//            ArrayList<String> newValuesList = attributesMap.get(attribute);
//            newValuesList.add(customizedValue);
//            attributesMap.put(attribute, newValuesList);
//
//        }
//        else{
//            ArrayList<String> newValuesList = new ArrayList<>();
//            newValuesList.add(customizedValue);
//            attributesMap.put(attribute, newValuesList);
//        }


    }

//    public void addCustomizedButtonClicked(){ //TODO add button to layout
//
//    }
//

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//        String categoryparent.getAdapter().getItem(position);

       String attribute = adapter.getPositionCategoryMap().get(position);
       String value = adapter.getPositionValueMap().get(position);

       String tagColor;


//       String tagColor = createTagColorMap().get(attribute);
//       String valueColor = createValueColorMap().get(value);


//       attributesMap.put(attribute, value);
//       allAttributesMap.keySet().size();
        if(attributesMap.containsKey(attribute) && attributesMap.get(attribute).contains(value)){
            Toast.makeText(this, "The tag has already exists, try another one", Toast.LENGTH_SHORT).show();

        }
        else{
            tagNum--;
        }


        if(attributesMap.containsKey(attribute)){

            ArrayList<String> newValuesList = attributesMap.get(attribute);
            newValuesList.add(value);
            attributesMap.put(attribute, newValuesList);

        }
        else{
            ArrayList<String> newValuesList = new ArrayList<>();
            newValuesList.add(value);
            attributesMap.put(attribute, newValuesList);
        }
//      switch (attribute){
//
//          case "color":
//              color =
//
//       }
//        attributeSearchView.addView(createAttributeValueLabel(value, tagColor));
//        tagField.addView(createAttributeValueLabel(value, tagColor));


        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

//        RelativeLayout vcrl =  findViewById(R.id.vcrl);
//        RelativeLayout vcrl;

        switch(attribute) {

            case "utility":
                tagColor = "#A3E4D7"; //green
                break;
            case "appearance":
                tagColor = "#FADBD8"; //pink
                break;
//            case "suggestion":
//                tagColor = "#F9E79F"; //yellow
//                break;
//            case "warning":
//                tagColor =  "#EC7063"; //red
//                break;
            default:
                tagColor = "#E5E7E9"; //grey
                break;


        }
//        if(attribute.equals("feature")){
//            tagColor = generateFeatureColor();
//        }
//        else if{
//
//        }
        mLayout.addView(createAttributeTag(value, tagColor));





//        tagField.addView(createAttributeValueLabel(value, tagColor));




    }



    public Map<String, ArrayList<String>> getAllAttributesMap(){
        return allAttributesMap;
    }


    public boolean isFilled(EditText editText){
        if(!editText.getText().toString().equals("")){
            return true;
        }

        else{
            editText.setBackgroundColor(Color.parseColor("#F1948A"));
            return false;
        }
    }

//    public TextView createAttributeTag(String attribute,  String attributeColor){
//
//
//        TextView attributeLabel = new TextView(this);
//        attributeLabel.setText(attribute);
//        attributeLabel.setBackgroundColor(Color.parseColor(attributeColor));
//
//
//
//        return  attributeLabel;
//
////        attributeLabel.setText(R.string.vertical_line);
//
//
//
//    }

    public TextView createAttributeTag(String value, String valueColor){
        TextView attributeValueLabel = new TextView(this);
        attributeValueLabel.setText(value);
        attributeValueLabel.setBackgroundColor(Color.parseColor(valueColor));
        return attributeValueLabel;


    }



    public String generateFeatureColor(){
        List<String> featureColorList = new ArrayList<>();
        String featureColorArray[] = new String[]{"#A3E4D7", "#D6EAF8", "#F5CBA7", "#D2B4DE","#FADBD8", "#F9E79F", "#EC7063"}; //green, blue, orange, purple, pink, yellow, red
        featureColorList = Arrays.asList(featureColorArray);
        Random ran = new Random();
        Integer index =  ran.nextInt(7);
        String color = featureColorList.get(index);

        while(color.equals(lastColor)){
            index =  ran.nextInt(7);
            color = featureColorList.get(index);
        }
        lastColor = color;
        return  color;
    }
    public Map<String, String> createTagColorMap() {
        Map<String, String> attributeColorMap = new HashMap<>();
        List<String> attributeColorList;
        String attributeColorArray[] = new String[]{"#A3E4D7", "#D6EAF8", "#F5CBA7", "#D2B4DE","#FADBD8", "#F9E79F", "#EC7063"}; //green, blue, orange, purple, pink, yellow, red
        attributeColorList = Arrays.asList(attributeColorArray);
        int index = 0;
//        for(String attribute: allAttributesMap.keySet()){
//
//
//        }

        for (String attribute : allAttributesMap.keySet()) {

            attributeColorMap.put(attribute, attributeColorList.get(index));
            index++;


//        return attributeColorList;


        }
        return attributeColorMap;
    }

//    public Map<String, String> createValueColorMap() {
//        Map<String, String> valueColorMap = new HashMap<>();
//        List<String> valueColorList;
//        String valueColorArray[] = new String[]{"#A3E4D7", "#D6EAF8", "#F5CBA7", "#D2B4DE","#FADBD8", "#F9E79F", "#EC7063"};  //green, blue, orange, purple, pink, yellow, red
//        valueColorList = Arrays.asList(valueColorArray);
//        int index = 0;
////        for(String attribute: allAttributesMap.keySet()){
////
////
////        }
//
//        for (String attribute : allAttributesMap.keySet()) {
//
//            valueColorMap.put(attribute, valueColorList.get(index));
//            index++;
//
//
////        return attributeColorList;
//
//
//        }
//        return valueColorMap;
//    }

//    public void create

//
//    public void addAttributesToMap(){
//
//
//    }
//
//

    public void addWarningTag(View view){ //TODO add button to layout
        String warning = warningEditText.getText().toString();
//        TextView warningText = new TextView(this);
//        warningText.setText(warning);
//        mLayout.addView(warningText);
        createAttributeTag(warning, "");



    }

    public void addSuggestionTag(View view){ //TODO add button to layout

        String suggestion = suggestionEditText.getText().toString();
//        TextView suggestionText = new TextView(this);
//        suggestionText.setText(suggestion);
//        mLayout.addView(suggestionText);
//        createAttributeTag(suggestion, "")

    }



    public void openColorPicker(View view){ //TODO add button to layout
        mDefaultColor = ContextCompat.getColor(AddItem.this, R.color.colorPrimary );
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {

                mDefaultColor = color;
                TextView colorLabel = new TextView(AddItem.this);

                colorLabel.setBackgroundColor(color);
//                colorLabel.setX();

                mLayout.addView(colorLabel,5, 5 );





            }
        });
        colorPicker.show();
    }



}
