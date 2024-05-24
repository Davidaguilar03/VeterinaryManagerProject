package co.edu.uptc.views.petDataBaseFrame.editPetDialog;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ArrayList;

import co.edu.uptc.pojos.Person;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.petDataBaseFrame.petDataBaseMainFrame.PetDataBaseView;
import lombok.Getter;

@Getter
public class EditPetDialogView extends JDialog{
    private PetDataBaseView petDataBaseView;
    private EditPetDialogBody editPetDialogBody;
    private EditPetDialogFooter editPetDialogFooter;
    private PropertiesService propertiesService;

    public EditPetDialogView(PetDataBaseView petDataBaseView){
        super(petDataBaseView,true);
        this.petDataBaseView=petDataBaseView;
        propertiesService = new PropertiesService();
        this.initDialog();
        this.createMainHeader();
        this.createMainBody();
        this.createMainFooter();
    }

    public void begin(){
        loadPeopleData();
        this.setVisible(true);
    }

    private void initDialog(){
        this.setLayout(new BorderLayout());
        this.setSize(700,768);
        this.setTitle("Agregar Mascota");
        this.setResizable(false);
        this.setLocationRelativeTo(petDataBaseView);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    private void loadPeopleData(){
        ArrayList<Person> persons = petDataBaseView.getVeterinaryClinicView().getPresenter().getPersons();
        for (Person person : persons) {
            editPetDialogBody.addPerson(person);
        }
    }

    private void createMainHeader(){
        EditPetDialogHeader editPetDialogHeader = new EditPetDialogHeader();
        this.add(editPetDialogHeader,BorderLayout.NORTH);
    }

    private void createMainBody(){
        editPetDialogBody = new EditPetDialogBody(this);
        this.add(editPetDialogBody);
    }

    private void createMainFooter(){
        editPetDialogFooter = new EditPetDialogFooter(this);
        this.add(editPetDialogFooter,BorderLayout.SOUTH);
    }
}
