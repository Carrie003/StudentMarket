package com.example.myreview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity  {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }


//   public void signUpButtonClicked(){
//
////        if(editTextIsFilled() && isMatch()){
////
////        }
//
//        else if(!editTextIsFilled()){
//
//            Toast.makeText(this, "you have to fill up both username and password to log in...", Toast.LENGTH_SHORT).show();
//       }
//
////        else if(isMatch(getInputPassword(), )){
////            Toast.makeText(this, "something wrong with your username ofr password...", Toast.LENGTH_SHORT).show();
////        }
//
//   }
//    @Override
//    public void mapApplicationToUserId() {
//
//        PackageManager packageManager = getPackageManager();
//        String applicationId;
//        try {
//            applicationId = String.valueOf(packageManager.getApplicationInfo("com.example.app", PackageManager.GET_META_DATA));
//            applicationUserIdsMap.put(newUserId, applicationId);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//    }

//    public String getInputUserName(){
//        TextView userName;
//        return userName.getText().toString();
//    }
//
//    public String getInputPassword(){
//        TextView password;//TODO set id
//        return password.getText().toString();
//    }



//    public boolean editTextIsFilled(){
//        if(getInputUserName() != null  && !getInputUserName().equals("")){
//
//            return true;
//        }
//        return false;
//    }

    public boolean isMatch(String inputText, String correctText){

        if(inputText.equals(correctText)){
            return true;
        }
        return false;
    }


}
