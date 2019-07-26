package com.example.myreview.Rating;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myreview.R;

import java.util.ArrayList;
import java.util.Map;

public class UserPageListViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;
    private Map<String, Integer> titleImageMap, map;




    public UserPageListViewAdapter(Context context, Map<String, Integer> titleImageMap)

    {
        mContext = context;

        this.titleImageMap = titleImageMap;
        inflater = LayoutInflater.from(mContext);
//        arraylist = new ArrayList<>();
        map = titleImageMap;

//        notifyDataSetChanged();




    }

    public class ViewHolder {

        ImageView titleIcon;
        TextView title;
        ImageView rightArrow;


//        ImageView avatar;
//
//
//
//
//        TextView user;
//
//        TextView idLabel;
//        TextView id;
//
//
//
//
//
//
//
//        TextView contentLabel;
//        EditText content;
//
//        ImageView thumbUpImage;
//        TextView thumbUpValue;
//        ImageView thumbDownImage;
//        TextView thumbDownValue;
//
//        TextView dateLabel;
//        TextView date;

//        Button viewDiscussionButton;

//
//        Button addButton;
//        Button submitButton;




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
        final ViewHolder holder;



        if (view == null) {
            holder = new ViewHolder();

            view = inflater.inflate(R.layout.activity_user_page_list_view_item_holder, null);
            holder.titleIcon = view.findViewById(R.id.titleIcon);
            holder.title = view.findViewById(R.id.title);
            holder.rightArrow = view.findViewById(R.id.rightArrow);

            if(titleImageMap.keySet().iterator().hasNext()) {
                String title = titleImageMap.keySet().iterator().next();
                int imageResource = titleImageMap.get(title);
                holder.titleIcon.setImageResource(imageResource);
                holder.title.setText(title);
                holder.rightArrow.setImageResource(R.drawable.rightarrow);

            }
//            view = inflater.inflate(R.layout.activity_discussion_list_view_item_holder, null);
//
//            holder.avatar = view.findViewById(R.id.avatar);
//
//            holder.user = view.findViewBy(R.id.user);
//
//            holder.idLabel = view.findViewById(R.id.idLabel);
//            holder.id = view.findViewById(R.id.id);
//            holder.contentLabel =  view.findViewById(R.id.commentLabel);
//            holder.content = view.findViewById(R.id.newComment);
//
//            holder.thumbUpImage =  view.findViewById(R.id.thumbUpImage);
//            holder.thumbUpValue = view.findViewById(R.id.thumbUpValue);
//            holder.thumbDownImage = view.findViewById(R.id.thumbDownImage);
//
//
//            holder.thumbDownValue = view.findViewById(R.id.thumbDownValue);
//            holder.dateLabel = view.findViewById(R.id.dateLabel);
//            holder.date = view.findViewById(R.id.date);

        } else {
            holder = (ViewHolder) view.getTag();

        }


        return view;
    }
}
