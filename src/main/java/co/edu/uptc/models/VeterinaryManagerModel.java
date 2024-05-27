package co.edu.uptc.models;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


import com.fasterxml.jackson.core.type.TypeReference;

import co.edu.uptc.interfaces.VeterinaryInterface;
import co.edu.uptc.pojos.Appointment;
import co.edu.uptc.pojos.Person;
import co.edu.uptc.pojos.Pet;
import co.edu.uptc.pojos.Vaccine;
import co.edu.uptc.utilities.JsonConvertorService;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.utilities.UniqueIDGenerator;

public class VeterinaryManagerModel implements VeterinaryInterface.Model {
    private ArrayList<Person> persons;
    private ArrayList<Pet> pets;
    private ArrayList<Appointment> appointments;
    private ArrayList<Vaccine> vaccines;
    private VeterinaryInterface.Presenter presenter;

    public VeterinaryManagerModel() {
        persons = new ArrayList<>();
        pets = new ArrayList<>();
        appointments = new ArrayList<>();
        vaccines = new ArrayList<>();
        loadData();
    }

    @Override
    public void setPresenter(VeterinaryInterface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addPerson(Person person) {
        if (person != null) {
            person.setId(UniqueIDGenerator.getUniqueID());
            Person personToAdd = person.clone();
            persons.add(personToAdd);
        }
    }

    @Override
    public void deletePerson(Person auxPerson) {
        if (auxPerson != null) {
            for (int i = 0; i < persons.size(); i++) {
                if (persons.get(i).getId() == auxPerson.getId()) {
                    this.persons.remove(i);
                }
            }
        }
    }

    @Override
    public void editPerson(Person auxPerson) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId() == auxPerson.getId()) {
                persons.remove(i);
                persons.add(i, auxPerson);
            }
        }
    }

    @Override
    public void addPet(Pet pet) {
        if (pet != null) {
            pet.setId(UniqueIDGenerator.getUniqueID());
            Pet petToAdd = pet.clone();
            pets.add(petToAdd);
        }
    }

    @Override
    public void deletePet(Pet auxPet) {
        if (auxPet != null) {
            for (int i = 0; i < pets.size(); i++) {
                if (pets.get(i).getId() == auxPet.getId()) {
                    this.pets.remove(i);
                }
            }
        }
    }

    @Override
    public void editPet(Pet auxPet) {
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == auxPet.getId()) {
                pets.remove(i);
                pets.add(i, auxPet);
            }
        }
    }

    @Override
    public void addVaccine(Vaccine vaccine) {
        if (vaccine != null) {
            vaccine.setId(UniqueIDGenerator.getUniqueID());
            Vaccine vaccineToAdd = vaccine.clone();
            vaccines.add(vaccineToAdd);
        }
    }

    @Override
    public void deleteVaccine(Vaccine auxVaccine) {
        if (auxVaccine != null) {
            for (int i = 0; i < vaccines.size(); i++) {
                if (vaccines.get(i).getId() == auxVaccine.getId()) {
                    this.vaccines.remove(i);
                }
            }
        }
    }

    @Override
    public void editVaccine(Vaccine auxVaccine) {
        for (int i = 0; i < vaccines.size(); i++) {
            if (vaccines.get(i).getId() == auxVaccine.getId()) {
                vaccines.remove(i);
                vaccines.add(i, auxVaccine);
            }
        }
    }

    @Override
    public void addAppointment(Appointment appointment) {
        if (appointment != null) {
            appointment.setId(UniqueIDGenerator.getUniqueID());
            Appointment appointmentToAdd = appointment.clone();
            appointments.add(appointmentToAdd);
        }
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        if (appointment != null) {
            appointments.remove(appointment);
        }
    }

    @Override
    public ArrayList<Appointment> sortByDate(LocalDate date) {
        ArrayList<Appointment> sortByDateAppointments = new ArrayList<>();
        for (Appointment appointment : this.appointments) {
            if (appointment.getDate().isEqual(date)) {
                sortByDateAppointments.add(appointment);
            }
        }
        return sortByDateAppointments;
    }

    @Override
    public ArrayList<Appointment> sortByPerson(Person person) {
        ArrayList<Appointment> sortByPersonAppointments = new ArrayList<>();
        for (Appointment appointment : this.appointments) {
            if (this.searchPersonById(appointment.getKeeper().getPersonId()).equals(person)) {
                sortByPersonAppointments.add(appointment);
            }
        }
        return sortByPersonAppointments;
    }

    @Override
    public ArrayList<Appointment> sortByVaccineExpireDate(int days) {
        ArrayList<Appointment> sortByVaccineExpireDate = new ArrayList<>();
        for (Appointment appointment : this.appointments) {
            for (Vaccine appointmentVaccine : appointment.getVaccines()) {
                if ((int) ChronoUnit.DAYS.between(LocalDate.now(), appointmentVaccine.getExpireDate()) == days) {
                    sortByVaccineExpireDate.add(appointment);
                }
            }
        }
        return sortByVaccineExpireDate;
    }

    @Override
    public ArrayList<Person> getPersons() {
        ArrayList<Person> auxPersons = new ArrayList<>();
        for (Person person : persons) {
            auxPersons.add(person.clone());
        }
        return auxPersons;
    }

    @Override
    public ArrayList<Pet> getPets() {
        ArrayList<Pet> auxPets = new ArrayList<>();
        for (Pet pet : pets) {
            auxPets.add(pet.clone());
        }
        return auxPets;
    }

    @Override
    public ArrayList<Appointment> getAppointments() {
        ArrayList<Appointment> auxAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            auxAppointments.add(appointment.clone());
        }
        return auxAppointments;
    }

    @Override
    public ArrayList<Vaccine> getVaccines() {
        ArrayList<Vaccine> auxVaccines = new ArrayList<>();
        for (Vaccine vaccine : vaccines) {
            auxVaccines.add(vaccine.clone());
        }
        return auxVaccines;
    }

    public VeterinaryInterface.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void loadData() {
        JsonConvertorService jsonConvertorService = new JsonConvertorService();
        PropertiesService propertiesService = new PropertiesService();
        try {
            this.persons = jsonConvertorService.jsonToObject(propertiesService
                    .getKeyValue("PersonsPath"), new TypeReference<ArrayList<Person>>() {
                    });
            this.appointments = jsonConvertorService.jsonToObject(propertiesService
                    .getKeyValue("AppointmentsPath"), new TypeReference<ArrayList<Appointment>>() {
                    });
            this.pets = jsonConvertorService.jsonToObject(propertiesService
                    .getKeyValue("PetsPath"), new TypeReference<ArrayList<Pet>>() {
                    });
            this.vaccines = jsonConvertorService.jsonToObject(propertiesService
                    .getKeyValue("VaccinesPath"), new TypeReference<ArrayList<Vaccine>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeData() {
        JsonConvertorService jsonConvertorService = new JsonConvertorService();
        PropertiesService propertiesService = new PropertiesService();
        try {
            jsonConvertorService.objectToJson(this.persons, propertiesService
                    .getKeyValue("PersonsPath"));
            jsonConvertorService.objectToJson(this.appointments, propertiesService
                    .getKeyValue("AppointmentsPath"));
            jsonConvertorService.objectToJson(this.pets, propertiesService
                    .getKeyValue("PetsPath"));
            jsonConvertorService.objectToJson(this.vaccines, propertiesService
                    .getKeyValue("VaccinesPath"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person searchPersonById(int personId) {
        Person auxPerson = new Person();
        for (Person person : this.persons) {
            if (person.getId() == personId) {
                auxPerson = person;
            }
        }
        return auxPerson;
    }

    @Override
    public Appointment searchAppointmentById(int appointmentId) {
       Appointment auxAppointment = new Appointment();
       for (Appointment appointment : this.appointments) {
        if (appointment.getId() == appointmentId) {
            auxAppointment = appointment;
        }
       }
       return auxAppointment;
    }
}
