package co.edu.uptc.views.vaccineInventoryFrame.vaccineInventoryMainFrame;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import co.edu.uptc.pojos.*;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;
import lombok.Getter;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ArrayList;
@Getter
public class VaccineInventoryView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;
    private VaccineInventoryBody vaccineInventoryBody;
    private PropertiesService propertiesService;
    private VaccineInventoryAside vaccineInventoryAside;

    public VaccineInventoryView(VeterinaryClinicView veterinaryClinicView){
        super(veterinaryClinicView,true);
        this.veterinaryClinicView=veterinaryClinicView;
        propertiesService = new PropertiesService();
        this.initFrame();
        this.createVaccineInventoryHeader();
        this.createVaccineInventoryAside();
        this.createVaccineInventoryBody();
    }
    public void begin(){
        this.loadVaccineData();
        this.setVisible(true);
    }

    private void initFrame(){
        this.setTitle("Inventario de Vacunas");
        this.setLayout(new BorderLayout());
        this.setSize(1366,768);
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    public void loadVaccineData(){
        ArrayList<Vaccine> vaccines = veterinaryClinicView.getPresenter().getVaccines();
        vaccineInventoryBody.cleanTable();
        for (Vaccine vaccine : vaccines) {
         vaccineInventoryBody.addVaccine(vaccine);
        }
    }
    public void setVaccineStatus(Vaccine vaccine) {
        if (vaccine != null) {
            vaccineInventoryAside.enableDeleteVaccineBtn(true);;
        }
         else {
            vaccineInventoryAside.enableDeleteVaccineBtn(false);;
         }
        }

    private void createVaccineInventoryHeader(){
        VaccineInventoryHeader vaccineInventoryHeader = new VaccineInventoryHeader();
        this.add(vaccineInventoryHeader, BorderLayout.NORTH);
    }

    private void createVaccineInventoryAside(){
        vaccineInventoryAside = new VaccineInventoryAside(this);
        this.add(vaccineInventoryAside, BorderLayout.WEST);
    }

    private void createVaccineInventoryBody(){
     vaccineInventoryBody = new VaccineInventoryBody(this);
        this.add(vaccineInventoryBody);
    }

}
