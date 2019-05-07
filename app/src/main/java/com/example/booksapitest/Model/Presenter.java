package com.example.booksapitest.Model;

import android.content.Context;

import com.example.booksapitest.BooksApi;
import com.example.booksapitest.Model.BookPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Presenter {
    Context context;
    String bookName, type, baseUrl;
    final String CONTS_RESULTS = "5";
    BookPojo bookResult;

    public Presenter(Context context, String bookName, String type, String baseUrl){
        this.context = context;
        this.bookName = bookName;
        this.type = type;
        this.baseUrl = baseUrl;
    }

    //todo initialize retrofit
    //todo send data to views

    public void initRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BooksApi booksApi = retrofit.create(BooksApi.class);

        booksApi.getBooks(bookName,CONTS_RESULTS,type).enqueue(new Callback<BookPojo>() {
            @Override
            public void onResponse(Call<BookPojo> call, Response<BookPojo> response) {
                //todo send data to the view
                if(response.isSuccessful() && response.body() != null){
                    bookResult = response.body();
                }
            }

            @Override
            public void onFailure(Call<BookPojo> call, Throwable t) {
                //todo handle error cases
                bookResult = new BookPojo();
            }
        });
    }

    public BookPojo sendBookResult(){
        return bookResult;
    }
}

//Pick a layout
//
