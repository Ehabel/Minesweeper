package game;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Utils {
    public static void createFile(){
        try {
            File myObj = new File("wins_losses.json");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("wins", 0);
                jsonObject.put("losses", 0);
                FileWriter file = new FileWriter(myObj);
                file.write(jsonObject.toJSONString());
                file.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void updateFile(String key){
        int valWins = getConfig("wins");
        int valLosses = getConfig("losses");
        try {
            FileWriter file = new FileWriter("./wins_losses.json");
            JSONObject jsonObject = new JSONObject();
            if(Objects.equals(key, "wins")){
                jsonObject.put(key,  valWins + 1);
                jsonObject.put("losses", valLosses);
            }else{
                jsonObject.put(key,  valLosses + 1);
                jsonObject.put("wins", valWins);
            }
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static int getConfig(String key){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("./wins_losses.json")) {
            JSONObject obj = (JSONObject) JSONValue.parse(reader);
            int vals = Math.toIntExact((Long) obj.get(key));
            reader.close();
            return vals;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
