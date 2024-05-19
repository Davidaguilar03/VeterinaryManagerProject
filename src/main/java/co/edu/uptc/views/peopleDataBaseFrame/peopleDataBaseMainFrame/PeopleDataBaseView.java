package co.edu.uptc.views.peopleDataBaseFrame.peopleDataBaseMainFrame;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import co.edu.uptc.pojos.Person;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ArrayList;


public class PeopleDataBaseView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;
    private PeopleDataBaseBody peopleDataBaseBody;
    private PropertiesService propertiesService;

    public PeopleDataBaseView(VeterinaryClinicView veterinaryClinicView){
        super(veterinaryClinicView,true);
        this.veterinaryClinicView=veterinaryClinicView;
        propertiesService = new PropertiesService();
        this.initFrame();
        this.createPeopleDataBaseHeader();
        this.createPeopleDataBaseAside();
        this.createPeopleDataBaseBody();
    }
    public void begin(){
        this.loadPeopleData();
        this.setVisible(true);
    }

    private void initFrame(){
        this.setTitle("Registro de Personas");
        this.setLayout(new BorderLayout());
        this.setSize(1366,768);
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    private void loadPeopleData(){
        ArrayList<Person> persons = veterinaryClinicView.getPresenter().getPersons();
        for (Person person : persons) {
            peopleDataBaseBody.addPerson(person);
        }
    }

    private void createPeopleDataBaseHeader(){
        PeopleDataBaseHeader peopleDataBaseHeader = new PeopleDataBaseHeader();
        this.add(peopleDataBaseHeader, BorderLayout.NORTH);
    }

    private void createPeopleDataBaseAside(){
        PeopleDataBaseAside peopleDataBaseAside = new PeopleDataBaseAside(veterinaryClinicView);
        this.add(peopleDataBaseAside, BorderLayout.WEST);
    }

    private void createPeopleDataBaseBody(){
        peopleDataBaseBody = new PeopleDataBaseBody(veterinaryClinicView);
        this.add(peopleDataBaseBody);
    }

    public VeterinaryClinicView getVeterinaryClinicView() {
        return veterinaryClinicView;
    }

}
