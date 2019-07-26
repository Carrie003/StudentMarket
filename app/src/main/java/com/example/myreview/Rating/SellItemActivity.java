package com.example.myreview.Rating;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myreview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import yuku.ambilwarna.AmbilWarnaDialog;

public class SellItemActivity extends AppCompatActivity implements  Spinner.OnItemSelectedListener{

    private EditText itemNameEdit, priceEdit, brandEdit, shipingCostEdit;
    private TextView priceLabel, brandLabel, featureLabel, locationText, colorTag;
    private SearchView featureSearch;
    private ImageView itemImageView;
    private Spinner shopSpinner, featureSpinner ;
    private ArrayList<String> appearanceList, functionalityList, shopList;
    private Map<String, Integer> shopIconMap;
    private int i, mDefaultColor;
    private float positionX, positionY;
    private String shop, feature;
    private final int REQUEST_IMAGE_CODE = 1;
//    private Color mDefaultColor;
    private LinearLayout linearLayout; //TODO set id in onCreate
    private Data source;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_item);
//        shopIconMap = new HashMap<>();
        i = 1;

        positionX = featureLabel.getX();

    }


    public void setUpBasicViews(){

    }

    public void setUpShopSpinner(){
//        shopSpinner = findViewById(R.id.shopSpinner);

        ArrayAdapter<CharSequence> shopSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.shop_spinner, android.R.layout.simple_spinner_item);
        shopSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        shopSpinner.setAdapter(shopSpinnerAdapter);
//        i = 1;
        shopSpinner.setOnItemSelectedListener(this);


    }

    public void setUpFeatureSpinner(){
//        shopSpinner = findViewById(R.id.shopSpinner);

        ArrayAdapter<CharSequence> shopSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.shop_spinner, android.R.layout.simple_spinner_item);
        shopSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        featureSpinner.setAdapter(shopSpinnerAdapter);
//        i = 1
        featureSpinner.setOnItemSelectedListener(this);


    }


    public void setUpLists(){
        appearanceList = new ArrayList<>();
        functionalityList = new ArrayList<>();
        shopList = new ArrayList<>();
        shopIconMap = new HashMap<>();
        shopIconMap.put("Amazon", R.drawable.amazonicon);
        shopIconMap.put("CVS", R.drawable.cvsicon);
        shopIconMap.put("Etsy", R.drawable.etsyicon);
        shopIconMap.put("Target", R.drawable.targeticon);
        shopIconMap.put("Walmart", R.drawable.walmarticon);
        shopIconMap.put("Costco", R.drawable.costcoicon);
        shopIconMap.put("WholeFoods", R.drawable.wholefoodsicon);
        shopIconMap.put("Handmade", R.drawable.handmadeicon);
        shopIconMap.put("Other Big Market", 0);
        shopIconMap.put("A Small Store", 0);
    }



    public void setItemOnSellButtonClicked(View view){ //TODO add button to layout
        String itemName = itemNameEdit.getText().toString();
        String price = priceEdit.getText().toString();
        String shippingCost = shipingCostEdit.getText().toString();
        String location  = locationText.getText().toString();
        String brand = brandEdit.getText().toString();

//        Item item = new Item(itemName, price, shippingCost, location,  brand,shop, appearanceList, functionalityList,  );
        clear();
    }




//
//    public void uploButtonClicked(View view){
//
//    }

    public void uploadPhotoButtonClicked(View view){

        Intent uploadPhotoIntent = new Intent();
        uploadPhotoIntent.setType("Image/*");
        uploadPhotoIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(uploadPhotoIntent, 1);

    }

