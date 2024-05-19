package co.edu.uptc.views.vaccineInventoryFrame.vaccineInventoryMainFrame;

import javax.swing.JDialog;

import co.edu.uptc.pojos.*;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class VaccineInventoryView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;
    private VaccineInventoryBody mainBody;

    public VaccineInventoryView(VeterinaryClinicView veterinaryClinicView){
        super(veterinaryClinicView,true);
        this.veterinaryClinicView=veterinaryClinicView;
        this.initFrame();
        this.createMainHeader();
        this.createMainAside();
        this.createMainBody();
    }
    public void begin(){
        this.loadVaccineData();
        this.setVisible(true);
    }

    private void initFrame(){
        this.setTitle("Clinica Veterinaria");
        this.setLayout(new BorderLayout());
        this.setSize(1366,768);
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
    }

    private void loadVaccineData(){
        ArrayList<Vaccine> vaccines = veterinaryClinicView.getPresenter().getVaccines();
        for (Vaccine vaccine : vaccines) {
            mainBody.addVaccine(vaccine);
        }
    }


    private void createMainHeader(){
        VaccineInventoryHeader mainHeader = new VaccineInventoryHeader();
        this.add(mainHeader, BorderLayout.NORTH);
    }

    private void createMainAside(){
        VaccineInventoryAside mainAside = new VaccineInventoryAside(veterinaryClinicView);
        this.add(mainAside, BorderLayout.WEST);
    }

    private void createMainBody(){
        mainBody = new VaccineInventoryBody(veterinaryClinicView);
        this.add(mainBody);
    }

    public VeterinaryClinicView getVeterinaryClinicView() {
        return veterinaryClinicView;
    }
    
}
