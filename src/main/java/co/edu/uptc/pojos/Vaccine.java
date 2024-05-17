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
public class Vaccine implements Cloneable{
    private int id;
    private String name;
    private int shelfLife;

    public LocalDate getExpireDate(){
        LocalDate expireDate = LocalDate.now().plusDays(shelfLife);
        return expireDate;
    }


    @Override
    public  Vaccine clone(){
        try {
            return (Vaccine) super.clone(); 
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
