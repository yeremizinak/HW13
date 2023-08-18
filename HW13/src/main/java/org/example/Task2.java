package org.example;

import com.google.gson.*;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Task2 {
    static void comments(int id) throws IOException {
        URL url = new URL(Task1.link + "/" + id + "/posts");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);


        String json = Jsoup.connect(Task1.link + "/" + id + "/posts")
                .ignoreContentType(true)
                .get()
                .body()
                .text();


        JsonArray jsonArray = JsonParser.parseString(json).getAsJsonArray();

        int maxId = 0;

        for (JsonElement jsonElement : jsonArray) {
            int idStr = jsonElement.getAsJsonObject().get("id").getAsInt();
            if (idStr > maxId) {
                maxId = idStr;
            }
        }

        String jsonComments = Jsoup.connect("https://jsonplaceholder.typicode.com/posts/" + maxId + "/comments")
                .ignoreContentType(true)
                .get()
                .body()
                .text();


        File file = new File("files/user-" + id + "-post-" + maxId + "-comments.json");
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(jsonComments);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        connection.disconnect();
    }
}
