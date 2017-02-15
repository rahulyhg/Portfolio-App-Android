package com.portfolio.vidisha.Graduation;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.portfolio.vidisha.R;

public class Contact extends AppCompatActivity {
    public static String FACEBOOK_URL = "https://www.facebook.com/YourPageName";
    public static String FACEBOOK_PAGE_ID = "YourPageName";
    private int STORAGE_PERMISSION_CODE = 23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        getSupportActionBar().setTitle("About me");//toolbar name
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
    public void onCall(View v) {

        if (isReadStorageAllowed()) {
            //If permission is already having then showing the toast
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9714522455"));
            startActivity(intent);
            //Existing the method with return
            return;
        }

        //If the app has not the permission then asking for the permission
        requestStoragePermission();


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

        Uri uri = Uri.parse("http://instagram.com/vidisha93");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    private boolean isReadStorageAllowed() {
        //Getting the permission status
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        //If permission is granted returning true
        if (result == PackageManager.PERMISSION_GRANTED)
            return true;

        //If permission is not granted returning false
        return false;
    }

    //Requesting permission
    private void requestStoragePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},STORAGE_PERMISSION_CODE);
    }

    //This method will be called when the user will tap on allow or deny
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if (requestCode == STORAGE_PERMISSION_CODE) {

            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                //Displaying a toast
               // Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }

    }}


