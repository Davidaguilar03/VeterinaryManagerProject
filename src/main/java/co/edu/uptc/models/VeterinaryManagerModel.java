package co.edu.uptc.models;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.uptc.interfaces.VeterinaryInterface;
import co.edu.uptc.pojos.Appointment;
import co.edu.uptc.pojos.Person;
import co.edu.uptc.pojos.Pet;
import co.edu.uptc.pojos.Vaccine;

public class VeterinaryManagerModel implements VeterinaryInterface.Model {
    private ArrayList<Person> persons;
    private ArrayList<Pet>pets;
    private ArrayList<Appointment> appointments;
    private ArrayList<Vaccine> vaccines;
    private VeterinaryInterface.Presenter presenter;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortByDate'");
    }

    @Override
    public ArrayList<Appointment> sortByPerson(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortByPerson'");
    }

    @Override
    public ArrayList<Appointment> sortByVaccineExpireDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortByVaccineExpireDate'");
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

    
}
