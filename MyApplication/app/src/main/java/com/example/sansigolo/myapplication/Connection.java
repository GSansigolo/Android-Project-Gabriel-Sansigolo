package com.example.sansigolo.myapplication;

import android.os.StrictMode;
import com.example.sansigolo.myapplication.Marker;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Sansigolo on 03/04/2017.
 */

public class Connection {

    private final String USER_AGENT = "Mozilla/5.0";

    public List<Marker> sendGet() throws Exception {
        String url = "https://api.myjson.com/bins/12a85f";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        List<Marker> found = findAllItems(new JSONArray(response.toString()));
        System.out.println(found);
        return found;
    }
    public List<Marker> findAllItems(JSONArray response) {

        List<Marker> found = new LinkedList<Marker>();

        try {

            for (int i = 0; i < response.length(); i++) {
                JSONObject obj = response.getJSONObject(i);

                found.add(new Marker(
                        obj.getDouble("lng"),
                        obj.getDouble("lat"),
                        obj.getString("geoname"),
                        obj.getString("wikipedia")
                        ));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return found;
    }


}
