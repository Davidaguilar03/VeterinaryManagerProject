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
public class Appointment {
private Pet pet;
private Vaccine[] vaccines;
private LocalDate date;
private Keeper keeper;
}
