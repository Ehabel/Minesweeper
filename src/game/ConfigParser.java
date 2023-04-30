package game;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;

public class ConfigParser {

    public static Long[] getConfig(){
        Long[] vals = new Long[2];
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("./config.json")) {
            JSONObject obj = (JSONObject) JSONValue.parse(reader);
            vals[0] = (Long) obj.get("size");
            vals[1] = (Long) obj.get("mines");
            return vals;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
