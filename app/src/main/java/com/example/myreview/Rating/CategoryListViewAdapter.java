package com.example.myreview.Rating;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CategoryListViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater inflater;
    //    public static List<Discussion> discussionList;
//    private ArrayList<Discussion> arraylist;
    private Map<String, ArrayList<String>> categoryMap, map;
    private int size;
    private ArrayList<Integer> removableSizesList;
    private ArrayList<String> categoryValueList;
    private String category;
    private Map<Integer, Map<String, String>> positionAttributeMap;
    private Map<Integer, String> positionCategoryMap;
    private Map<Integer, String> positionValueMap;
//    private Map<Integer, String>

//    private Map<Integer, Discussion> idDiscussionMap;
//    public static Integer selectedTopicId;
//    public static String selectedUserId;


    public CategoryListViewAdapter(Context context, Map<String, ArrayList<String>> categoryMap) {
        mContext = context;

//        this.discussionList = discussionList;
        this.categoryMap = categoryMap;

        inflater = LayoutInflater.from(mContext);

//        for(HashMap.Entry entry: categoryMap.entrySet()){
//            map.put(entry.getKey().toString(), entry.getValue().toString());
//        }

        map = categoryMap;
        removableSizesList = new ArrayList<>();
        size = 0;
        categoryValueList = categoryMap.values().iterator().next();
//        positionAttributeMap  =new HashMap<>();
        positionCategoryMap = new HashMap<>();
        positionValueMap = new HashMap<>();
//        this.arraylist = new ArrayList<>();
//
//        this.arraylist.addAll(discussionList);


        notifyDataSetChanged();


    }

    public class ViewHolder {


        TextView category;
        TextView colon;
        TextView value;


//
//        TextView idLabel;
//        TextView id;
//
//
//        TextView topicLabel;
//        EditText topic;
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
//
//        Button viewDiscussionButton;


    }

    @Override
    public int getCount() {

        int count = 0;
        for(String category: categoryMap.keySet()){
            for(int i =0; i <categoryMap.get(category).size(); i++){
                count++;
            }
        }
        return count;
//        int totalSize = 0;
//       for(Integer size: getSizesList()) {
//           totalSize+=size;
//       }

//       return totalSize;
    }

//    public ArrayList<Integer> getSizesList() {
//
//        ArrayList<Integer> sizesList = new ArrayList<>();
//        for(String category: categoryMap.keySet()){
//            int size = 0;
//            for(int i =0; i <categoryMap.get(category).size(); i++){
//                size++;
//            }
//            sizesList.add(size);
//        }
//
//        return  sizesList;
//
//
//    }
    @Override
    public String getItem(int position) {
//        Log.i(positionAttributeMap.get(position).);
//        return categoryMap.keySet().iterator().next() + categoryMap.values().iterator().next();
        return null;

    }


    public Map<String, ArrayList<String>> getCategoryMap() {
        return categoryMap;
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

//            if(size == getCount()){
//                size = 0;
//
//            }
//            else{



//                for(String category: categoryMap.keySet()){
//                    int index = 0;
//                    holder.category.setText(category);
//                    for(int i =0; i <categoryMap.get(category).size(); i++){
////                        String categoryText = categoryMap.get()


//                for(int i =0; i<getSizesList().size(); i++) {
//                    for() {
//                    }
//                    holder.value
//                }


//                int sizesListIndex = 0;
//                int index;



//                removableSizesList = getSizesList();

             holder.colon.setText(":            ");
                if(categoryValueList.iterator().hasNext()) {

                    holder.category.setText(category);
                    holder.value.setText(categoryValueList.iterator().next());



//                    Map<String, String> cMap = new HashMap<>();
//                    cMap.put(category, holder.value.getText().toString());
//                    positionAttributeMap.put(position, cMap);
                    positionCategoryMap.put(position, category);
                    positionValueMap.put(position, holder.value.getText().toString());

//                    int originalValue = removableSizesList.get(sizesListIndex);
//                    int reducedValue  = removableSizesList.get(sizesListIndex)-1;
//                    removableSizesList.set(originalValue, reducedValue);

                }
                else if(categoryMap.values().iterator().hasNext()) {
                    categoryValueList = categoryMap.values().iterator().next();
                    category = categoryMap.keySet().iterator().next();
//                        sizesListIndex++;
                }



//                }

//                        holder.value.setText(categoryMap.values().iterator().next().iterator().next());
//                        index++;
//
//                    }
//                }
//
//
//
//                        holder.category.setText(categoryMap.keySet().iterator().next());
//                holder.value.setText(categoryMap.get(category).);
//                size++;



//            }

//
//            view = inflater.inflate(R.layout.activity_discussion_list_view_item_holder, null);
//
//
//
//            holder.idLabel = view.findViewById(R.id.idLabel);
//            holder.id = view.findViewById(R.id.id);
//            holder.topicLabel = view.findViewById(R.id.topicLabel);
//            holder.topic = view.findViewById(R.id.topic);
//            holder.contentLabel = view.findViewById(R.id.commentLabel);
//            holder.content = view.findViewById(R.id.newComment);
//
//            holder.thumbUpImage = view.findViewById(R.id.thumbUpImage);
//            holder.thumbUpValue = view.findViewById(R.id.thumbUpValue);
//            holder.thumbDownImage = view.findViewById(R.id.thumbDownImage);
//
//
//            holder.thumbDownValue = view.findViewById(R.id.thumbDownValue);
//            holder.dateLabel = view.findViewById(R.id.dateLabel);
//            holder.date = view.findViewById(R.id.date);
//            holder.viewDiscussionButton = view.findViewById(R.id.viewDiscussionButton);
//
//
//            Integer id = idDiscussionMap.keySet().iterator().next();
//
//
//            holder.id.setText(id);
//            holder.topic.setText(idDiscussionMap.get(id).getTopic());
//            holder.content.setText(idDiscussionMap.get(id).getContent());
//            holder.thumbUpImage.setImageResource(R.drawable.thumbsup);
//            holder.thumbDownImage.setImageResource(R.drawable.thumbsdown);
//            holder.thumbUpValue.setText(idDiscussionMap.get(id).getThumbUp());
//            holder.thumbDownValue.setText(idDiscussionMap.get(id).getThumbDown());
//
//            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();

        }


