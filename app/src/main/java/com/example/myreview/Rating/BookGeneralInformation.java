package com.example.myreview.Rating;

public class BookGeneralInformation {

    private String title, author,  type, genre,   ISBN, publisher, publicationDate;

    public BookGeneralInformation(String title, String author,  String type, String genre, String ISBN, String publisher, String publicationDate){
        this.title = title;
        this.author = author;
//        this.location = location;
        this.type = type;
        this.genre = genre;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public String getGenre() {
        return genre;
    }

    public String getISBN() {
        return ISBN;
    }
}
