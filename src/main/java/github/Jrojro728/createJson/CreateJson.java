package github.Jrojro728.createJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static github.Jrojro728.createJson.PlayerBlackListStatus.sendGet;

public class CreateJson {
    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args){
//        HashMapTest hashMapTest = new HashMapTest();
//        String string1 = gson.toJson(hashMapTest.normalMapping);
//        System.out.println(string1);
//
//        String string2 = gson.toJson(hashMapTest.HighLevelMapping);
//        System.out.println(string2);
        try {
            PlayerBlackListStatus playerBlackListStatus = new PlayerBlackListStatus();
            playerBlackListStatus = gson.fromJson(sendGet("https://api.scamlist.cn/uuid/0b524cc5edb745d1ba3b675e15079137.json").toString(), PlayerBlackListStatus.class);
            System.out.println(playerBlackListStatus.getName());
            System.out.println(playerBlackListStatus.getUUID());
            System.out.println(playerBlackListStatus.getTag());
            System.out.println(playerBlackListStatus.getAddUse());
            System.out.println(playerBlackListStatus.getReason());
            System.out.println(playerBlackListStatus.getDungeonBlack());
            System.out.println(playerBlackListStatus.getDungeonBlackReason());
            System.out.println(playerBlackListStatus.getRank());
            System.out.println(playerBlackListStatus.getContact());
            System.out.println(playerBlackListStatus.isFun());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
