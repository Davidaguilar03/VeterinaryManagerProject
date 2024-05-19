package co.edu.uptc.views.veterinaryClinicMainFrame.addAppointmentDialog;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;

public class AddApointmentDialogView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;
    private AddApointmentDialogBody addApointmentDialogBody;
    private AddApointmentDialogFooter addApointmentDialogFooter;
    private PropertiesService propertiesService;

    public AddApointmentDialogView(VeterinaryClinicView veterinaryClinicView){
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
        this.setSize(800,768);
        this.setTitle("Agregar Cita");
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    private void createMainHeader(){
        AddApointmentDialogHeader addApointmentDialogHeader = new AddApointmentDialogHeader();
        this.add(addApointmentDialogHeader, BorderLayout.NORTH);
    }

    private void createMainBody(){
        addApointmentDialogBody = new AddApointmentDialogBody(veterinaryClinicView);
        this.add(addApointmentDialogBody);
    }

    private void createMainFooter(){
        addApointmentDialogFooter = new AddApointmentDialogFooter(veterinaryClinicView);
        this.add(addApointmentDialogFooter,BorderLayout.SOUTH); 
    }
    
}