//        holder.thumbUpImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Integer originalValue = Integer.valueOf(holder.thumbUpValue.getText().toString());
//
//                Integer newValue = ++originalValue;
//                holder.thumbUpValue.setText(newValue);
//
//                idDiscussionMap.get(holder.id).setThumbUp(newValue);
//
//
//            }
//        });
//
//        holder.thumbDownImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Integer originalValue = Integer.valueOf(holder.thumbDownValue.getText().toString());
//
//                Integer newValue = ++originalValue;
//                holder.thumbDownValue.setText(newValue);
//
//                idDiscussionMap.get(holder.id).setThumbDown(newValue);
//
//
//            }
//        });
//
//
//        holder.viewDiscussionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                selectedTopicId = Integer.parseInt(holder.id.getText().toString());
//                Map<String, ArrayList<Integer>> userDiscussionIdsMap  = CreateDiscussion.userDiscussionIdsMap;
//                for(String userId: userDiscussionIdsMap.keySet()){
//                    if(userDiscussionIdsMap.get(userId).contains(selectedTopicId)){
//                        selectedUserId  = userId;
//
//
//                    }
//                }
//                Intent viewDiscussionIntent = new Intent(mContext.getApplicationContext(), ViewDiscussion.class);
//                mContext.startActivity(viewDiscussionIntent);
//
//
//            }
//        });


        return view;
    }

    public void filterAll(String charText) { //TODO improve method add  else if
        charText = charText.toLowerCase(Locale.getDefault());
        categoryMap.clear();
        if (charText.length() == 0) {
            categoryMap = map;
        } else {
            for (String category : map.keySet()) {
//                try {

                if (category.equals(charText)) {

                    categoryMap.put(category, map.get(category));
//                    }
//                }
//                catch (Exception e){
//                    Log.i("error", e.toString());
                }

                ArrayList<String> valueList= new ArrayList<>();
                for(int index = 0; index < map.get(category).size(); index++){

                    String value = map.get(category).get(index);
                    if(value.contains(charText)){

                        valueList.add(value);
                        categoryMap.put(category, valueList);

                    }

                }

                valueList.clear();



                }


//            for(){
//
//            }


            notifyDataSetChanged();
            }


        }




        public void updateCategoryMap(Map<String, ArrayList<String>> newMap ){

        categoryMap = newMap;
        notifyDataSetChanged();
        }

    public Map<Integer, Map<String, String>> getPositionAttributeMap() {

        return positionAttributeMap;
    }


            public Map<Integer,String> getPositionCategoryMap(){

          return positionCategoryMap;
        }
//
    public Map<Integer, String> getPositionValueMap() {
        return positionValueMap;
    }



    //        public boolean containsText(String category, String charText, ){
//
//        for(String c){
//            if(category.contains(charText)){
//                return true;
//            }
//
//        }
//        return false;
//
//        }
//

    }

