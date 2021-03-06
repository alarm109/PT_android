package com.example.pt_android_app;

import com.example.pt_android_app.objects.Category;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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

    public static boolean createCategory(String endpoint, String name, String description) throws IOException, JSONException {
        URL url = new URL(apiAddress + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "application/json; charset=UTF-8");

        JSONObject cat = new JSONObject();
        cat.put("name", name);
        cat.put("description", description);
        cat.put("fms_id", 1);

        OutputStreamWriter wr= new OutputStreamWriter(connection.getOutputStream());
        wr.write(cat.toString());

        wr.flush();
        wr.close();
        connection.connect();

        int resCode = connection.getResponseCode();
        System.out.println("Response code received: " + resCode);
        if (resCode == HttpURLConnection.HTTP_OK) {
            String result;
            BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            int result2 = bis.read();
            while (result2 != -1) {
                buf.write((byte) result2);
                result2 = bis.read();
            }
            result = buf.toString();
            System.out.println(result);
        }

        return resCode == HttpURLConnection.HTTP_OK;
    }

    public static boolean updateCategory(String endpoint, String id, String name, String description) throws IOException, JSONException {
        URL url = new URL(apiAddress + endpoint + "?id=" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("Content-type", "application/json; charset=UTF-8");

        JSONObject cat = new JSONObject();
        cat.put("name", name);
        cat.put("description", description);
        cat.put("fms_id", 1);

        OutputStreamWriter wr= new OutputStreamWriter(connection.getOutputStream());
        wr.write(cat.toString());

        wr.flush();
        wr.close();
        connection.connect();

        int resCode = connection.getResponseCode();
        System.out.println("Response code received: " + resCode);
        if (resCode == HttpURLConnection.HTTP_OK) {
            String result;
            BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            int result2 = bis.read();
            while (result2 != -1) {
                buf.write((byte) result2);
                result2 = bis.read();
            }
            result = buf.toString();
            System.out.println(result);
        }

        return resCode == HttpURLConnection.HTTP_OK;
    }
}
