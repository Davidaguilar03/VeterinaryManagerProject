package co.edu.uptc.views.veterinaryClinicMainFrame.addAppointmentDialog;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import co.edu.uptc.pojos.Appointment;
import co.edu.uptc.pojos.Keeper;
import co.edu.uptc.pojos.Person;
import co.edu.uptc.pojos.Pet;
import co.edu.uptc.pojos.Vaccine;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;
import lombok.Getter;

@Getter
public class AddAppointmentDialogFooter extends JPanel{
    private VeterinaryClinicView veterinaryClinicView;
    
    public AddAppointmentDialogFooter(VeterinaryClinicView veterinaryClinicView){
        this.veterinaryClinicView = veterinaryClinicView;
        this.initPanel();
        this.addSaveAppointmentBtn();
        this.addCancelAppointmentBtn();
    }

    private void initPanel() {
        this.setBackground(GlobalView.FOOTER_DIALOG_BACKGROUND);
        this.setForeground(GlobalView.FOOTER_TEXT_DIALOG_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1,1,1,1,GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addSaveAppointmentBtn() {
        RoundedButton createSaveAppointmentBtn = new RoundedButton("Guardar Cita", 20);
        createSaveAppointmentBtn.setBounds(180, 25, 180, 50);
        createSaveAppointmentBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createSaveAppointmentBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createSaveAppointmentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                saveAppointment();
                Window window = SwingUtilities.getWindowAncestor(AddAppointmentDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(createSaveAppointmentBtn);
    }

    private void addCancelAppointmentBtn() {
        RoundedButton createCancelAppointmentBtn = new RoundedButton("Cancelar", 20);
        createCancelAppointmentBtn.setBounds(440, 25, 180, 50);
        createCancelAppointmentBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createCancelAppointmentBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createCancelAppointmentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               Window window = SwingUtilities.getWindowAncestor(AddAppointmentDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(createCancelAppointmentBtn);
    }

    public void saveAppointment(){
        AddAppointmentDialogBody addApointmentDialogBody = veterinaryClinicView.getVeterinaryClinicAside().getAddApointmentDialogView().getAddApointmentDialogBody();
        Person auxPerson = addApointmentDialogBody.createSelectedRowPerson();
        Pet auxPet = addApointmentDialogBody.createSelectedRowPet();
        ArrayList<Vaccine> auxVaccines = addApointmentDialogBody.createSelectedRowVaccines();
        Appointment appointment = new Appointment();
        appointment.setPet(auxPet);
        appointment.setVaccines(auxVaccines);
        appointment.setDate(LocalDate.now());
        Keeper keeper = new Keeper();
        keeper.setPersonId(auxPerson.getId());
        if (auxPet.getKeepers().get(0).getPersonId()==auxPerson.getId()) {
            keeper.setRelationship("(Dueño)");
        }else{
            keeper.setRelationship("(Familiar)");
        }
        appointment.setKeeper(keeper);
        veterinaryClinicView.getPresenter().addAppointment(appointment);
        veterinaryClinicView.loadAppointmentsData();
    }
    
}
