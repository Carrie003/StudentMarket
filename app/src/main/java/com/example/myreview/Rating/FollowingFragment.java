package com.example.myreview.Rating;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import com.example.myreview.R;
import com.example.myreview.User;

import java.util.ArrayList;
import java.util.List;


public class FollowingFragment extends Fragment {

    private Data source;
//    private List<Objs> list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Data source = new Data();
        View view = inflater.inflate(R.layout.list_view_fragment, container, false);
        ListView listView = view.findViewById(R.id.listView);

        ArrayList<User> userList = source.getFollowings().get(source.getUser());
        BookListViewAdapter adapter = new BookListViewAdapter(getContext(), userList);
        listView.setAdapter(adapter);

        return view;





    }

//    public void setArrayList(ArrayList<Objs> arrayList){
//        list = arrayList;
//    }
//
    public ArrayList<?> List(){

        ArrayList<?> arrayList = new ArrayList<>();
        User i = (User)arrayList.get(0);
//        arrayList.add(i);

    }
//    public ArrayList<Test> toggleBetweenLists(String viewType){
//
//        ArrayList<Test> list = new ArrayList<>();
//        User currentUser = source.getUser();
//        switch(viewType){
//
//            case "followings":
//                list = source.getUserFollowingsMap().get(currentUser);
//                break;
//            case "followers":
//                list = source.getUserFollowerMap().get(currentUser);
//                break;
//            case "market":
//                list = source.getUserMarketMap().get(currentUser);
//                break;
//            case "transaction":
//                list = source.getUserTransactionMap().get(currentUser);
//                break;
//
//        }
//
//        return list;
//    }

}




