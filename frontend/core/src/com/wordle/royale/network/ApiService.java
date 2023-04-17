package com.wordle.royale.network;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.utils.JsonReader;

public class ApiService {
    public Integer result = 0;
    public int sendHttpRequest() {
        String url = "http://10.212.25.104:8080/word";
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.newRequest();
        httpRequestBuilder.method(Net.HttpMethods.GET);
        httpRequestBuilder.url(url);
        Net.HttpResponseListener listener = new Net.HttpResponseListener() {
            @Override
            public void handleHttpResponse(Net.HttpResponse response) {
                JsonReader jsonReader = new JsonReader();
                System.out.println("Sending..");
                int wordID = jsonReader.parse(response.getResultAsString()).getInt("word");
                System.out.println(wordID);
                result = wordID;
            }

            @Override
            public void failed(Throwable t) {
                System.out.println("An error occurred");
                System.out.println(t);
            }

            @Override
            public void cancelled() {
                System.out.println("An error occurred");
            }
        };
        Gdx.net.sendHttpRequest(httpRequestBuilder.build(), listener);
        return result;
    }
}
