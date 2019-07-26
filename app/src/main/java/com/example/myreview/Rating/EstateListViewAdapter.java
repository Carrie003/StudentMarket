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

public class EstateListViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Apartment> estateList, arrayList;
    private Map<String, Integer> titleImageMap, map;
    private boolean heartFilled;
    private Data source;
    private Apartment estate;
    private Objs objs;
    private User currentUser;

    private ViewHolder holder;
    //    private com.example.myreview.User user;
    private String fullLocation;



    public EstateListViewAdapter(Context context,ArrayList<Apartment> estateList)

    {
        this.context = context;
        this.estateList = estateList;
        this.arrayList = estateList;
        heartFilled = false;
        currentUser = source.getUser();


    }


//    public class

    public class ViewHolder {

        ImageView bookImage;
        ImageView star1Image, star2Image, star3Image, star4Image, star5Image, avatar, heartImage, landExplorerImage, rightArrowImage;
        TextView priceText, locationText, sizeText, peopleNumText, transactionTypeText;

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

            estate = estateList.get(position);
            setStarImage(estate.getRating().getRating()); // TODO set to real rating

            holder.priceText.setText(getFullPrice(estate));
            holder.locationText.setText(getFullLocation(estate));

            holder.rightArrowImage.setImageResource(R.drawable.rightarrow);

            holder.avatar.setImageURI(currentUser.getGeneralInformation().getAvatar());

//            holder.typeText.setText(estate.getGeneralInformation().getType());
//            holder.genreText.setText(estate.getGeneralInformation().getGenre());

//            holder.ISBNText.setText(estate.getGeneralInformation().getISBN());



        } else {
            holder = (ViewHolder) view.getTag();

        }


//        holder.heartImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                heartFilled = !heartFilled;
//                ArrayList<Apartment> bookWishList = source.getUserWishMap().get(source.getUser()).getBookList();
//                if(!bookWishList.contains(estate)){
//                    holder.heartImage.setImageResource(R.drawable.heart_filled);
//
//                    estate.getRating().setLike(estate.getRating().getLike()+1);
//                    bookWishList.add(estate);
//                    Toast.makeText(context, "Book added to your wish list successfully", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    holder.heartImage.setImageResource(R.drawable.empty_heart);
//                    Toast.makeText(context, "Book removed from your wish list", Toast.LENGTH_SHORT).show();
//                }
//
//
//
//            }
//        });


        holder.landExplorerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(source.getLandExplorer().get(currentUser).contains(estate)){
                    Toast.makeText(context, "You already added this estate to your estate shelf", Toast.LENGTH_SHORT).show();
                }
                else{
                    source.getLandExplorer().get(currentUser).add(estate);
                    Toast.makeText(context, "Book successfully added to your estate shelf", Toast.LENGTH_SHORT).show();

                }

            }
        });



        return view;
    }

//    @Override
//    public void onClick(View v) {
//        if(v == holder.heartImage){
//            heartFilled = !heartFilled;
//            if(heartFilled){
//                holder.heartImage.setImageResource(R.drawable.heart_filled);
//                //TODO add to wishList
//                Book estate = source.getUser();
//                source.getUserNameWishMap().get(estate).getBookList().add(b);
//
//            }
//            else{
//                holder.heartImage.setImageResource(R.drawable.empty_heart);
//            }
//        }
//    }


    public void setStarImage(double num){

        int filledStarNum = (int)Math.round(num);
        ArrayList<ImageView> imageViewsList = new ArrayList<>();
        imageViewsList.add(holder.star1Image);
        imageViewsList.add(holder.star2Image);
        imageViewsList.add(holder.star3Image);
        imageViewsList.add(holder.star4Image);
        imageViewsList.add(holder.star5Image);

        for(int i = 0; i<filledStarNum; i++ ){
            imageViewsList.get(i).setImageResource(R.drawable.star_filled);
        }

    }


    public void filter(CharSequence charText){
//        charText = charText.toLowerCase(Locale.getDefault());
        estateList.clear();
        if (charText.length() == 0) {
            estateList.addAll(arrayList);
        } else {
            for (Apartment book : estateList) {
//                String title = book.getGeneralInformation().getTitle();
//                String author = book.getGeneralInformation().getAuthor();
//                String ISBN  = book.getGeneralInformation().getISBN();
                String fullLocation = getFullLocation(book);
//                String fullPrice = getFullPrice(estate);


                if(fullLocation.contains(charText)){
                    estateList.add(estate);

//                if (title.contains(charText)|| author.contains(charText)|| ISBN.contains(charText)|| fullLocation.contains(charText))) {
//                    estateList.add(book);
                }



            }
//            for (VocabCheck vocabQuiz : arraylist) {
//                if (vocabQuiz.getDescription().toLowerCase(Locale.getDefault()).contains(charText)) {
//                    estateList.add(vocabQuiz);
//                }
//            }

        }
        notifyDataSetChanged();
    }

    public void sort(ArrayList<Book> bookList, Comparator<Book> comparator) {
        Collections.sort(bookList, comparator);
    }


    public String getFullLocation(Apartment estate){
        String fullLocation = estate.getLocation().getStreet()+","+ estate.getLocation().getCity()+","+ estate.getLocation().getCountry()+","+ estate.getLocation().getCounty()+","+ estate.getLocation().getCountry()+","+ estate.getLocation().getPostalCode();
        return fullLocation;
    }

    public String getFullPrice(Apartment estate) {
        double sellPrice, rentPrice;
        sellPrice = estate.getTransactionInformation().getSellPrice();
        rentPrice = estate.getTransactionInformation().getRentPrice();
        String fullPrice;
        if (estate.getTransactionInformation().isOnSell()) {
            fullPrice = String.valueOf(sellPrice) + "  fullPrice:" + String.valueOf(sellPrice);

        } else {
            fullPrice = String.valueOf(sellPrice) + "  price:" + String.valueOf(rentPrice);

        }

        return fullPrice;
    }

}
