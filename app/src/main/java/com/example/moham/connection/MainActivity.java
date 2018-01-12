package com.example.moham.connection;

import android.net.Uri;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Bidi;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    String res=null;
    Toast toast=null;
    int index=0;
    EditText editText;
    Button button;
    Bidi bidi;

    String x;
    String y;
    String z;
    String j;
    String c="hey";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String x ="hey sucker come her and get me 2 ";
        Scanner y=new Scanner(x);
        editText=(EditText)findViewById(R.id.ed);
        button=(Button)findViewById(R.id.bt);
        y.useDelimiter("h");
        while (y.hasNext())
            Log.e("scaner",y.next());
        final String [] strings=new String[]{"mohamed","i","love ","ur","fkn code"};
        toast=new Toast(this);
        LayoutInflater inflater=getLayoutInflater();
        View view =inflater.inflate(R.layout.activity_main,null,false);
        final TextView textView=(TextView)view.findViewById(R.id.tv_show);
        toast.setView(view);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bidi=new Bidi(editText.getText().toString(),Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);
                Log.e("text", bidi.isLeftToRight()+" "+editText.getText().toString());

                    getString(R.string.myfknkey);
            }
        });
        View constraintLayout= findViewById(R.id.view__v);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });



      }


    public  String runThred ()
    {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    res=getResponse( urlBuilder("https://www.google.com.eg/"));
                    Log.d("response",res);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        return res;
    }



    public URL urlBuilder (String uri)
    {
            Uri builder=Uri.parse(uri);
            Uri uriBuilder=builder.buildUpon().build();
            URL url=null;
        try {
             url=new URL(uriBuilder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        return url;
    }



    public String getResponse (URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        Scanner scaner = null;
        try {
            InputStream in = connection.getInputStream();
            scaner = new Scanner(in);
            scaner.useDelimiter("");
            boolean hasnext = scaner.hasNext();
            if (hasnext) return scaner.next();

            else return null;
        }finally
        {
            connection.disconnect();
            scaner.close();

        }
    }


}
