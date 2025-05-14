package MasonerM11Example;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class JsonExample {
    public static void main(String[] args) {
        String json = "{\"name\":\"Alice\", \"age\":25}";

        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject jsonObject = reader.readObject();
        reader.close();

        System.out.println("Name: " + jsonObject.getString("name"));
        System.out.println("Age: " + jsonObject.getInt("age"));
    }
}

