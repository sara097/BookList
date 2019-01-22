package com.example.user.klientksiegarni;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private ConnectionClass connectionClass;
    private ProgressBar pbar;
    private TextView waitText;
    private Button connBtn;
    private ArrayList<Book> books=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbar=(ProgressBar) findViewById(R.id.progBar);
        waitText = (TextView) findViewById(R.id.waitText);
        connBtn=(Button) findViewById(R.id.connectBtn) ;

        connectionClass = new ConnectionClass();
        pbar.setVisibility(View.INVISIBLE);
        waitText.setVisibility(View.INVISIBLE);

        connBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connBtn.setVisibility(View.INVISIBLE);
                DoLogin doLogin = new DoLogin();
                doLogin.execute("");

            }
        });
    }


    public class DoLogin extends AsyncTask<String,String,String>
    {
        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            pbar.setVisibility(View.VISIBLE);
            waitText.setVisibility(View.VISIBLE);
        }
        Intent i = new Intent(MainActivity.this, Test.class);
        @Override
        protected void onPostExecute(String r) {
            pbar.setVisibility(View.GONE);
            waitText.setVisibility(View.GONE);
            connBtn.setVisibility(View.GONE);

            Toast.makeText(MainActivity.this,r,Toast.LENGTH_SHORT).show();

            if(isSuccess) {
                String[] booksS=new String[books.size()];
                String[] booksInfo=new String[books.size()];
                for (int i=0; i<books.size(); i++){
                    booksS[i]=books.get(i).toString();
                    booksInfo[i]=books.get(i).info();
                    System.out.println("aaa"+booksS[i]);
                }
                i.putExtra("books", booksS);
                i.putExtra("booksInfo", booksInfo);


                startActivity(i);
                finish();
            }

        }

        @Override
        protected String doInBackground(String... params) {

            try {
                Connection con = connectionClass.CONN("klient", "");
                if (con == null) {
                    z = "Problem z połączeniem";
                } else {
                    z="Połączono";
                    isSuccess=true;
                    String query = "SELECT * FROM dbo.KSIAZKI_AUT_WYD";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    Book book;
                    if(rs.next())
                    {
                        while(rs.next()){
                            book = new Book(rs.getString("ISBN"), rs.getString("AUTORZY"), rs.getString("TYTUL"),
                                    String.format("%.2f", Double.valueOf(rs.getString("CENA"))), rs.getString("ilosc"), rs.getString("GATUNEK"),
                                    rs.getString("DLUGOSC"), rs.getString("WYDAWNOCTWO"), rs.getString("ROK_WYDANIA"));
                            System.out.println("halo"+rs.getString("TYTUL"));
                            books.add(book);
                        }
                    }
                    else
                    {
                        isSuccess = false;
                       z="Coś poszło nie tak!";
                    }
                }
            }
            catch (Exception ex)
            {
                isSuccess = false;
                z="Coś poszło nie tak!";
            }

            return z;
        }
    }
}
