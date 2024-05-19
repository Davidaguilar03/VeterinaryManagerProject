package co.edu.uptc.views.veterinaryClinicMainFrame.addAppointmentDialog;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;

public class AddApointmentDialogFooter extends JPanel{
    private VeterinaryClinicView veterinaryClinicView;
    
    public AddApointmentDialogFooter(VeterinaryClinicView veterinaryClinicView){
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
               
            }
        });
        this.add(createCancelAppointmentBtn);
    }

    public VeterinaryClinicView getVeterinaryClinicView() {
        return veterinaryClinicView;
    }
    
}
