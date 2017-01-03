package com.dsi.httpclient;

import com.squareup.okhttp.*;

import java.io.IOException;

/**
 * Created by sabbir on 8/12/16.
 */
public class HttpClient {

    private static final String ERROR_MESSAGE = "{\"errorMessage\":\"Error occurs in httpclient\"}";

    public String sendPost(String url, String bodyObject, String headerKey, String headerValue) {
        final MediaType JSON =
                MediaType.parse("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, bodyObject);
        Request request = new Request.Builder()
                .url(url)
                .header(headerKey, headerValue)
                .post(body)
                .build();

        return getResponse(client, request);
    }

    public String sendPut(String url, String bodyObject, String headerKey, String headerValue) {
        final MediaType JSON =
                MediaType.parse("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, bodyObject);
        Request request = new Request.Builder()
                .url(url)
                .header(headerKey, headerValue)
                .put(body)
                .build();

        return getResponse(client, request);
    }

    public String sendDelete(String url, String bodyObject, String headerKey, String headerValue) {
        final MediaType JSON =
                MediaType.parse("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, bodyObject);
        Request request = new Request.Builder()
                .url(url)
                .header(headerKey, headerValue)
                .delete(body)
                .build();

        return getResponse(client, request);
    }

    public String getRequest(String url, String headerKey, String headerValue) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader(headerKey, headerValue)
                .build();

        return getResponse(client, request);
    }

    private String getResponse(OkHttpClient client, Request request) {
        Response response;
        try {
            response = client.newCall(request).execute();
            return response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
            return ERROR_MESSAGE;
        }
    }
}
