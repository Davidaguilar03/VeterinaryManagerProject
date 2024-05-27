package co.edu.uptc.presenters;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.uptc.interfaces.VeterinaryInterface;
import co.edu.uptc.pojos.Appointment;
import co.edu.uptc.pojos.Person;
import co.edu.uptc.pojos.Pet;
import co.edu.uptc.pojos.Vaccine;

public class Presenter implements VeterinaryInterface.Presenter{
    private VeterinaryInterface.View view;
    private VeterinaryInterface.Model model;

    @Override
    public void setView(VeterinaryInterface.View view) {
       this.view = view;
    }

    @Override
    public void setModel(VeterinaryInterface.Model model) {
        this.model = model;
    }

    @Override
    public void addPerson(Person person) {
        model.addPerson(person);
    }

    @Override
    public void deletePerson(Person person) {
       model.deletePerson(person);
    }

    @Override
    public void addPet(Pet pet) {
        model.addPet(pet);
    }

    @Override
    public void deletePet(Pet pet) {
        model.deletePet(pet);
    }

    @Override
    public void addAppointment(Appointment appointment) {
        model.addAppointment(appointment);
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        model.deleteAppointment(appointment);
    }

    @Override
    public void addVaccine(Vaccine vaccine) {
       model.addVaccine(vaccine);
    }

    @Override
    public void deleteVaccine(Vaccine vaccine) {
        model.deleteVaccine(vaccine);
    }

    @Override
    public ArrayList<Appointment> sortByDate(LocalDate date) {
        return model.sortByDate(date);
    }

    @Override
    public ArrayList<Appointment> sortByPerson(Person person) {
        return model.sortByPerson(person);
    }

    @Override
    public ArrayList<Appointment> sortByVaccineExpireDate(int days) {
       return model.sortByVaccineExpireDate(days);
    }

    @Override
    public ArrayList<Person> getPersons() {
        return model.getPersons();
    }

    @Override
    public ArrayList<Pet> getPets() {
        return model.getPets();
    }

    @Override
    public ArrayList<Appointment> getAppointments() {
        return model.getAppointments();
    }

    @Override
    public ArrayList<Vaccine> getVaccines() {
        return model.getVaccines();
    }

    public VeterinaryInterface.View getView() {
        return view;
    }

    @Override
    public void loadData() {
        model.loadData();
    }

    @Override
    public void writeData() {
      model.writeData();
    }

    @Override
    public Person searchPersonById(int personId) {
        return model.searchPersonById(personId);
    }

    @Override
    public void editPerson(Person person) {
        model.editPerson(person);
    }

    @Override
    public void editPet(Pet pet) {
       model.editPet(pet);
    }

    @Override
    public void editVaccine(Vaccine vaccine) {
        model.editVaccine(vaccine);
    }

    @Override
    public Appointment searchAppointmentById(int appointmentId) {
      return model.searchAppointmentById(appointmentId);
    }

    
}
