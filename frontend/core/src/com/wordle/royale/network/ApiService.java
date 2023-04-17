package com.wordle.royale.network;

import java.net.URI;
import java.net.URISyntaxException;

import sun.net.www.http.HttpClient;


public class ApiService {

    private URI wordleURI;

    public ApiService() throws URISyntaxException {
        this.wordleURI = new URI("http://10.212.25.104:8080/word");
    }
}
