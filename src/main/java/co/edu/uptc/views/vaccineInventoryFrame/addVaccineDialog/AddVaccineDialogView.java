package co.edu.uptc.views.vaccineInventoryFrame.addVaccineDialog;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Image;

import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.vaccineInventoryFrame.vaccineInventoryMainFrame.VaccineInventoryView;

public class AddVaccineDialogView extends JDialog{
    private VaccineInventoryView vaccineInventoryView;
    private AddVaccineDialogBody addVaccineDialogBody;
    private AddVaccineDialogFooter addVaccineDialogFooter;
    private PropertiesService propertiesService;

    public AddVaccineDialogView(VaccineInventoryView vaccineInventoryView){
        super(vaccineInventoryView,true);
        this.vaccineInventoryView = vaccineInventoryView;
        propertiesService = new PropertiesService();
        this.initDialog();
        this.createMainHeader();
        this.createMainBody();
        this.createMainFooter();
    }
    public void begin(){
        this.setVisible(true);
    }

    private void initDialog(){
        this.setLayout(new BorderLayout());
        this.setSize(450,450);
        this.setTitle("Agregar Vacuna");
        this.setLocationRelativeTo(vaccineInventoryView);
        this.setResizable(false);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    private void createMainHeader(){
        AddVaccineDialogHeader addVaccineDialogHeader = new AddVaccineDialogHeader();
        this.add(addVaccineDialogHeader, BorderLayout.NORTH);
    }

    private void createMainBody(){
        addVaccineDialogBody = new AddVaccineDialogBody(this);
        this.add(addVaccineDialogBody);
    }

    private void createMainFooter(){
        addVaccineDialogFooter = new AddVaccineDialogFooter(this);
        this.add(addVaccineDialogFooter,BorderLayout.SOUTH); 
    }
}

