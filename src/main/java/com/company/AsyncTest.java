package com.company;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class AsyncTest {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request getGoogleHtml = new Request.Builder()
                .url("https://google.com")
                .build();

        client.newCall(getGoogleHtml).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String res = response.body().string();
                System.out.println(res);
            }
        });
    }
}
