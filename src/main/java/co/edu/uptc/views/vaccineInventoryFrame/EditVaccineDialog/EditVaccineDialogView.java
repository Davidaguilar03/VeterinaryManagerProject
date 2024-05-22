package co.edu.uptc.views.vaccineInventoryFrame.EditVaccineDialog;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Image;

import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.vaccineInventoryFrame.vaccineInventoryMainFrame.VaccineInventoryView;
import lombok.Getter;

@Getter
public class EditVaccineDialogView extends JDialog{
    private VaccineInventoryView vaccineInventoryView;
    private EditVaccineDialogBody editVaccineDialogBody;
    private EditVaccineDialogFooter editVaccineDialogFooter;
    private PropertiesService propertiesService;

    public EditVaccineDialogView(VaccineInventoryView vaccineInventoryView){
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
        this.setTitle("Editar Vacuna");
        this.setLocationRelativeTo(vaccineInventoryView);
        this.setResizable(false);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    private void createMainHeader(){
        EditVaccineDialogHeader editVaccineDialogHeader = new EditVaccineDialogHeader();
        this.add(editVaccineDialogHeader, BorderLayout.NORTH);
    }

    private void createMainBody(){
        editVaccineDialogBody = new EditVaccineDialogBody(this);
        this.add(editVaccineDialogBody);
    }

    private void createMainFooter(){
        editVaccineDialogFooter = new EditVaccineDialogFooter(this);
        this.add(editVaccineDialogFooter,BorderLayout.SOUTH); 
    }
}

