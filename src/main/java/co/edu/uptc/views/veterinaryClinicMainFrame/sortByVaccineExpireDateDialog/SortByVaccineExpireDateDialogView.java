package co.edu.uptc.views.veterinaryClinicMainFrame.sortByVaccineExpireDateDialog;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Image;

import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;
import lombok.Getter;
@Getter
public class SortByVaccineExpireDateDialogView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;
    private SortByVaccineExpireDateDialogBody sortByVaccineExpireDateDialogBody;
    private SortByVaccineExpireDateDialogFooter sortByVaccineExpireDateDialogFooter;
    private PropertiesService propertiesService;

    public SortByVaccineExpireDateDialogView(VeterinaryClinicView veterinaryClinicView){
        super(veterinaryClinicView,true);
        this.veterinaryClinicView = veterinaryClinicView;
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
        this.setSize(450,350);
        this.setTitle("Filtrar por Vacunas Proximas a Vencer");
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    private void createMainHeader(){
        SortByVaccineExpireDateDialogHeader sortByVaccineExpireDateDialogHeader= new SortByVaccineExpireDateDialogHeader();
        this.add(sortByVaccineExpireDateDialogHeader,BorderLayout.NORTH);
    }

    private void createMainBody(){
        sortByVaccineExpireDateDialogBody = new SortByVaccineExpireDateDialogBody(this);
        this.add(sortByVaccineExpireDateDialogBody);
    }

    private void createMainFooter(){
        sortByVaccineExpireDateDialogFooter = new SortByVaccineExpireDateDialogFooter(this);
        this.add(sortByVaccineExpireDateDialogFooter,BorderLayout.SOUTH);
    }
}
