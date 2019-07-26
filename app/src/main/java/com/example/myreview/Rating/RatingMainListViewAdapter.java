package com.example.myreview.Rating;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myreview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingMainListViewAdapter extends BaseAdapter {


    private Context mContext;
    private LayoutInflater inflater;
    private List<Item> itemList;
    private ArrayList<Item> allItemlist, list;
//    private Map<Integer, Discussion> idDiscussionMap;
    public static Integer selectedTopicId;
    public static String selectedUserId;





    public RatingMainListViewAdapter(Context context, List<Item> itemList) {
        mContext = context;

        this.itemList = itemList;

        inflater = LayoutInflater.from(mContext);
        this.allItemlist = new ArrayList<>();

        this.allItemlist.addAll(itemList);


        notifyDataSetChanged();


    }

    public class ViewHolder {


        TextView itemName;
        TextView totalPrice;
        TextView brand;
        TextView location;
        ImageView ratingstars;
//        TextView
        TextView appearance;
        TextView functionality;


        TextView shopImages;
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
        return itemList.size();
    }

    @Override
    public Item getItem(int position) {
        return   itemList.get(position);
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


//            view = inflater.inflate(R.layout.activity_discussion_list_view_item_holder, null);




            String itemName = "name: "+itemList.get(position).getName();

            Integer totalPriceInt = itemList.get(position).getPrice()+itemList.get(position).getShippingCost();
            String totalPrice = "total price: " + totalPriceInt + "(item price = "+ itemList.get(position).getPrice().toString()+ "shipping cost = " +itemList.get(position).getShippingCost().toString() + ")";
            String brand  = "brand: "+itemList.get(position).getBrand();

            String location  = "location: "+itemList.get(position).getLocation();
//            ImageView ratingStars

//            String appearance = "appearance: "+itemList.get(position).getAppearance();
//            String functionality = "functionality: "+itemList.get(position).getFunctionality();


            holder.itemName.setText(itemName);
            holder.totalPrice.setText(totalPrice);
            holder.brand.setText(brand);
            holder.location.setText(location);
//            holder.appearance.setText(appearance);
//            holder.functionality.setText(functionality);






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

            view.setTag(holder);

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



//    public void filter(String charText, String attribute) {
//        charText = charText.toLowerCase(Locale.getDefault());
//        itemList.clear();
//        if (charText.length() == 0) {
//            itemList.addAll(allItemlist);
//        } else if(attribute.equals("color")){
//            filterByColor();
//            for (Item item: allItemlist) {
//                if (item.getTopic().toLowerCase(Locale.getDefault()).contains(charText)) {
//                    itemList.add(item);
//                }
//            }
//            notifyDataSetChanged();
//        }

//
//    }



    public int getColorValue(int color){
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);
        int alpha = Color.alpha(color);
        int colorValue = red+ green+ blue+ alpha;
        return colorValue;
    }

//    public void filterAll(){
//        if(){
//
//        }
//    }

    public void filterWhenEmpty(){
        itemList.clear();
        itemList = allItemlist;
        list.clear();
        list = allItemlist;
        notifyDataSetChanged();
    }

    public void filterByColor(int searchedColorValue){
            int differenceLowBound = 0;
            int differenceHighBound = 1;
            while(differenceHighBound<=50){


                for(Item item: list){
//                    ArrayList<Integer> colorList = new ArrayList<>();//TODO change to rmlist
//                    colorList.add()

                    for(int itemColor: item.getColorList()){
                        int itemColorValue = getColorValue(itemColor);
//                int realColor = 500; //TODO change 500 to the color from listview
                        if(differenceLowBound <=itemColorValue - searchedColorValue && itemColorValue - searchedColorValue <= differenceHighBound){
                            itemList.add(item);
                            list.remove(item);
                            notifyDataSetChanged();

                        }
                    }
                }
                differenceLowBound ++;
                differenceHighBound++;
            }
    }

    public void filterByBrand(String brand){
        for(Item item: list){

            if(brand.equals(item.getBrand())){

                itemList.add(item);
                list.remove(item);
                notifyDataSetChanged();
            }
        }
    }


    public void filterAll(String attribute, String searchedValue){



        int index = 0;
        for (Item item : list) {

            String listValue;
            switch(attribute){

                case "brand":

                    listValue = item.getBrand();
                case "location":
                    listValue = item.getLocation();
//                case "appearance":
//                    listValue = item.getAppearanceList().get();

//                case "functionality":
//                    listValue = item.getFunctionality();

                case "price":
                    listValue = item.getPrice().toString();

                case "shop":
                    listValue = item.getShop();

                default:
                    listValue= "";

            }

            index++;

            if (listValue.contains(searchedValue)) {

                itemList.add(item);
                list.remove(item);
                notifyDataSetChanged();
            }

        }
    }

    public void filterWithList(String search, ArrayList<String> attributeList){
        for (Item item : list) {

//            for(item.){
            if (attributeList.contains(search)) {

                itemList.add(item);
                list.remove(item);
                notifyDataSetChanged();
            }
        }
    }

    public void filterByItemName(String itemName) {
        for (Item item : list) {

            if (itemName.contains(item.getBrand())) {

                itemList.add(item);
                list.remove(item);
                notifyDataSetChanged();
           }
        }
    }
//    public void filterByPriceRange(String priceRrange) {
//        for (Item item : list) {
//
//            if (priceRrange.contains(item.getPriceList())) {
//
//                itemList.add(item);
//                list.remove(item);
//                notifyDataSetChanged();
//            }
//        }
//    }

//    public

//    public void filterByPriceRange(){
//        for(Item ){
//
//        }
//    }



//    public void filterBy

//    public void filterByShop(String shop){
//        for (Item item : list) {
//
////            for(item.){
//                if (item.getShopList().contains(shop)) {
//
//                    itemList.add(item);
//                    list.remove(item);
//                    notifyDataSetChanged();
//                    }
//                }
//            }
//     public void filterByAppearance(String appearance){
//         for (Item item : list) {
//
////            for(item.){
//             if (item.getShopList().contains(appearance)) {
//
//                 itemList.add(item);
//                 list.remove(item);
//                 notifyDataSetChanged();
//             }
//         }
//     }
//     public void filterByFunctionality(String functionality){
//         for (Item item : list) {
//
////            for(item.){
//             if (item.getShopList().contains(functionality)) {
//
//                 itemList.add(item);
//                 list.remove(item);
//                 notifyDataSetChanged();
//             }
//
//         }
//     }
//
//    public void filterByLocation(String functionality){
//        for (Item item : list) {
//
////            for(item.){
//            if (item.getLocation().contains(functionality)) {
//
//                itemList.add(item);
//                list.remove(item);
//                notifyDataSetChanged();
//            }
//        }
//    }

//    public void sort(String sortType){
//        sortItem(itemList, sortType);
////        switch (sortType){
////            case "priceFromLowToHigh":
////
////               sortFromLowToHigh(itemList);
////        }
//    }

//    public ArrayList<Integer> sort(ArrayList<Integer> originalList, String sortType){
//
    //        ArrayList<Integer> originalList = new ArrayList<>();
//        for(Item item: itemList){
//            originalList.add(value);
//
//        }

//        for(int v: originalList){
//            Math.max();
//        }
//        ArrayList<Integer> sortedList = new ArrayList<>();
//        int max = originalList.get(0);
//        int addition = 1;
//        if(sortType.equals("fromHighToLow")){
//            for(int i = 0; i+addition<originalList.size(); i++){
//                max = Math.max(max, originalList.get(i+addition));
//                sortedList.add(max);
//
//                addition++;
//            }
//        }
//        else {
//            for(int i = 0; i+addition<originalList.size(); i++){
//                max = Math.min(max, originalList.get(i+addition));
//                sortedList.add(max);
//                addition++;
//            }
//        }
//
//                min = Math.min(min, originalList.get(i+addition).getPrice());
//            sortedList.add();

//           for(int j = i+1; j<originalList.size(); j++ ){
//              max =  Math.max(max,j);
//           }
//        return sortedList;
//
//
//    }

    public void sort(String sortType){
        Map<Item, Double> itemValueMap = new HashMap<>();
        for(Item item: itemList){
            double value = switchCases(item, sortType);
            itemValueMap.put(item, value);
        }
        ArrayList<Item> sortedList = new ArrayList<>();
        int addition = 1;
        int minItemIndex= 0;
        int maxItemIndex = 0;
        for(int i = 0; i+addition<itemValueMap.size(); i++){

            if(sortType.equals("priceFromHighToLow")){
                if(itemValueMap.get(itemList.get(i))> itemValueMap.get(itemList.get(i+addition))){
                    minItemIndex = i;
                }
                else{
                    minItemIndex = i+addition;
                }
                sortedList.add(itemList.get(minItemIndex));
                addition++;
            }
          else{
                if(itemValueMap.get(itemList.get())< itemValueMap.get(itemList.get(i+addition))){
                    maxItemIndex = i;
                }
                else{
                    maxItemIndex = i+addition;
                }

                sortedList.add(itemList.get(maxItemIndex));

                addition++;
            }
        }
        itemList = sortedList;
//        return sortedList;
    }

    public double switchCases(Item item, String sortType){

        double value;
//        String rankType;
        switch(sortType) {
            case "priceFromHighToLow":
                value = item.getPrice();
            case "priceFromLowToHigh":
                value = item.getPrice();
//            case "location":
////                int locationDifference;
////                locationDifference =
////                value = item.getLocation();
            case "rating":
                value = item.getAverageRating();
            case "soldOutNumber":
                value = item.getSoldOutNumber().doubleValue();

                default:
                    value = 0.0;

        }

//        return new sw(value, rankType)


        return value;
    }
//    public ArrayList<Integer> sortFromHighToLow(ArrayList<Integer> originalList){
//
//        ArrayList<Integer> sortedList = new ArrayList<>();
//        int max = originalList.get(0);
//        int addition = 1;
//
//        for(int i = 0; i+addition<originalList.size(); i++){
//            max = Math.max(max, originalList.get(i+addition));
//            sortedList.add(max);
//
//            addition++;
//        }
//
//        return sortedList;
//
//
//    }
}







