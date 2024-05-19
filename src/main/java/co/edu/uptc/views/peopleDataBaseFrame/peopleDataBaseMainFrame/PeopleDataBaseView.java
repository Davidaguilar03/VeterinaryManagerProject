package co.edu.uptc.views.peopleDataBaseFrame.peopleDataBaseMainFrame;

import javax.swing.JDialog;

import co.edu.uptc.pojos.Person;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;

import java.awt.BorderLayout;
import java.util.ArrayList;


public class PeopleDataBaseView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;
    private PeopleDataBaseBody mainBody;

    public PeopleDataBaseView(VeterinaryClinicView veterinaryClinicView){
        super(veterinaryClinicView,true);
        this.veterinaryClinicView=veterinaryClinicView;
        this.initFrame();
        this.createMainHeader();
        this.createMainAside();
        this.createMainBody();
    }
    public void begin(){
        this.loadPeopleData();
        this.setVisible(true);
    }

    private void loadPeopleData(){
        ArrayList<Person> persons = veterinaryClinicView.getPresenter().getPersons();
        for (Person person : persons) {
            mainBody.addPerson(person);
        }
    }

    private void initFrame(){
        this.setTitle("Clinica Veterinaria");
        this.setLayout(new BorderLayout());
        this.setSize(1366,768);
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
    }

    private void createMainHeader(){
        PeopleDataBaseHeader mainHeader = new PeopleDataBaseHeader();
        this.add(mainHeader, BorderLayout.NORTH);
    }

    private void createMainAside(){
        PeopleDataBaseAside mainAside = new PeopleDataBaseAside(veterinaryClinicView);
        this.add(mainAside, BorderLayout.WEST);
    }

    private void createMainBody(){
        mainBody = new PeopleDataBaseBody(veterinaryClinicView);
        this.add(mainBody);
    }

    public VeterinaryClinicView getVeterinaryClinicView() {
        return veterinaryClinicView;
    }

}
