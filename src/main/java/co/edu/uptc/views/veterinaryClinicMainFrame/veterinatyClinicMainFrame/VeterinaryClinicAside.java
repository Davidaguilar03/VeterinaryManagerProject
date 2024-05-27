package co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;

import javax.swing.JPanel;

import co.edu.uptc.pojos.Appointment;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.veterinaryClinicMainFrame.addAppointmentDialog.AddAppointmentDialogView;
import co.edu.uptc.views.veterinaryClinicMainFrame.appointmentInformationDialog.AppointmentInformationDialogView;
import co.edu.uptc.views.veterinaryClinicMainFrame.sortByDateDialog.SortByDateDialogView;
import co.edu.uptc.views.veterinaryClinicMainFrame.sortByPersonDialog.SortByPersonDialogView;
import co.edu.uptc.views.veterinaryClinicMainFrame.sortByVaccineExpireDateDialog.SortByVaccineExpireDateDialogView;
import lombok.Getter;
@Getter
public class VeterinaryClinicAside extends JPanel{
    private VeterinaryClinicView veterinaryClinicView;
    private AddAppointmentDialogView addApointmentDialogView;
    private RoundedButton appointmentInformationBtn;

    public VeterinaryClinicAside(VeterinaryClinicView veterinaryClinicView){
        this.veterinaryClinicView=veterinaryClinicView;
        this.initPanel();
        this.addCreateAppointmentBtn();
        this.addAppointmentInfomationBtn();
        this.addSortAppointmentByDateBtn();
        this.addSortAppointmentByPersonBtn();
        this.addSortAppointmentByVaccinesExpireDateBtn();
        this.addCleanSortBtn();
    }

    public void enableAppointmentInformationBtn(Boolean value){
        appointmentInformationBtn.setEnabled(value);
    }

    private void initPanel(){
        this.setBackground(GlobalView.ASIDE_BACKGROUND);
        this.setForeground(GlobalView.ASIDE_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(298,100));
        this.setBorder(BorderFactory.createMatteBorder(0,1,1,1,GlobalView.BORDER_COLOR));
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER,25,25);
        this.setLayout(flowLayout);
    }
    private void addCreateAppointmentBtn(){
        RoundedButton createAppointmentBtn = new RoundedButton("Agregar Cita", 20);
        createAppointmentBtn.setPreferredSize(new Dimension(180, 52));
        createAppointmentBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createAppointmentBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createAppointmentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                createAppointmentDialog();
            }
        });
        this.add(createAppointmentBtn);
    }

    private void addAppointmentInfomationBtn(){
        appointmentInformationBtn = new RoundedButton("Informacion de la Cita", 20);
        appointmentInformationBtn.setPreferredSize(new Dimension(180, 52));
        appointmentInformationBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        appointmentInformationBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        appointmentInformationBtn.setEnabled(false);
        appointmentInformationBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                createAppointmentInfomationDialog();
            }
        });
        this.add(appointmentInformationBtn);
    }
    
    private void addSortAppointmentByDateBtn(){
        RoundedButton sortAppointmentByDateBtn = new RoundedButton("Consultar Por Fecha", 20);
        sortAppointmentByDateBtn.setPreferredSize(new Dimension(180, 52));
        sortAppointmentByDateBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        sortAppointmentByDateBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        sortAppointmentByDateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               createSortByDateDialog();
            }
        });
        this.add(sortAppointmentByDateBtn);
    }
    private void addSortAppointmentByPersonBtn(){
        RoundedButton sortAppointmentByPersonBtn = new RoundedButton("<html>Consultar Por<br/>Responsable</html>", 20);
        sortAppointmentByPersonBtn.setPreferredSize(new Dimension(180, 52));
        sortAppointmentByPersonBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        sortAppointmentByPersonBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        sortAppointmentByPersonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               createSortByPersonDialog();
            }
        });
        this.add(sortAppointmentByPersonBtn);
    }
    private void addSortAppointmentByVaccinesExpireDateBtn(){
        RoundedButton sortAppointmentByVaccinesBtn = new RoundedButton("<html>Consultar Vacunas<br/>Proximas a Caducar</html>", 20);
        sortAppointmentByVaccinesBtn.setPreferredSize(new Dimension(180, 52));
        sortAppointmentByVaccinesBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        sortAppointmentByVaccinesBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        sortAppointmentByVaccinesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               createSortByVaccineExpireDate();
            }
        });
        this.add(sortAppointmentByVaccinesBtn);
    }

    private void addCleanSortBtn(){
        RoundedButton sortAppointmentByVaccinesBtn = new RoundedButton("Limpiar Consultas", 20);
        sortAppointmentByVaccinesBtn.setPreferredSize(new Dimension(180, 52));
        sortAppointmentByVaccinesBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        sortAppointmentByVaccinesBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        sortAppointmentByVaccinesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               cleanSort();
            }
        });
        this.add(sortAppointmentByVaccinesBtn);
    }

    private void cleanSort(){
        ArrayList<Appointment> allAppointments = veterinaryClinicView.getPresenter().getAppointments();
        veterinaryClinicView.getVeterinaryClinicBody().cleanTable();
        for (Appointment appointment : allAppointments) {
            veterinaryClinicView.getVeterinaryClinicBody().addAppointment(appointment);
        }
    }

    private void createAppointmentDialog(){
        addApointmentDialogView = new AddAppointmentDialogView(veterinaryClinicView);
        addApointmentDialogView.begin();
    }

    private void createAppointmentInfomationDialog(){
        AppointmentInformationDialogView appointmentInformationDialogView = new AppointmentInformationDialogView(veterinaryClinicView);
        appointmentInformationDialogView.begin();
    }

    private void createSortByDateDialog(){
        SortByDateDialogView sortByDateDialogView = new SortByDateDialogView(veterinaryClinicView);
        sortByDateDialogView.begin();
    }

    private void createSortByPersonDialog(){
        SortByPersonDialogView sortByPersonDialogView = new SortByPersonDialogView(veterinaryClinicView);
        sortByPersonDialogView.begin();
    }

    private void createSortByVaccineExpireDate(){
        SortByVaccineExpireDateDialogView sortByVaccineExpireDateDialogView = new SortByVaccineExpireDateDialogView(veterinaryClinicView);
        sortByVaccineExpireDateDialogView.begin();
    }

}
