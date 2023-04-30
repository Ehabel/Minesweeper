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

    public static String lostString(){
        return ("YYYYYYY       YYYYYYY                                        LLLLLLLLLLL                                                        tttt           !!! \n" +
                "Y:::::Y       Y:::::Y                                        L:::::::::L                                                     ttt:::t          !!:!!\n" +
                "Y:::::Y       Y:::::Y                                        L:::::::::L                                                     t:::::t          !:::!\n" +
                "Y::::::Y     Y::::::Y                                        LL:::::::LL                                                     t:::::t          !:::!\n" +
                "YYY:::::Y   Y:::::YYY   ooooooooooo   uuuuuu    uuuuuu         L:::::L                  ooooooooooo       ssssssssss   ttttttt:::::ttttttt    !:::!\n" +
                "   Y:::::Y Y:::::Y    oo:::::::::::oo u::::u    u::::u         L:::::L                oo:::::::::::oo   ss::::::::::s  t:::::::::::::::::t    !:::!\n" +
                "    Y:::::Y:::::Y    o:::::::::::::::ou::::u    u::::u         L:::::L               o:::::::::::::::oss:::::::::::::s t:::::::::::::::::t    !:::!\n" +
                "     Y:::::::::Y     o:::::ooooo:::::ou::::u    u::::u         L:::::L               o:::::ooooo:::::os::::::ssss:::::stttttt:::::::tttttt    !:::!\n" +
                "      Y:::::::Y      o::::o     o::::ou::::u    u::::u         L:::::L               o::::o     o::::o s:::::s  ssssss       t:::::t          !:::!\n" +
                "       Y:::::Y       o::::o     o::::ou::::u    u::::u         L:::::L               o::::o     o::::o   s::::::s            t:::::t          !:::!\n" +
                "       Y:::::Y       o::::o     o::::ou::::u    u::::u         L:::::L               o::::o     o::::o      s::::::s         t:::::t          !!:!!\n" +
                "       Y:::::Y       o::::o     o::::ou:::::uuuu:::::u         L:::::L         LLLLLLo::::o     o::::ossssss   s:::::s       t:::::t    tttttt !!! \n" +
                "       Y:::::Y       o:::::ooooo:::::ou:::::::::::::::uu     LL:::::::LLLLLLLLL:::::Lo:::::ooooo:::::os:::::ssss::::::s      t::::::tttt:::::t     \n" +
                "    YYYY:::::YYYY    o:::::::::::::::o u:::::::::::::::u     L::::::::::::::::::::::Lo:::::::::::::::os::::::::::::::s       tt::::::::::::::t !!! \n" +
                "    Y:::::::::::Y     oo:::::::::::oo   uu::::::::uu:::u     L::::::::::::::::::::::L oo:::::::::::oo  s:::::::::::ss          tt:::::::::::tt!!:!!\n" +
                "    YYYYYYYYYYYYY       ooooooooooo       uuuuuuuu  uuuu     LLLLLLLLLLLLLLLLLLLLLLLL   ooooooooooo     sssssssssss              ttttttttttt   !!! ");
    }

    public static String winString(){
        return("YYYYYYY       YYYYYYY                                        WWWWWWWW                           WWWWWWWW  iiii                     !!! \n" +
                "Y:::::Y       Y:::::Y                                        W::::::W                           W::::::W i::::i                   !!:!!\n" +
                "Y:::::Y       Y:::::Y                                        W::::::W                           W::::::W  iiii                    !:::!\n" +
                "Y::::::Y     Y::::::Y                                        W::::::W                           W::::::W                          !:::!\n" +
                "YYY:::::Y   Y:::::YYY   ooooooooooo   uuuuuu    uuuuuu        W:::::W           WWWWW           W:::::W iiiiiii nnnn  nnnnnnnn    !:::!\n" +
                "   Y:::::Y Y:::::Y    oo:::::::::::oo u::::u    u::::u         W:::::W         W:::::W         W:::::W  i:::::i n:::nn::::::::nn  !:::!\n" +
                "    Y:::::Y:::::Y    o:::::::::::::::ou::::u    u::::u          W:::::W       W:::::::W       W:::::W    i::::i n::::::::::::::nn !:::!\n" +
                "     Y:::::::::Y     o:::::ooooo:::::ou::::u    u::::u           W:::::W     W:::::::::W     W:::::W     i::::i nn:::::::::::::::n!:::!\n" +
                "      Y:::::::Y      o::::o     o::::ou::::u    u::::u            W:::::W   W:::::W:::::W   W:::::W      i::::i   n:::::nnnn:::::n!:::!\n" +
                "       Y:::::Y       o::::o     o::::ou::::u    u::::u             W:::::W W:::::W W:::::W W:::::W       i::::i   n::::n    n::::n!:::!\n" +
                "       Y:::::Y       o::::o     o::::ou::::u    u::::u              W:::::W:::::W   W:::::W:::::W        i::::i   n::::n    n::::n!!:!!\n" +
                "       Y:::::Y       o::::o     o::::ou:::::uuuu:::::u               W:::::::::W     W:::::::::W         i::::i   n::::n    n::::n !!! \n" +
                "       Y:::::Y       o:::::ooooo:::::ou:::::::::::::::uu              W:::::::W       W:::::::W         i::::::i  n::::n    n::::n     \n" +
                "    YYYY:::::YYYY    o:::::::::::::::o u:::::::::::::::u               W:::::W         W:::::W          i::::::i  n::::n    n::::n !!! \n" +
                "    Y:::::::::::Y     oo:::::::::::oo   uu::::::::uu:::u                W:::W           W:::W           i::::::i  n::::n    n::::n!!:!!\n" +
                "    YYYYYYYYYYYYY       ooooooooooo       uuuuuuuu  uuuu                 WWW             WWW            iiiiiiii  nnnnnn    nnnnnn !!! ");
    }

}
