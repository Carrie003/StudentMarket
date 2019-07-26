package com.example.myreview.Rating;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myreview.R;
import com.example.myreview.User;

public class BookShelfPage extends AppCompatActivity {

    private Data source;
    private BookListViewAdapter bookListViewAdapter;
    private ListView bookShelfListView;
    private EditText bookSearchEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_shelf_page);
    }


    public void setUpListView(){

         bookShelfListView = findViewById(R.id.bookShelfListView);
//        ArrayList<Book> bookList = new ArrayList<>();

        bookListViewAdapter = new BookListViewAdapter(this, source.getBookShelf().get(source.getUser()));
        bookShelfListView.setAdapter(bookListViewAdapter);


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setUpSearchEdit(){

      bookSearchEdit = findViewById(R.id.bookShelfSearchEdit);
        Rect rect = new Rect(0, 0, 0, 0);
        RectF rectF = new RectF(rect);

        float[] radii = new float[]{7, 7, 7, 7, 7, 7, 7, 7};
        ShapeDrawable shape = new ShapeDrawable(new RoundRectShape(radii, rectF, radii));
        shape.getPaint().setColor(Color.parseColor("#F1948A")); //TODO change color
        shape.getPaint().setStyle(Paint.Style.STROKE);
        shape.getPaint().setStrokeWidth(3);
        bookSearchEdit.setBackground(shape);


    }

//    public void searchIconOnclick(View view){
//        bookListViewAdapter.filter(bookSearchEdit.getText().toString());
    public void addOnTextChangeListener(){
        bookSearchEdit.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                bookListViewAdapter.filter(s);
            }
        });
    }

//    }
        //    discussionListView = findViewById(R.id.discussionListView);
//
//    discussionSearchView = findViewById(R.id.discussionSearchView);
//
//
//    discussionListView =  findViewById(R.id.lessonListView);
//
//    adapter = new DiscussionListViewAdapter(this, cD.discussionList);
//
//        discussionListView.setAdapter(adapter);
//    discussionSearchView =  findViewById(R.id.lessonSearchView);
//        discussionSearchView.setOnQueryTextListener(this);




}
