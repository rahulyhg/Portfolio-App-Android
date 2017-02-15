package com.portfolio.vidisha.Graduation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.portfolio.vidisha.R;

public class Hobby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);
        getSupportActionBar().setTitle("Skills");//toolbar name
    }  public void onHome(View v){

        startActivity(new Intent(Hobby.this,Home.class));
    }
    public void onSchool(View v){

        startActivity(new Intent(Hobby.this,Graduation.class));
    }
    public void onHobby(View v){

        startActivity(new Intent(Hobby.this,Hobby.class));
    }
    public void onContact(View v){

        startActivity(new Intent(Hobby.this,Contact.class));
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}




