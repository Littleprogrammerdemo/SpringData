package org.softuni.ruk.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.softuni.ruk.parser.interfaces.Parser;
import org.springframework.stereotype.Component;

@Component(value = "JSONParser")
public class JSONParser implements Parser {

    private final Gson gson;

    public JSONParser() {
        this.gson = new GsonBuilder()
//                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("yyyy-MM-dd")
                .setPrettyPrinting()
                .create();
    }

    @Override
    public <T> T read(Class<T> objectClass, String fileContent) {
        return this.gson.fromJson(fileContent, objectClass);
    }

    @Override
    public <T> String write(T object) {
        return this.gson.toJson(object);
    }
}
