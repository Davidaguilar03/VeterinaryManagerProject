package co.edu.uptc.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet implements Cloneable {
    private int id;
    private String name;
    private String species;
    private int age;
    private String breed;
    private Keeper[] keeper;

    @Override
    public Pet clone(){
        try {
            return (Pet) super.clone(); 
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
