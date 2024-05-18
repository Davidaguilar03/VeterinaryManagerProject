package co.edu.uptc.views.vaccineInventoryFrame.vaccineInventoryMainFrame;

import javax.swing.JDialog;

import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;

import java.awt.BorderLayout;

public class VaccineInventoryView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;

    public VaccineInventoryView(VeterinaryClinicView veterinaryClinicView){
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
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
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
        VaccineInventoryBody mainBody = new VaccineInventoryBody(veterinaryClinicView);
        this.add(mainBody);
    }

    public VeterinaryClinicView getVeterinaryClinicView() {
        return veterinaryClinicView;
    }
    
}
