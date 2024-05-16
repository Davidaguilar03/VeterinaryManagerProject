package co.edu.uptc.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import co.edu.uptc.pojos.*;


public interface VeterinaryInterface {

    public interface Model {
        public void setPresenter(Presenter presenter);
        public void addPerson(Person person);
        public void deletePerson(Person person);
        public void addPet(Pet pet);
        public void deletePet(Pet pet);
        public void addAppointment(Appointment appointment);
        public void deleteAppointment(Appointment appointment);
        public void addVaccine(Vaccine vaccine);
        public void deleteVaccine(Vaccine vaccine);      
        public ArrayList<Appointment> sortByDate(LocalDate date); 
        public ArrayList<Appointment> sortByPerson(Person person);
        public ArrayList<Appointment> sortByVaccineExpireDate(); 
        public ArrayList<Person> getPersons();
        public ArrayList<Pet> getPets();
        public ArrayList<Appointment> getAppointments();
        public ArrayList<Vaccine> getVaccines();
    }
    
    public interface View{
        public void setPresenter(Presenter presenter);
        public void begin();
    }

    public interface Presenter{
        public void setView(View view);
        public void setModel(Model model);
        public void addPerson(Person person);
        public void deletePerson(Person person);
        public void addPet(Pet pet);
        public void deletePet(Pet pet);
        public void addAppointment(Appointment appointment);
        public void deleteAppointment(Appointment appointment);
        public void addVaccine(Vaccine vaccine);
        public void deleteVaccine(Vaccine vaccine);      
        public ArrayList<Appointment> sortByDate(LocalDate date); 
        public ArrayList<Appointment> sortByPerson(Person person);
        public ArrayList<Appointment> sortByVaccineExpireDate(); 
        public ArrayList<Person> getPersons();
        public ArrayList<Pet> getPets();
        public ArrayList<Appointment> getAppointments();
        public ArrayList<Vaccine> getVaccines();
    }
} 
