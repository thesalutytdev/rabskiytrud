package org.thesalutyt.dedaebutrabi.utils.bot_api;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;


public class ApiSend {
    private static final OkHttpClient client = new OkHttpClient();
    private static final String SERVER_URL = "http://localhost:8000";
    private static final Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        System.out.println(getServerStatus());
        System.out.println(actionSend("uuid test2", "name test2", "test2"));
    }

    public static String getServerStatus() throws IOException {
        Request request = new Request.Builder()
                .url(SERVER_URL + "/status")
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code: " + response);
            }
        }
    }

    public static String actionSend(String uuid, String nickname, String action) throws IOException {
        String json = gson.toJson(new ActionPack(uuid, nickname, action));
        RequestBody body = RequestBody.create(json, MediaType.get("application/json"));

        Request request = new Request.Builder()
                .url(SERVER_URL + "/action")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code: " + response);
            }
        }
    }

    static class ActionPack {
        String uuid_mc;
        String nickname_mc;
        String action;

        public ActionPack(String uuid, String nickname, String action) {
            this.uuid_mc = uuid;
            this.nickname_mc = nickname;
            this.action = action;
        }
    }
}
