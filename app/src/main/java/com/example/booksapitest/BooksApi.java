package com.example.booksapitest;

import com.example.booksapitest.Model.BookPojo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BooksApi {
    @GET("v1/volumes")
    //Call<List<BookPojo>> if it was a json array.
    Call<BookPojo> getBooks(@Query("q") String bookName,
                            @Query("maxResults") String max,
                            @Query("printType") String type);
}
