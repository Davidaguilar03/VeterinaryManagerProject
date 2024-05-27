package co.edu.uptc.views.veterinaryClinicMainFrame.sortByDateDialog;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;
import lombok.Getter;
@Getter
public class SortByDateDialogView extends JDialog {
    private VeterinaryClinicView veterinaryClinicView;
    private SortByDateDialogBody sortByDateDialogBody;
    private SortByDateDialogFooter sortByDateDialogFooter;
    private PropertiesService propertiesService;

    public SortByDateDialogView(VeterinaryClinicView veterinaryClinicView){
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
        this.setSize(450,450);
        this.setTitle("Filtrar por Fecha");
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    private void createMainHeader(){
        SortByDateDialogHeader sortByDateDialogHeader = new SortByDateDialogHeader();
        this.add(sortByDateDialogHeader, BorderLayout.NORTH);
    }
    
    private void createMainBody(){
        sortByDateDialogBody = new SortByDateDialogBody(this);
        this.add(sortByDateDialogBody);
    }

    private void createMainFooter(){
        sortByDateDialogFooter = new SortByDateDialogFooter(this);
        this.add(sortByDateDialogFooter,BorderLayout.SOUTH);
    }
}
