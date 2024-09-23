package com.beemdevelopment.aegis.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.MediaType;

public class HttpGetString {

    public static String getStringFromUrlPost(String url, String formdata, String mediatype) {
        MediaType mt = MediaType.get(mediatype);

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(formdata, mt);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            }
        } catch (Exception e) {
            // fail simply
        }
        return null;
    }

}