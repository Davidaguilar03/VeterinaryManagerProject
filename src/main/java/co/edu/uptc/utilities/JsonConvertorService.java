package co.edu.uptc.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import co.edu.uptc.pojos.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
public class JsonConvertorService {

    public void personToJson(List<Person> persons, String outputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            objectMapper.writeValue(fileWriter, persons);
        }
    }

    public ArrayList<Person> jsonToPerson(String inputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(inputFile);
        return objectMapper.readValue(file, new TypeReference<ArrayList<Person>>() {
        });
    }

    public void petToJson(List<Pet> pets, String outputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            objectMapper.writeValue(fileWriter, pets);
        }
    }

    public ArrayList<Pet> jsonToPet(String inputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(inputFile);
        return objectMapper.readValue(file, new TypeReference<ArrayList<Pet>>() {
        });
    }

    public void appointmentToJson(List<Appointment> appointments, String outputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            objectMapper.writeValue(fileWriter, appointments);
        }
    }

    public ArrayList<Appointment> jsonToAppointment(String inputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(inputFile);
        return objectMapper.readValue(file, new TypeReference<ArrayList<Appointment>>() {
        });
    }

    public void vaccineToJson(List<Vaccine> vaccines, String outputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            objectMapper.writeValue(fileWriter, vaccines);
        }
    }

    public ArrayList<Vaccine> jsonToVaccine(String inputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(inputFile);
        return objectMapper.readValue(file, new TypeReference<ArrayList<Vaccine>>() {
        });
    }

   
}
