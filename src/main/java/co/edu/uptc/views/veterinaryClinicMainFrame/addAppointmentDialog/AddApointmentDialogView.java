package co.edu.uptc.views.veterinaryClinicMainFrame.addAppointmentDialog;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import co.edu.uptc.pojos.Person;
import co.edu.uptc.pojos.Pet;
import co.edu.uptc.pojos.Vaccine;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;
import lombok.Getter;
@Getter
public class AddApointmentDialogView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;
    private AddApointmentDialogBody addApointmentDialogBody;
    private AddApointmentDialogFooter addApointmentDialogFooter;
    private PropertiesService propertiesService;

    public AddApointmentDialogView(VeterinaryClinicView veterinaryClinicView){
        super(veterinaryClinicView,true);
        this.veterinaryClinicView = veterinaryClinicView;
        propertiesService = new PropertiesService();
        this.initDialog();
        this.createMainHeader();
        this.createMainBody();
        this.createMainFooter();
    }
    public void begin(){
        this.loadData();
        this.setVisible(true);
    }

    private void initDialog(){
        this.setLayout(new BorderLayout());
        this.setSize(800,768);
        this.setTitle("Agregar Cita");
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    private void loadData(){
        this.loadPeopleData();
        this.loadPetsData();
        this.loadVaccineData();
    }

    private void loadPeopleData(){
        ArrayList<Person> persons = veterinaryClinicView.getPresenter().getPersons();
        for (Person person : persons) {
            addApointmentDialogBody.addPerson(person);
        }
    }

    private void loadPetsData(){
        ArrayList<Pet> pets = veterinaryClinicView.getPresenter().getPets();
        for (Pet pet : pets) {
            addApointmentDialogBody.addPet(pet);
        }
    }

    private void loadVaccineData(){
        ArrayList<Vaccine> vaccines = veterinaryClinicView.getPresenter().getVaccines();
        for (Vaccine vaccine : vaccines) {
            addApointmentDialogBody.addVaccine(vaccine);
        }
    }

    private void createMainHeader(){
        AddApointmentDialogHeader addApointmentDialogHeader = new AddApointmentDialogHeader();
        this.add(addApointmentDialogHeader, BorderLayout.NORTH);
    }

    private void createMainBody(){
        addApointmentDialogBody = new AddApointmentDialogBody(veterinaryClinicView);
        this.add(addApointmentDialogBody);
    }

    private void createMainFooter(){
        addApointmentDialogFooter = new AddApointmentDialogFooter(veterinaryClinicView);
        this.add(addApointmentDialogFooter,BorderLayout.SOUTH); 
    }
    
}
