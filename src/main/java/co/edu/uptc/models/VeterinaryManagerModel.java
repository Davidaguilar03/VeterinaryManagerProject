package co.edu.uptc.models;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import co.edu.uptc.interfaces.VeterinaryInterface;
import co.edu.uptc.pojos.Appointment;
import co.edu.uptc.pojos.Keeper;
import co.edu.uptc.pojos.Person;
import co.edu.uptc.pojos.Pet;
import co.edu.uptc.pojos.Vaccine;
import co.edu.uptc.utilities.JsonConvertorService;
import co.edu.uptc.utilities.PropertiesService;

public class VeterinaryManagerModel implements VeterinaryInterface.Model {
    private ArrayList<Person> persons;
    private ArrayList<Pet> pets;
    private ArrayList<Appointment> appointments;
    private ArrayList<Vaccine> vaccines;
    private VeterinaryInterface.Presenter presenter;


    public VeterinaryManagerModel(){
        persons = new ArrayList<>();
        pets = new ArrayList<>();
        appointments = new ArrayList<>();
        vaccines = new ArrayList<>();
        addAppointmentTest();
    }



    private void addAppointmentTest(){
        Person auxPerson = new Person(1, "David", 18, "Cedula de Ciudadania", 1032938747);
        persons.add(auxPerson);
        ArrayList<Keeper> keepers = new ArrayList<>();
        keepers.add(new Keeper(1, "Owner"));
        Pet auxPet = new Pet(1, "Lupita", "Gato", 5, "Raza x", keepers);
        ArrayList<Vaccine> vaccines = new ArrayList<>();
        vaccines.add(new Vaccine(1, "pulgas", 15));
        Appointment auxAppointment = new Appointment(1, auxPet, vaccines, LocalDate.now(), auxPet.getKeeper().getFirst());
        appointments.add(auxAppointment);
    }


    @Override
    public void setPresenter(VeterinaryInterface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void addPerson(Person person) {
        if (person != null) {
            Person personToAdd = person.clone();
            persons.add(personToAdd);
        }
    }

    @Override
    public void deletePerson(Person person) {
        if (person != null) {
            persons.remove(person);
        }
    }

    @Override
    public void addPet(Pet pet) {
        if (pet != null) {
            Pet petToAdd = pet.clone();
            pets.add(petToAdd);
        }
    }

    @Override
    public void deletePet(Pet pet) {
        if (pet != null) {
            pets.remove(pet);
        }
    }

    @Override
    public void addAppointment(Appointment appointment) {
        if (appointment != null) {
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
    public void addVaccine(Vaccine vaccine) {
        if (vaccine != null) {
            Vaccine vaccineToAdd = vaccine.clone();
            vaccines.add(vaccineToAdd);
        }
    }

    @Override
    public void deleteVaccine(Vaccine vaccine) {
        if (vaccine != null) {
            vaccines.remove(vaccine);
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
        JsonConvertorService jcs = new JsonConvertorService();
        PropertiesService propertiesService = new PropertiesService();
        try {
            this.persons = jcs.jsonToPerson(propertiesService
                    .getKeyValue("PersonsPath"));
            this.appointments = jcs.jsonToAppointment(propertiesService
                    .getKeyValue("AppointmentsPath"));
            this.pets = jcs.jsonToPet(propertiesService
                    .getKeyValue("PetsPath"));
            this.vaccines = jcs.jsonToVaccine(propertiesService
                    .getKeyValue("VaccinesPath"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeData() {
        JsonConvertorService jcs = new JsonConvertorService();
        PropertiesService propertiesService = new PropertiesService();
        try {
            jcs.personToJson(this.persons, propertiesService
                    .getKeyValue("PersonsPath"));
            jcs.appointmentToJson(this.appointments, propertiesService
                    .getKeyValue("AppointmentsPath"));
            jcs.petToJson(this.pets, propertiesService
                    .getKeyValue("PetsPath"));
            jcs.vaccineToJson(this.vaccines, propertiesService
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

}
