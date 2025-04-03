package example.eater;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import example.model.Human;
import example.model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    private static final String FILE_PATH = "university.json";

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Human.class, new HumanAdapter())
            .setPrettyPrinting()
            .create();

    public static void saveToJson(University university) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(university, University.class, writer);
            System.out.println("University is  saved to JSON file.");
        } catch (IOException e) {
            System.err.println("Error while saving to JSON: " + e.getMessage());
        }
    }

    public static University loadFromJson() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, University.class);
        } catch (IOException e) {
            System.err.println("Error while loading from JSON: " + e.getMessage());
            return null;
        }
    }
}