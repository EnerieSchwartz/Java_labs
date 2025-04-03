package example.eater;

import com.google.gson.*;
import example.model.Human;

import example.model.Student;
import example.model.Sex;
import example.model.Department;

import java.lang.reflect.Type;

public class HumanAdapter implements JsonSerializer<Human>, JsonDeserializer<Human> {

    @Override
    public JsonElement serialize(Human src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.addProperty("type", src.getClass().getSimpleName());

        JsonObject data = new JsonObject();
        data.addProperty("lastName", src.getLastName());
        data.addProperty("firstName", src.getFirstName());
        data.addProperty("patronymic", src.getPatronymic());
        data.addProperty("sex", src.getSex().toString());

        result.add("data", data);
        return result;
    }

    @Override
    public Human deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonObject data = jsonObject.getAsJsonObject("data");

        String lastName = data.get("lastName").getAsString();
        String firstName = data.get("firstName").getAsString();
        String patronymic = data.get("patronymic").getAsString();
        Sex sex = Sex.valueOf(data.get("sex").getAsString());

        switch (type) {
            case "Student":
                return new Student(lastName, firstName, patronymic, sex);
            default:
                return new Human(firstName, lastName, patronymic, sex);
        }
    }
}