package com.example.user.klientksiegarni;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.klientksiegarni.Book;

import java.util.ArrayList;
import java.util.Arrays;

public class Test extends ListActivity {


    ArrayList<Book> book;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // storing string resources into Array
            String[] numbers = {"one","two","three","four"};
            String [] books = getIntent().getStringArrayExtra("books");
            final String [] booksInfo=getIntent().getStringArrayExtra("booksInfo");
            System.out.println("boooooks"+Arrays.toString(books));
           // book= (ArrayList<Book>) getIntent().getParcelableArrayExtra("book");

            // here you store the array of string you got from the database

            // Binding Array to ListAdapter
            this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, books));
            // refer the ArrayAdapter Document in developer.android.com
            ListView lv = getListView();

            // listening to single list item on click
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {


                   // i.putParcelableArrayListExtra("book", (ArrayList<? extends Parcelable>) book);

                    Intent i = new Intent(Test.this, Info.class);
                    i.putExtra("book", booksInfo[position]);
                    startActivity(i);

                }
            });
        }
    }

