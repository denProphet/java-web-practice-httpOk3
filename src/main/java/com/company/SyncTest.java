package com.company;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class SyncTest {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://google.com")
                .build();

        try(Response response = client.newCall(request).execute()){
            String textHtmlFromGoogle = response.body().string();
            System.out.println(textHtmlFromGoogle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
