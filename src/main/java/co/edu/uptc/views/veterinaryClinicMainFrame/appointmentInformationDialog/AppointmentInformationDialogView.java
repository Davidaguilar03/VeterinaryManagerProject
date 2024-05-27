package co.edu.uptc.views.veterinaryClinicMainFrame.appointmentInformationDialog;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import co.edu.uptc.pojos.Appointment;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;
import lombok.Getter;
@Getter
public class AppointmentInformationDialogView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;
    private AppointmentInformationDialogBody appointmentInformationDialogBody;
    private AppointmentInformationDialogFooter appointmentInformationDialogFooter;
    private PropertiesService propertiesService;

    public AppointmentInformationDialogView(VeterinaryClinicView veterinaryClinicView){
        super(veterinaryClinicView, true);
        this.veterinaryClinicView = veterinaryClinicView;
        propertiesService = new PropertiesService();
        this.initDialog();
        this.createMainHeader();
        this.createMainBody();
        this.createMainFoooter();
        this.loadAppointmentInformationData();
    }

    public void begin(){
        this.setVisible(true);
    }

    private void initDialog(){
        this.setLayout(new BorderLayout());
        this.setSize(800,600);
        this.setTitle("Información de La Cita");
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    private void loadAppointmentInformationData(){
        Appointment appointment = veterinaryClinicView.getVeterinaryClinicBody().searchAppointmentById(veterinaryClinicView.getVeterinaryClinicBody().selectedAppointmentId());
        appointmentInformationDialogBody.loadAppointmentInformation(appointment);
    }

    private void createMainHeader(){
        AppointmentInformationDialogHeader appointmentInformationDialogHeader = new AppointmentInformationDialogHeader();
        this.add(appointmentInformationDialogHeader, BorderLayout.NORTH);
    }

    private void createMainBody(){
        appointmentInformationDialogBody = new AppointmentInformationDialogBody(veterinaryClinicView);
        this.add(appointmentInformationDialogBody); 
    }

    private void createMainFoooter(){
        appointmentInformationDialogFooter = new AppointmentInformationDialogFooter();
        this.add(appointmentInformationDialogFooter, BorderLayout.SOUTH);
    }

}
