package Utilities;

import io.restassured.path.json.JsonPath;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONReaderUtils {

    public static String getStringData(String json, String key){
        JsonPath js = new JsonPath(json);

        String value = js.getString(key);

        return value;
    }

    public static String getJsonFromFile(String path){
        String jsonString = "";
        if(path != null){
            try {
                jsonString = new String(Files.readAllBytes(Paths.get(path)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return jsonString;
    }
}
