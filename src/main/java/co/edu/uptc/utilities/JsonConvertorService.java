package co.edu.uptc.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class JsonConvertorService {

    private final ObjectMapper objectMapper;

    public JsonConvertorService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public <T> void objectToJson(ArrayList<T> objects, String outputFile) throws IOException {
        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            objectMapper.writeValue(fileWriter, objects);
        }
    }

    public <T> ArrayList<T> jsonToObject(String inputFile, TypeReference<ArrayList<T>> typeReference) throws IOException {
        File file = new File(inputFile);
        return objectMapper.readValue(file, typeReference);
    }
}

