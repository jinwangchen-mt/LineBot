package com.example.bot.menu;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class LineRichMenu {

    public static void main(String[] args) {
        try {
            // LINE Messaging API URL
            URL url = new URL("https://api.line.me/v2/bot/richmenu");
            
            // 開啟 HTTP 連線
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer {uDfRJUuUsoivoHXlzdIxW0luhFwVetFKZ5Odl/JWTu8CLzGVk1FOjRZ5/1DgSJ9LhE2b9bBpbN18q05jhcOexVN/oqjDwnuJNGKLfy/8rC6SbOwyey9HsxXfvhScZlKcyw1ucb1Zk0UOwLielCoX1wdB04t89/1O/w1cDnyilFU=}");
            conn.setRequestProperty("Content-Type", "application/json");

            // Rich Menu 的 JSON 內容
            String jsonInputString = "{\n" +
                    "    \"size\": {\n" +
                    "        \"width\": 2500,\n" +
                    "        \"height\": 1686\n" +
                    "    },\n" +
                    "    \"selected\": false,\n" +
                    "    \"name\": \"Test the default rich menu\",\n" +
                    "    \"chatBarText\": \"Tap to open\",\n" +
                    "    \"areas\": [\n" +
                    "        {\n" +
                    "            \"bounds\": {\n" +
                    "                \"x\": 0,\n" +
                    "                \"y\": 0,\n" +
                    "                \"width\": 1666,\n" +
                    "                \"height\": 1686\n" +
                    "            },\n" +
                    "            \"action\": {\n" +
                    "                \"type\": \"uri\",\n" +
                    "                \"label\": \"Tap area A\",\n" +
                    "                \"uri\": \"https://developers.line.biz/en/news/\"\n" +
                    "            }\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"bounds\": {\n" +
                    "                \"x\": 1667,\n" +
                    "                \"y\": 0,\n" +
                    "                \"width\": 834,\n" +
                    "                \"height\": 843\n" +
                    "            },\n" +
                    "            \"action\": {\n" +
                    "                \"type\": \"uri\",\n" +
                    "                \"label\": \"Tap area B\",\n" +
                    "                \"uri\": \"https://lineapiusecase.com/en/top.html\"\n" +
                    "            }\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"bounds\": {\n" +
                    "                \"x\": 1667,\n" +
                    "                \"y\": 844,\n" +
                    "                \"width\": 834,\n" +
                    "                \"height\": 843\n" +
                    "            },\n" +
                    "            \"action\": {\n" +
                    "                \"type\": \"uri\",\n" +
                    "                \"label\": \"Tap area C\",\n" +
                    "                \"uri\": \"https://techblog.lycorp.co.jp/en/\"\n" +
                    "            }\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";

            // 將 JSON 內容寫入 HTTP 請求的 body
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // 確認回應狀態碼
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            
            // 如果需要，可以處理回應內容
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Rich menu created successfully.");
            } else {
                System.out.println("Failed to create rich menu.");
            }

            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

