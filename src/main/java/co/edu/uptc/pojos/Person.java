package co.edu.uptc.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Person implements Cloneable{
    private int id;
    private String name;
    private int age;
    private String typeOfDocument;
    private int documentNumber;

    @Override
    public Person clone(){
        try {
            return (Person) super.clone(); 
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}

