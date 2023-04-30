import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ConfigParser {

    public static Long getSize(){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("./config.json")) {
            JSONObject obj = (JSONObject) JSONValue.parse(reader);
            Long size = (Long) obj.get("size");
            return size;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
