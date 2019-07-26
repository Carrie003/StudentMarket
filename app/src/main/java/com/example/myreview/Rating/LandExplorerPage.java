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

public class LandExplorerPage extends AppCompatActivity {

    private Data source;
    private BookListViewAdapter bookListViewAdapter; //TODO
    private ListView landExplorerListView;
    private EditText landExplorerEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_explorer_page);
    }

    public void setUpListView(){

        landExplorerListView = findViewById(R.id.bookShelfListView); //TODO
//        ArrayList<Book> bookList = new ArrayList<>();
        bookListViewAdapter = new BookListViewAdapter(this, source.getBookShelf());


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setUpSearchEdit(){

        landExplorerEdit = findViewById(R.id.bookShelfSearchEdit); //TODO
        Rect rect = new Rect(0, 0, 0,  0);
        RectF rectF = new RectF(rect);

        float[] radii = new float[]{7, 7, 7, 7, 7, 7, 7, 7};
        ShapeDrawable shape = new ShapeDrawable(new RoundRectShape(radii, rectF, radii));
        shape.getPaint().setColor(Color.parseColor("#85C1E9"));
        shape.getPaint().setStyle(Paint.Style.STROKE);
        shape.getPaint().setStrokeWidth(3);
        landExplorerEdit.setBackground(shape);


    }



    public void addOnTextChangeListener(){
        landExplorerEdit.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                bookListViewAdapter.filter(s); //TODO
            }
        });
    }
}
