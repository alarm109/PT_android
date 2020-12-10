package com.example.pt_android_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.pt_android_app.Constants.apiAddress;

public class RESTControl {

    public static String get(String endpoint) throws IOException {
        URL url = new URL(apiAddress + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        int resCode = connection.getResponseCode();
        System.out.println("Response code received: " + resCode);
        if (resCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }
        return "";
    }

    public static boolean delete(String endpoint, int id) throws IOException {
        URL url = new URL(apiAddress + endpoint + "?id=" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        int resCode = connection.getResponseCode();
        System.out.println("Response code received: " + resCode);
        return resCode == HttpURLConnection.HTTP_OK;
    }
}