//    public void recordClass(View view){
//
//    }


    public void takePictureButtonClicked(View view){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CODE && resultCode == RESULT_OK  && data!=null){
            try{
                Uri itemImageUri;
                itemImageUri = data.getData();
                itemImageView.setImageURI(itemImageUri);

//                String pattern = "yyyy-MM-dd";
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//                String currentDate = simpleDateFormat.format(new Date());
//                Lesson newLesson = new Lesson(tutorialVideoUri, "", "", 0,0, currentDate, new ArrayList<Comment>());
//                lessons.add(newLesson);
//                IDlessonMap.put(createNewID(),newLesson);

                Toast.makeText(SellItemActivity.this, "Video uploaded successfully", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){

                Toast.makeText(SellItemActivity.this, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(SellItemActivity.this, "You have to select exactly one video to upload", Toast.LENGTH_SHORT).show();
        }
    }


    public void chooseColorButtonClicked(View view){

        mDefaultColor = ContextCompat.getColor(SellItemActivity.this, R.color.colorPrimary );
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {

                mDefaultColor = color;
//                createColorTag(color);
//                linearLayout.addView(createColorTag(color), 5, 5);



            }

        });
    }

    public void addColorTag(int color){

        colorTag.setBackgroundColor(color);
        linearLayout.addView(colorTag, 5, 5);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        i--;
        if(i<0) {
            if (parent == shopSpinner) {
                shop = parent.getItemAtPosition(position).toString();
                Toast.makeText(this,   shop + " selected", Toast.LENGTH_SHORT).show();
                addShopTag(shop);

            }
            else if(parent == featureSpinner){
                feature = parent.getItemAtPosition(position).toString();
                Toast.makeText(this,  feature + " selected", Toast.LENGTH_SHORT).show();

            }

//            } else {
//
//                difficulty = Integer.parseInt(parent.getItemAtPosition(position).toString());
//                Toast.makeText(this, "Difficulty " + difficulty + " selected", Toast.LENGTH_SHORT).show();
//            }


        }

    }

    public void addShopTag(String shop){

        ImageView shopTag = new ImageView(this); //TODO change new image view to get id from layout
        shopTag.setImageResource(shopIconMap.get(shop));

//        TextView text = new TextView(this);
//        text.addView

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void addFeatureTag(String feature){
//        int startColor = Color.parseColor("#FDFEFE"), endColor = Color.parseColor("#FDFEFE");
        TextView featureTag = new TextView(this);
        featureTag.setText(feature);

        featureTag.setX(positionX);
        featureTag.setY(positionY);


//        GradientDrawable gd = new GradientDrawable(
//                GradientDrawable.Orientation.TOP_BOTTOM,
//                new int[] {Color.parseColor("#FADBD8"), Color.parseColor("#FEF9E7")});
//        gd.setCornerRadii(new float[] {2,2,2,2});

//        Map<String, int[]> appearanceColorMap = source.getAppearanceColorMap();
//        ArrayList<String> allAppearanceList = source.getAllAppearanceList();

        if(source.getAllAppearanceList().contains(feature)){
            appearanceList.add(feature);
//            color = Color.parseColor("#FADBD8");//soft-pink
//            GradientDrawable gd = new GradientDrawable(
//                    GradientDrawable.Orientation.TOP_BOTTOM,
//                    new int[] {Color.parseColor("#FADBD8"), Color.parseColor("#FEF9E7")});
//            gd.setCornerRadii(new float[] {2,2,2,2});
            GradientDrawable gd = new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                   source.getFunctionalityColors()); //pink, yellow
            //TODO change to data. ...
            gd.setCornerRadii(new float[] {2,2,2,2});
            featureTag.setBackground(gd);

        }
        else{
            functionalityList.add(feature);
            GradientDrawable gd = new GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    source.getFunctionalityColors()); //mint, blue
            gd.setCornerRadii(new float[] {2,2,2,2});
//            startColor = Color.parseColor("#D5F5E3"); //mint-green
            featureTag.setBackground(gd);
        }


        positionX+=featureTag.getWidth()+5;
//        Point p = new Point();
//        getWindowManager().getDefaultDisplay().getSize(p);

        if(positionX + featureTag.getWidth() >= 200){ //TODO change 200 to the screenX - some value
            positionY +=featureTag.getHeight()+5;
            positionX = 5;

        }


    }

    public void clear(){
//        itemNameEdit.getText().clear();
//        priceEdit.getText().clear();
//        brandEdit.getText().clear();
//        shipingCostEdit.getText().clear();
        for(int i =0; i<linearLayout.getChildCount(); i++){
            View view = linearLayout.getChildAt(i);
            if(view instanceof EditText ){
                ((EditText) view).getText().clear();
            }
            else if(view instanceof TextView && view != featureLabel && view!= locationText){
                linearLayout.removeView(view);
            }

        }
    }
//    public void clearAllAddedViews(){
//
//
//
//    }
//    public void
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
