package co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import co.edu.uptc.interfaces.VeterinaryInterface;
import co.edu.uptc.interfaces.VeterinaryInterface.Presenter;
import co.edu.uptc.pojos.*;
import co.edu.uptc.utilities.PropertiesService;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ArrayList;

public class VeterinaryClinicView extends JFrame implements VeterinaryInterface.View {
    private VeterinaryInterface.Presenter presenter;
    private PropertiesService propertiesService;
    private VeterinaryClinicBody veterinaryClinicBody;
    private VeterinaryClinicHeader veterinaryClinicHeader;

    public VeterinaryClinicView() {
        propertiesService = new PropertiesService();
        this.initFrame();
        this.createVeterinaryClinicHeader();
        this.createVeterinaryClinicAside();
        this.createVeterinaryClinicBody();
    }

    public void begin() {
        this.loadAppointmentsData();
        this.setVisible(true);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                presenter.writeData();
            }
        });
    }

    private void initFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clinica Veterinaria");
        this.setLayout(new BorderLayout());
        this.setSize(1366, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    private void loadAppointmentsData() {
        ArrayList<Appointment> appointments = presenter.getAppointments();
        for (Appointment appointment : appointments) {
            veterinaryClinicBody.addAppointment(appointment);
        }
    }

    private void createVeterinaryClinicHeader() {
        veterinaryClinicHeader = new VeterinaryClinicHeader(this);
        this.add(veterinaryClinicHeader, BorderLayout.NORTH);
    }

    private void createVeterinaryClinicAside() {
        VeterinaryClinicAside veterinaryClinicAside = new VeterinaryClinicAside(this);
        this.add(veterinaryClinicAside, BorderLayout.WEST);
    }

    private void createVeterinaryClinicBody() {
        veterinaryClinicBody = new VeterinaryClinicBody(this);
        this.add(veterinaryClinicBody);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public VeterinaryInterface.Presenter getPresenter() {
        return presenter;
    }
}
