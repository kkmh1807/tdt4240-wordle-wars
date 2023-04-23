package com.wordle.royale.v2.model.network;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.wordle.royale.v2.model.highscores;

public class ScoreApiService {
    private final String BASE_URL = "http://10.212.25.104:8080";

    public interface CallbackPostScore<T> {
        void onSuccess(T highscores);

        void onFailure(Throwable t);
    }

    public void submitScore(String username, Integer score, final CallbackPostScore<highscores> callback) {
        String endpoint = "/highscore/add";
        System.out.println("Username: "+ username);
        System.out.println("Score: "+ score);

        String url = BASE_URL + endpoint;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.newRequest();
        httpRequestBuilder.method(Net.HttpMethods.POST);
        httpRequestBuilder.url(url);
        httpRequestBuilder.header("Content-Type", "application/json");
        httpRequestBuilder.content("{\"score\": " + score + ",\"username\": \"" + username + "\"}");
        Net.HttpResponseListener listener = new Net.HttpResponseListener() {
            @Override
            public void handleHttpResponse(Net.HttpResponse response) {
                JsonReader jsonReader = new JsonReader();
                System.out.println("Sending..");
                JsonValue json = jsonReader.parse(response.getResultAsString());

                highscores highscores = new highscores();
                Integer i = 0;
                while (json.get(i) != null) {
                    highscores.addHighscore(
                            json.get(i).getString("username"),
                            json.get(i).getInt("score"));
                    i++;
                }
                callback.onSuccess(highscores);
            }

            @Override
            public void failed(Throwable t) {
                System.out.println("An error occurred");
                System.out.println(t);
                callback.onFailure(t);
            }

            @Override
            public void cancelled() {
                System.out.println("An error occurred");
            }
        };
        Gdx.net.sendHttpRequest(httpRequestBuilder.build(), listener);
    }
}
