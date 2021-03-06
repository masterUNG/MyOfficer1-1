package com.sutthinant.myofficer;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by Nantha on 17/4/2560.
 */

public class AddUserToServer extends AsyncTask<Void, Void, String>{
    //Explicit
    private Context context;
    private static final String urlPHP = "http://swiftcodingthai.com/off/add_user.php";
    private String nameString, userString, passwordString, ImageString;

    public AddUserToServer(Context context,
                           String nameString,
                           String userString,
                           String passwordString,
                           String imageString) {
        this.context = context;
        this.nameString = nameString;
        this.userString = userString;
        this.passwordString = passwordString;
        ImageString = imageString;
    }

    @Override
    protected String doInBackground(Void... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Name", nameString)
                    .add("User", userString)
                    .add("Password", passwordString)
                    .add("Image", ImageString)
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
} //Main Class
