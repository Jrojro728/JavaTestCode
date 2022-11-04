package github.Jrojro728.createJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PlayerBlackListStatus{
    private String name;
    private String uuid;
    private String tag;
    private String addUse;
    private String reason;
    private String dungeonBlack;
    private String dungeonBlackReason;
    private String rank;
    private String contact;
    private boolean fun;

    public String getName() {
        return name;
    }

    public String getUUID() {
        return uuid;
    }

    public String getTag() {
        return tag;
    }

    public String getAddUse() {
        return addUse;
    }

    public String getReason() {
        return reason;
    }

    public String getDungeonBlack() {
        return dungeonBlack;
    }

    public String getDungeonBlackReason() {
        return dungeonBlackReason;
    }

    public String getRank() {
        return rank;
    }

    public String getContact() {
        return contact;
    }

    public boolean isFun() {
        return fun;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

    public void settag(String tag) {
        this.tag = tag;
    }

    public void setaddUse(String addUse) {
        this.addUse = addUse;
    }

    public void setreason(String reason) {
        this.reason = reason;
    }

    public void setDungeonBlack(String dungeonBlack) {
        this.dungeonBlack = dungeonBlack;
    }

    public void setDreason(String dungeonBlackReason) {
        this.dungeonBlackReason = dungeonBlackReason;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setcontact(String contact) {
        this.contact = contact;
    }

    public void setfun(boolean fun) {
        this.fun = fun;
    }

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36";
    private final Gson gson = new GsonBuilder().create();

    public PlayerBlackListStatus() {

    }

    public static StringBuffer sendGet(String host) {
        try {
            HttpURLConnection connection = null;
            BufferedReader bufferedReader = null;
            StringBuffer resultBuffer = null;

            URL url = new URL(host);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            int responseCode = connection.getResponseCode();
//
//            System.out.println(responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                resultBuffer = new StringBuffer();
                String line;
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
                while ((line = bufferedReader.readLine()) != null) {
                    resultBuffer.append(line);
                }
                return resultBuffer;
            }
            return new StringBuffer("error");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new StringBuffer("error");
    }
}
