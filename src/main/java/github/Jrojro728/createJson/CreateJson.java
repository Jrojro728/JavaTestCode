package github.Jrojro728.createJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static github.Jrojro728.createJson.PlayerBlackListStatus.sendGet;

public class CreateJson {
    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args){
        try {
            new PlayerBlackListStatus();
            PlayerBlackListStatus playerBlackListStatus;
            playerBlackListStatus = gson.fromJson(sendGet("https://api.scamlist.cn/uuid/0b524cc5edb745d1ba3b675e15079137.json").toString(), PlayerBlackListStatus.class);
            System.out.println(playerBlackListStatus.getname());
            System.out.println(playerBlackListStatus.getUUID());
            System.out.println(playerBlackListStatus.getTag());
            System.out.println(playerBlackListStatus.getadduse());
            System.out.println(playerBlackListStatus.getReason());
            System.out.println(playerBlackListStatus.getDungeonBlack());
            System.out.println(playerBlackListStatus.getDreason());
            System.out.println(playerBlackListStatus.getRank());
            System.out.println(playerBlackListStatus.getContact());
            System.out.println(playerBlackListStatus.isFun());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
