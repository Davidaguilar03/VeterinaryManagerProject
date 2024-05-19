package co.edu.uptc.views.petDataBaseFrame.petDataBaseMainFrame;

import javax.swing.JDialog;

import co.edu.uptc.pojos.Pet;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;
import java.awt.BorderLayout;
import java.util.ArrayList;


public class PetDataBaseView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;
    private PetDataBaseBody mainBody;

    public PetDataBaseView(VeterinaryClinicView veterinaryClinicView){
        super(veterinaryClinicView,true);
        this.veterinaryClinicView=veterinaryClinicView;
        this.initFrame();
        this.createMainHeader();
        this.createMainAside();
        this.createMainBody();
    }
    public void begin(){
        this.loadPetsData();
        this.setVisible(true);
    }

    private void initFrame(){
        this.setTitle("Clinica Veterinaria");
        this.setLayout(new BorderLayout());
        this.setSize(1366,768);
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
    }

    private void loadPetsData(){
        ArrayList<Pet> pets = veterinaryClinicView.getPresenter().getPets();
        for (Pet pet : pets) {
            mainBody.addPet(pet);
        }
    }

    private void createMainHeader(){
        PetDataBaseHeader mainHeader = new PetDataBaseHeader();
        this.add(mainHeader, BorderLayout.NORTH);
    }

    private void createMainAside(){
        PetDataBaseAside mainAside = new PetDataBaseAside(veterinaryClinicView);
        this.add(mainAside, BorderLayout.WEST);
    }

    private void createMainBody(){
        mainBody = new PetDataBaseBody(veterinaryClinicView);
        this.add(mainBody);
    }

    public VeterinaryClinicView getVeterinaryClinicView() {
        return veterinaryClinicView;
    }
    public PetDataBaseBody getMainBody() {
        return mainBody;
    }

    
}
