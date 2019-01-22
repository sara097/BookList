package com.example.user.klientksiegarni;

import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import java.util.ArrayList;

public class Info extends Activity {

    //ArrayList<Book>book;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        text=(TextView) findViewById(R.id.textView);

        String book=  getIntent().getStringExtra("book");
        int pos=getIntent().getIntExtra("pos",0);

        text.setText(book);

    }

}
