package com.example.myreview.Rating;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myreview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RentOutApartment extends AppCompatActivity implements Spinner.OnItemSelectedListener, RadioGroup.OnClickListener{

    private TextView roomLabel, surroundingLabel, appearanceLabel, functionalityLabel, roomTag, surroundingTag, appearanceTag, functionalityTag;
    private EditText priceEdit, rentEdit,  sizeEdit, floorNumEdit, peopleNumEdit, descriptionEdit, countryEdit, stateorProvinceEdit, countyEdit, cityEdit, streetEdit, postalCodeEdit, nameEdit,phoneEdit, emailEdit, alternatePhoneEdit, alternateEmailEdit;
    private Spinner roomSpinner, roomNumSpinner, surroundingNumSpinner, surroundingSpinner, apperanceSpinner, functionalitySpinner;
    private RadioGroup hasGarageRadio, typeRadio;
    private Data source;
    private String room, surrounding, appearance, functionality, type, country, stateOrProvince, county, city, street, postalCode, phone, email ;
    private Boolean hasGarage;
    private float rPositionX, rPositionY, sPositionX, sPositionY, aPositionX, aPositionY, fPositionX, fPositionY;
    private Integer roomNum, surroundingNum, floorNum ;
    private Map<String, Integer> roomMap, surroundingMap;
    private Map<String, String> locationMap, contactMap;
    private boolean onSell, onRentOut;
    private ArrayList<String> appearanceList, functionalityList;
    private RelativeLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_out_department);

    }

    //TODO initializeViews, setOnItemSelected

    public void initializeValues(){
        source = new Data();
        roomMap = new HashMap<>();
        surroundingMap = new HashMap<>();
        locationMap = new HashMap<>();
        contactMap = new HashMap<>();
        appearanceList = new ArrayList<>();
        functionalityList = new ArrayList<>();
        rPositionX = 0;
        rPositionY = 0;
        sPositionX = 0;
        sPositionY = 0;
        aPositionX = 0;
        aPositionY = 0;
        fPositionX = 0;
        fPositionY = 0;
    }



    public void setOnMarketButtonClicked(){

//        try{
//            if(allFilled())
//
//
//        }
//        catch (Exception e){
//
//        }
    }







    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void addRoomButtonClicked(View view){

        int[] colors = source.getFeatureColorMap().get("appearance");
        addFeatures(room + roomNum.toString(), colors, rPositionX, rPositionY);

        roomMap.put(room, roomNum);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void addSurroundingButtonClicked(View view){

        int[] colors = source.getFeatureColorMap().get("surrounding");
        addFeatures(surrounding+surroundingNum.toString(), colors, sPositionX, sPositionY);
        surroundingMap.put(surrounding, surroundingNum);
    }



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void addAppearanceButtonClicked(View view){

        int[] colors = source.getFeatureColorMap().get("appearance");
        addFeatures(appearance, colors, aPositionX, aPositionY);
        appearanceList.add(functionality);
    }



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void addFunctionalityButtonClicked(View view){
        int[] colors = source.getFeatureColorMap().get("functionality");
        addFeatures(functionality, colors, fPositionX, fPositionY);
        functionalityList.add(functionality);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void addFeatures(String text, int[] colors, float positionX, float positionY)
    {
        TextView featureTag = createTag(text, colors);
//        content.add(featureTag.getText().toString());
        featureTag.setX(positionX);
        featureTag.setY(positionY);
        setNextTagPositions(featureTag, positionX, positionY);
        layout.addView(featureTag, 5, 5);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public TextView createTag(String text, int[] colorArray){
        TextView featureTag = new TextView(this);
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                source.getFunctionalityColors()); //pink, yellow
        //TODO change to data. ...
        gd.setCornerRadii(new float[] {2,2,2,2});
        featureTag.setBackground(gd);
        featureTag.setText(text);
        return featureTag;
    }


    public void setNextTagPositions(TextView featureTag, float positionX, float positionY){
        float width = featureTag.getWidth();
        positionX += width;
        if(positionX+width>= getScreenWidth()-5){
            positionY += 5;
            positionX = 5;
        }
    }

    public Integer getScreenWidth(){
        Display display = getWindowManager(). getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        return width;
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



        if(parent == roomSpinner){
            room = parent.getItemAtPosition(position).toString();
        }
        else if(parent == roomNumSpinner){
            roomNum = Integer.parseInt(parent.getItemAtPosition(position).toString());
        }
        else if(parent == surroundingSpinner){
            surrounding = parent.getItemAtPosition(position).toString();
        }
        else if(parent == surroundingNumSpinner){
            surroundingNum = Integer.parseInt(parent.getItemAtPosition(position).toString());
        }
        else if(parent == apperanceSpinner){
            appearance = parent.getItemAtPosition(position).toString();

        }
        else if(parent == functionalitySpinner){
            functionality = parent.getItemAtPosition(position).toString();
        }
        else{
            floorNum = Integer.parseInt(parent.getItemAtPosition(position).toString());
        }


    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onClick(View v) {
        if(v == hasGarageRadio){
            int id = hasGarageRadio.getCheckedRadioButtonId();
//        View hasGarageRadio = hasGarageRadio.findViewById(id);
//        if (id == R.id.amountcollected_yes_radioButton) {
            boolean hasGarage = true;

//
//
//        } else if (id == R.id.amountcollected_no_radioButton) {
//
//
            boolean hasGarade = false;
//        }
        }
        else if(v == typeRadio){
            int id = typeRadio.getCheckedRadioButtonId();
            type = "house";
            type = "apartment";
        }

//
    }
//
//    public Boolean getHasGarage() {
//
//        return hasGarage;
//    }

    public boolean allFilled(){

        for(int i = 0; i<layout.getChildCount(); i++){

            View view = layout.getChildAt(i);
            if(view instanceof EditText && !editTextIsFilled((EditText)view)){
                    view.setBackgroundColor(Color.parseColor("#EC7063"));
                    return false;

            }
            else if(view instanceof RadioGroup  && !radioButtonIsFilled((RadioGroup)view)){

                view.setBackgroundColor(Color.parseColor("#EC7063"));
                return false;
            }
        }
        return true;

    }

    public boolean editTextIsFilled(EditText editText){
        if(editText.getText()!= null && editText.getText().toString().length()>0) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean radioButtonIsFilled(RadioGroup radioGroup){
//        if(radioGroup.getCheckedRadioButtonId()==  ){
//
//            return true;
//        }
        return false;
    }

    public void setLocationButtonClicked(){
        togglePinImage();
        Intent pinLocationIntent = new Intent(getApplicationContext(), PinLocationActivity.class);
        startActivity(pinLocationIntent);

    }

    public void togglePinImage(){
        source.setPinApartmentImage(true);
        source.setPinItemImage(false);
        source.setPinBookImage(false);
    }
    public Map<String, String> getLocationInformation(){

        locationMap.put("country", countryEdit.getText().toString());
        locationMap.put("state/province", stateorProvinceEdit.getText().toString());
        locationMap.put("county", countyEdit.getText().toString());
        locationMap.put("city", cityEdit.getText().toString());
        locationMap.put("street", streetEdit.getText().toString());
        locationMap.put("postal code", postalCodeEdit.getText().toString());
        String fullLocation = countryEdit.getText().toString()+ stateorProvinceEdit.getText().toString()+countyEdit.getText().toString()+cityEdit.getText().toString()+streetEdit.getText().toString()+postalCodeEdit.getText().toString();
        locationMap.put("full location", fullLocation);

        return locationMap;

    }



    public Map<String, String> getContactInformation(){

        contactMap.put("name", nameEdit.getText().toString());
        contactMap.put("phone", phoneEdit.getText().toString());
        contactMap.put("email", emailEdit.getText().toString());
        contactMap.put("alternative phone", alternatePhoneEdit.getText().toString());
        contactMap.put("alternative email", alternateEmailEdit.getText().toString());
    }

    public void setLocationInformation(){

        countryEdit.setText();
        stateorProvinceEdit.setText();
        countyEdit.setText();
        cityEdit.setText();
        streetEdit.setText();
        postalCodeEdit.setText();

    }

    public void clearAll(){

    }
}
