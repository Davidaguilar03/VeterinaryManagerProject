package co.edu.uptc.pojos;

import java.time.LocalDate;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment implements Cloneable {
    private int id;
    private Pet pet;
    private ArrayList<Vaccine> vaccines;
    private LocalDate date;
    private Keeper keeper;
   
    @Override
    public Appointment clone(){
        try {
            return (Appointment) super.clone(); 
        } catch (CloneNotSupportedException e) {
            return null;
        }
    } 
}
