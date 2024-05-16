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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPerson'");
    }

    @Override
    public void deletePerson(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePerson'");
    }

    @Override
    public void addPet(Pet pet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPet'");
    }

    @Override
    public void deletePet(Pet pet) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePet'");
    }

    @Override
    public void addAppointment(Appointment appointment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAppointment'");
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAppointment'");
    }

    @Override
    public void addVaccine(Vaccine vaccine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addVaccine'");
    }

    @Override
    public void deleteVaccine(Vaccine vaccine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteVaccine'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersons'");
    }

    @Override
    public ArrayList<Pet> getPets() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPets'");
    }

    @Override
    public ArrayList<Appointment> getAppointments() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAppointments'");
    }

    @Override
    public ArrayList<Vaccine> getVaccines() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVaccines'");
    }

}
