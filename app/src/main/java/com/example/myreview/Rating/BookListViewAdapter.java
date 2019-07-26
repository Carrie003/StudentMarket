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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class BookListViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Book> bookList, arrayList;
    private Map<String, Integer> titleImageMap, map;
    private boolean heartFilled;
    private Data source;
    private Book book;
    private Objs objs;

    private  ViewHolder holder;
//    private com.example.myreview.User user;
    private String fullLocation;



    public BookListViewAdapter(Context context,ArrayList<Book> bookList)

    {
        this.context = context;
        this.bookList = bookList;
        this.arrayList = bookList;
        heartFilled = false;




//        notifyDataSetChanged();




    }


    public class

    public class ViewHolder {

        ImageView bookImage;
        ImageView star1Image, star2Image, star3Image, star4Image, star5Image, avatar, heartImage, bookShelfImage, rightArrowImage;
        TextView titleText, authorText,priceText, locationText, typeText, genreText;




//        ImageView titleIcon;
//        TextView title;
//        ImageView rightArrow;


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

            book = bookList.get(position);
            setStarImage(book.getRating().getRating()); // TODO set to real rating

            holder.titleText.setText(book.getGeneralInformation().getTitle());
            holder.authorText.setText(book.getGeneralInformation().getAuthor());

            holder.priceText.setText(getFullPrice(book));
            holder.locationText.setText(getFullLocation(book));

            holder.rightArrowImage.setImageResource(R.drawable.rightarrow);

            holder.avatar.setImageURI(book);

            holder.typeText.setText(book.getGeneralInformation().getType());
            holder.genreText.setText(book.getGeneralInformation().getGenre());

//            holder.ISBNText.setText(book.getGeneralInformation().getISBN());



        } else {
            holder = (ViewHolder) view.getTag();

        }


        holder.heartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                heartFilled = !heartFilled;
                ArrayList<Book> bookWishList = source.getUserWishMap().get(source.getUser()).getBookList();
                if(!bookWishList.contains(book)){
                    holder.heartImage.setImageResource(R.drawable.heart_filled);

                    book.getRating().setLike(book.getRating().getLike()+1);
                    bookWishList.add(book);
                    Toast.makeText(context, "Book added to your wish list successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    holder.heartImage.setImageResource(R.drawable.empty_heart);
                    Toast.makeText(context, "Book removed from your wish list", Toast.LENGTH_SHORT).show();
                }



            }
        });


        holder.bookShelfImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                boolean existOnBookShelf = false;
//                ArrayList<Objs> objList = source.getBookShelf().get(source.getUser());
//                for(Objs obj: objList){
//                    if(obj.getBook().equals(book)){
//                        Toast.makeText(context, "You already added this book to your book shelf", Toast.LENGTH_SHORT).show();
//                        existOnBookShelf = true;
//                    }
//                }
//                if(!existOnBookShelf){
//                    Objs newObjs = new Objs(null, null, book, null);
//                    source.getBookShelf().get(source.getUser()).add(newObjs);
//                    Toast.makeText(context, "Book successfully added to your book shelf", Toast.LENGTH_SHORT).show();
//
//                }


                   if(source.getBookShelf().get(source.getUser()).contains(book)){
                       Toast.makeText(context, "You already added this book to your book shelf", Toast.LENGTH_SHORT).show();
                   }
                   else{
                       source.getBookShelf().get(source.getUser()).add(book);
                       Toast.makeText(context, "Book successfully added to your book shelf", Toast.LENGTH_SHORT).show();

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
//                Book book = source.getUser();
//                source.getUserNameWishMap().get(book).getBookList().add(b);
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
        bookList.clear();
        if (charText.length() == 0) {
            bookList.addAll(arrayList);
        } else {
            for (Book book : bookList) {
                String title = book.getGeneralInformation().getTitle();
                String author = book.getGeneralInformation().getAuthor();
                String ISBN  = book.getGeneralInformation().getISBN();
                String fullLocation = getFullLocation(book);
//                String fullPrice = getFullPrice(book);



                if (title.contains(charText)|| author.contains(charText)|| ISBN.contains(charText)|| fullLocation.contains(charText))) {
                    bookList.add(book);
                }



            }
//            for (VocabCheck vocabQuiz : arraylist) {
//                if (vocabQuiz.getDescription().toLowerCase(Locale.getDefault()).contains(charText)) {
//                    bookList.add(vocabQuiz);
//                }
//            }

        }
        notifyDataSetChanged();
    }

    public void sort(ArrayList<Book> bookList, Comparator<Book> comparator) {
        Collections.sort(bookList, comparator);
    }


    public String getFullLocation(Book book){
        String fullLocation = book.getLocation().getStreet()+","+ book.getLocation().getCity()+","+ book.getLocation().getCountry()+","+ book.getLocation().getCounty()+","+ book.getLocation().getCountry()+","+ book.getLocation().getPostalCode();
        return fullLocation;
    }

    public String getFullPrice(Book book) {
        double sellPrice, rentPrice, shippingCost;
        sellPrice = book.getTransactionInformation().getSellPrice();
        rentPrice = book.getTransactionInformation().getRentPrice();
        shippingCost = book.getTransactionInformation().getShippingCost();
        String fullPrice;
        if (book.getTransactionInformation().isOnSell()) {
            fullPrice = String.valueOf(sellPrice + shippingCost) + "  fullPrice:" + String.valueOf(sellPrice) + "+shipping cost:" + String.valueOf(shippingCost);

        } else {
            fullPrice = String.valueOf(sellPrice + shippingCost) + "  price:" + String.valueOf(rentPrice) + "+shipping cost:" + String.valueOf(shippingCost);

        }

        return fullPrice;
    }


}
