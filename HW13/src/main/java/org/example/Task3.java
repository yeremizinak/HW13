package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task3 {

    static void toDo(int id) throws IOException {
        URL url = new URL(Task1.link + "/" + id + "/todos");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);


        String json = Jsoup.connect(Task1.link + "/" + id + "/todos")
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();
        StringBuilder title = new StringBuilder();

        for (JsonElement jsonElement : jsonArray) {
            boolean complete = jsonElement.getAsJsonObject().get("completed").getAsBoolean();
            if (!complete) {
                title.append(jsonElement.getAsJsonObject().get("title").getAsString() + "\n");
            }
        }
        String result = title.toString().replaceAll("\\s+\\Z", "");
        System.out.println(result);
    }
}
