package com.portfolio.vidisha.Graduation;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.portfolio.vidisha.R;

public class Contact extends AppCompatActivity {
    public static String FACEBOOK_URL = "https://www.facebook.com/YourPageName";
    public static String FACEBOOK_PAGE_ID = "YourPageName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        getSupportActionBar().setTitle("Contact me");//toolbar name
    }  public void onHome(View v){

        startActivity(new Intent(Contact.this,Home.class));
    }
    public void onSchool(View v){

        startActivity(new Intent(Contact.this,Graduation.class));
    }
    public void onHobby(View v){

        startActivity(new Intent(Contact.this,Hobby.class));
    }
    public void onContact(View v){

        startActivity(new Intent(Contact.this,Contact.class));
    }
    public void onCall(View v){

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9714522455"));
        startActivity(intent);
    }
    public void onSnapchat(View v){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.setPackage("com.snapchat.android");
        startActivity(Intent.createChooser(intent, "Open Snapchat"));
    }
    public void onFacebook(View v){

        String url = "https://www.facebook.com/vidisha.bardia";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));

        startActivity(i);
    }
    public void onInsta(View v){

        startActivity(new Intent(Contact.this,Home.class));
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}


