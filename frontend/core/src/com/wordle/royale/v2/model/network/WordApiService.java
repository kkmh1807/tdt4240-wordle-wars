package com.wordle.royale.v2.model.network;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.HttpRequestBuilder;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.wordle.royale.v2.model.letter;
import com.wordle.royale.v2.model.guessedWord;

public class WordApiService {
    private final String BASE_URL = "http://10.0.2.2:3000";

    public interface CallbackNewWord<T> {
        void onSuccess(T result);

        void onFailure(Throwable t);
    }

    public void getNewWord(final CallbackNewWord<Integer> callback) {
        String endpoint = "/word";

        String url = BASE_URL + endpoint;
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
                callback.onSuccess(wordID);
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

    public interface CallbackGuessWord<T, U> {
        void onSuccess(T validWord, U guessedWord);

        void onFailure(Throwable t);
    }

    public void guessWord(String guess, Integer wordID, final CallbackGuessWord<Boolean, guessedWord> callback) {
        String endpoint = "/word/guess";

        String url = BASE_URL + endpoint;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.newRequest();
        httpRequestBuilder.method(Net.HttpMethods.POST);
        httpRequestBuilder.url(url);
        httpRequestBuilder.header("Content-Type", "application/json");
        httpRequestBuilder.content("{\"wordIndex\": " + wordID + ",\"guess\": \"" + guess + "\"}");
        Net.HttpResponseListener listener = new Net.HttpResponseListener() {
            @Override
            public void handleHttpResponse(Net.HttpResponse response) {
                JsonReader jsonReader = new JsonReader();
                System.out.println("Sending..");
                JsonValue json = jsonReader.parse(response.getResultAsString());
                Boolean validWord = json.getBoolean("validWord");

                guessedWord guessedWord = new guessedWord();
                Boolean correct = true;
                JsonValue lettersArray = json.get("letters");
                if (lettersArray != null) {
                    for (int i = 0; i < 5; i++) {
                        if(lettersArray.get(i).getInt("placement")  == 0){
                            correct = false;
                        }
                        letter letter = new letter(
                                lettersArray.get(i).getString("letter"),
                                lettersArray.get(i).getInt("status"),
                                lettersArray.get(i).getInt("placement"));
                        guessedWord.insertLetter(letter);
                    }
                }
                guessedWord.setCorrect(correct);
                System.out.println(validWord);
                callback.onSuccess(validWord, guessedWord);
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
