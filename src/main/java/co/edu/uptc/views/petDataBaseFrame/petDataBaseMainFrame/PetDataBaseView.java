package co.edu.uptc.views.petDataBaseFrame.petDataBaseMainFrame;

import javax.swing.JDialog;

import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;

import java.awt.BorderLayout;


public class PetDataBaseView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;

    public PetDataBaseView(VeterinaryClinicView veterinaryClinicView){
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
        PetDataBaseHeader mainHeader = new PetDataBaseHeader();
        this.add(mainHeader, BorderLayout.NORTH);
    }

    private void createMainAside(){
        PetDataBaseAside mainAside = new PetDataBaseAside();
        this.add(mainAside, BorderLayout.WEST);
    }

    private void createMainBody(){
        PetDataBaseBody mainBody = new PetDataBaseBody();
        this.add(mainBody);
    }

    public VeterinaryClinicView getVeterinaryClinicView() {
        return veterinaryClinicView;
    }

}
