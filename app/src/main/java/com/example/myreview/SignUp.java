package com.example.myreview;

import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myreview.Interfaces.InterfaceForApplicationUserMapping;
import com.example.myreview.Interfaces.InterfaceForCreation;
import com.example.myreview.Rating.RatingMain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SignUp extends AppCompatActivity implements InterfaceForCreation, InterfaceForApplicationUserMapping {



    private Map<String, User> idUserMap;
    private Map<String, String> applicationUserIdsMap;
    private String newUserId;



//    private Map<String, Book> idUserMap;


    public SignUp(){
        idUserMap = new HashMap<>();
        applicationUserIdsMap  = new HashMap<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);




    }


    public void SignUpButtonClicked(View view){ //TODO add button to layout
//        Book user = new Book();

        EditText userName;
        EditText password;//TODO set id
        newUserId = generateNewId();
        idUserMap.put(newUserId, new User("","", R.drawable.ic_launcher_background, null, null, null, null, null, null)); //TODO getText
        mapApplicationToUserId();
        Intent goToRatingMain = new Intent(getApplicationContext(), RatingMain.class);
        startActivity(goToRatingMain);
    }



    @Override
    public String generateNewId() {
        String newUserId;
        newUserId = checkIdConflict();

        return newUserId;
    }


    @Override
    public String generateCurrentDate() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String currentDate = simpleDateFormat.format(new Date());
        return currentDate;
    }


    @Override
    public String createId(){
        Random ran = new Random();

        ArrayList<Character> alphabetsList = new ArrayList<>(), specialCharList = new ArrayList<>();
        Integer randomIndex;
        String idIntegers,idAlphabets = "",idSpecialChars ="";

        for(int i = 0; i < 26; i++){
            alphabetsList.add((char)(97 + i));

        }
        for(int i = 0; i <15; i++){
            specialCharList.add((char)(33 + i));
        }

        idIntegers = String.valueOf(ran.nextInt(9000) + 1000);
        for (int i = 0; i < 3; i++) {
            randomIndex = ran.nextInt(3);
            idAlphabets += alphabetsList.get(randomIndex).toString();
        }
        for (int i = 0; i < 3; i++) {
            randomIndex = ran.nextInt(3);
            idSpecialChars += specialCharList.get(randomIndex).toString();

        }
        String newId = idIntegers + idAlphabets + idSpecialChars;
        return newId;
    }

    @Override
    public String  checkIdConflict(){
        Random ran = new Random();
        String newId = createId();
        String newIdIntegers;
        while (idUserMap.keySet().contains(newId)) {
            newIdIntegers = String.valueOf(ran.nextInt(9000) + 1000);
            newId.replace(newId.substring(0,4), newIdIntegers);
        }

        return newId;


    }




    public void mapApplicationToUserId(){

        PackageManager packageManager = getPackageManager();
        String applicationId;
        try {
            applicationId = String.valueOf(packageManager.getApplicationInfo("com.example.app", PackageManager.GET_META_DATA));
            applicationUserIdsMap.put(newUserId, applicationId);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Map<String, User> getIdUserMap(){
        return idUserMap;
    }
}
