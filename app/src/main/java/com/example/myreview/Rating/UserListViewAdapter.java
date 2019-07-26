package com.example.myreview.Rating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myreview.R;
import com.example.myreview.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class UserListViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<User> userList, arrayList;
    private Map<String, Integer> titleImageMap, map;
//    private boolean heartFilled;
    private Data source;
    private User user;

    private ViewHolder holder;



    public UserListViewAdapter(Context context, ArrayList<User> userList)

    {
        this.context = context;
        this.userList = userList;
        this.arrayList = userList;


    }
    public class ViewHolder {

//        ImageView avatar;
        ImageView  avatarImage, followImage, likeImage, dislikeImage, rightArrowImage;
        TextView nameText,  emailText, phoneText, followText, likeText, dislikeText;


    }


    @Override
    public int getCount() {
        return titleImageMap.size();
    }

    @Override
    public Item getItem(int position) {
        return null;
    }



    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View view, ViewGroup parent) {





        if (view == null) {
            holder = new ViewHolder();


            view = inflater.inflate(R.layout.activity_user_page_list_view_item_holder, null);

            User user = userList.get(position);
            holder.avatarImage.setImageURI(user.getGeneralInformation().getAvatar());
            holder.followImage.setImageResource(R.drawable.follow);
            holder.likeImage.setImageResource(R.drawable.likeclicked);
            holder.dislikeImage.setImageResource(R.drawable.dislikeclicked);
            holder.rightArrowImage.setImageResource(R.drawable.rightarrow);

            holder.nameText.setText(user.getGeneralInformation().getName());
            holder.phoneText.setText(user.getMoreInformation().getPhone());
            holder.emailText.setText(user.getMoreInformation().getEmail());


        } else {
            holder = (ViewHolder) view.getTag();

        }




        return view;
    }


    public void filter(CharSequence charText){
        userList.clear();
        if (charText.length() == 0) {
            userList.addAll(arrayList);
        } else {
            for (User user : userList) {
                String name =  user.getGeneralInformation().getName();
                String phone = user.getMoreInformation().getPhone();
                String email  = user.getMoreInformation().getEmail();
                if (name.contains(charText)|| phone.contains(charText)||email.contains(charText)) {
                    userList.add(user);
                }

            }
        }
        notifyDataSetChanged();
    }



}
