package co.edu.uptc.views.peopleDataBaseFrame.peopleDataBaseMainFrame;

import javax.swing.JDialog;

import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;

import java.awt.BorderLayout;


public class PeopleDataBaseView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;

    public PeopleDataBaseView(VeterinaryClinicView veterinaryClinicView){
        super(veterinaryClinicView,true);
        this.veterinaryClinicView=veterinaryClinicView;
        initFrame();
        createMainHeader();
        createMainAside();
        createMainBody();
    }
    public void begin(){
        this.setVisible(true);
    }

    private void initFrame(){
        this.setTitle("Clinica Veterinaria");
        this.setLayout(new BorderLayout());
        this.setSize(1366,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void createMainHeader(){
        PeopleDataBaseHeader mainHeader = new PeopleDataBaseHeader();
        this.add(mainHeader, BorderLayout.NORTH);
    }

    private void createMainAside(){
        PeopleDataBaseAside mainAside = new PeopleDataBaseAside();
        this.add(mainAside, BorderLayout.WEST);
    }

    private void createMainBody(){
        PeopleDataBaseBody mainBody = new PeopleDataBaseBody();
        this.add(mainBody);
    }

    public VeterinaryClinicView getVeterinaryClinicView() {
        return veterinaryClinicView;
    }

}
