package com.example.myreview.Rating;

import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myreview.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SellBook extends AppCompatActivity implements CheckBox.OnClickListener, Spinner.OnItemSelectedListener {

    private TextView sellPriceLabel, rentPriceLabel, locationText, featureLabel;
    private EditText titleEdit, authorEdit, genreEdit, ISBNEdit, publisherEdit,publicationDateEdit,  sellPriceEdit, rentPriceEdit, shippingCostEdit, itemDescriptionEdit, contentIntroductionEdit;
    private ImageView bookImageView;
    private CheckBox sellCheck, rentCheck;
    private boolean onSell, onRentOut;
    private ArrayList<Book> bookList;
    private ArrayList<String> contentFeatureList;
    private Spinner featureSpinner;
    private String feature;
    private float positionX, positionY;
    private Data source;
    private RelativeLayout layout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_book);

    }

    //TODO initializeViews


    public void initializeValues(){

        onSell = false;
        onRentOut = false;
        positionX = featureLabel.getX()+featureLabel.getWidth();
        positionY = featureLabel.getY();
        source = new Data();

    }


    public void setBookOnMarketButtonClicked(View view){

        BookGeneralInformation generalInformation = new BookGeneralInformation(titleEdit.getText().toString(), authorEdit.getText().toString(), genreEdit.getText().toString(), ISBNEdit.getText().toString(), publisherEdit.getText().toString(), publicationDateEdit.getText().toString());
        TransactionInformation priceInformation = new TransactionInformation(Double.parseDouble(sellPriceEdit.getText().toString()), Double.parseDouble(rentPriceEdit.getText().toString()), Double.parseDouble(shippingCostEdit.getText().toString()));
        BookDescription description = new BookDescription(itemDescriptionEdit.getText().toString(), contentIntroductionEdit.getText().toString(), contentFeatureList);
        Book book = new Book(generalInformation, priceInformation, description, onSell, onRentOut, createDate());
        bookList.add(book);

    }



    @Override
    public void onClick(View v) {
        if(v == sellCheck){
            onSell = !onSell;
            togglePriceViews(sellPriceLabel, sellPriceEdit, onSell);
        }
        if(v == rentCheck){
            onRentOut = !onRentOut;
            togglePriceViews(rentPriceLabel, rentPriceEdit, onRentOut);
        }
    }

    public void togglePriceViews(TextView priceLabel, EditText editText, Boolean state){
        int alphaValue;
        if(state){
            alphaValue = 1;
        }
        else{
            alphaValue = 0;
        }
        priceLabel.animate().alpha(alphaValue);
        editText.animate().alpha(alphaValue);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void addButtonClicked(View view){ //TODO add button to layout
        TextView featureTag = createFeatureTag(feature);
        contentFeatureList.add(featureTag.getText().toString());
        featureTag.setX(positionX);
        featureTag.setY(positionY);
        setNextTagPositions(featureTag);
        layout.addView(featureTag, 5, 5);


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public TextView createFeatureTag(String feature){
        TextView featureTag = new TextView(this);
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                source.getFunctionalityColors()); //pink, yellow
        //TODO change to data. ...
        gd.setCornerRadii(new float[] {2,2,2,2});
        featureTag.setBackground(gd);
        featureTag.setText(feature);
        return featureTag;
    }

    public void setNextTagPositions(TextView featureTag){
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
    public String createDate(){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        return date;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        feature = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
