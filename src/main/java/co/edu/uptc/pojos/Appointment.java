package co.edu.uptc.pojos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment implements Cloneable {
    private Pet pet;
    private Vaccine[] vaccines;
    private LocalDate date;
    private Keeper keeper;
    
    public void sortVaccines(){
        Vaccine[] sortVaccines = new Vaccine[vaccines.length];
        for (Vaccine vaccine : vaccines) {
            if (vaccine.getExpireDate().isBefore(date)) {
                
            }
        }
    }

    @Override
    public Appointment clone(){
        try {
            return (Appointment) super.clone(); 
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
