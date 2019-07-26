package com.example.myreview.Rating;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;



import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myreview.R;
import com.example.myreview.User;

import java.util.ArrayList;

public class FollowerFragment extends Fragment {


    /**
     * Created by User on 2/28/2017.
     */


//        private static final String TAG = "Tab1Fragment";
//
//        private Button btnTEST;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            Data source = new Data();
            View view = inflater.inflate(R.layout.list_view_fragment, container, false);
            ListView listView = view.findViewById(R.id.listView);

            ArrayList<User> followerList = source.getFollowers().get(source.getUser());
            BookListViewAdapter adapter = new BookListViewAdapter(getContext(), followerList);
            listView.setAdapter(adapter);

            return view;
        }
    }

