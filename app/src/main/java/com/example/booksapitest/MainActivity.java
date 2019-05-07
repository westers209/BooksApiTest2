package com.example.booksapitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.booksapitest.Model.BookPojo;
import com.example.booksapitest.Model.Presenter;
import com.example.booksapitest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initNetwork(){
        Presenter presenter = new Presenter(this, "","","");
        presenter.initRetrofit();
        BookPojo bookPojo = presenter.sendBookResult();
        //Textview.setText(bookPojo.items[0].kind); or something like that. This specific one will crash.
        //nothing
    }
}
