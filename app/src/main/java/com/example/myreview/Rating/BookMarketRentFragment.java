package com.example.myreview.Rating;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myreview.R;

import java.util.ArrayList;

public class BookMarketRentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Data source = new Data();
        View view = inflater.inflate(R.layout.list_view_fragment, container, false);
        ListView listView = view.findViewById(R.id.listView);

        ArrayList<Book> bookList = source.getBookForSale().get(source.getUser());
        BookListViewAdapter adapter = new BookListViewAdapter(getContext(), bookList);
        listView.setAdapter(adapter);

        return view;

    }
}

