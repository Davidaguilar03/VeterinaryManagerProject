package co.edu.uptc.pojos;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pet implements Cloneable {
    private int id;
    private String name;
    private String species;
    private int age;
    private String breed;
    private ArrayList<Keeper> keepers;

    @Override
    public Pet clone(){
        try {
            return (Pet) super.clone(); 
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
