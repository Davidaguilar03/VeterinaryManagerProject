package co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import javax.swing.JPanel;

import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;

public class VeterinaryClinicAside extends JPanel{
    private VeterinaryClinicView veterinaryClinicView;

    public VeterinaryClinicAside(VeterinaryClinicView veterinaryClinicView){
        this.veterinaryClinicView=veterinaryClinicView;
        this.initPanel();
        this.addCreateAppointmentBtn();
        this.addDeleteAppointmentBtn();
        this.addSortAppointmentByDateBtn();
        this.addSortAppointmentByPersonBtn();
        this.addSortAppointmentByVaccinesExpireDateBtn();
    }

    private void initPanel(){
        this.setBackground(GlobalView.ASIDE_BACKGROUND);
        this.setForeground(GlobalView.ASIDE_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(298,0));
        this.setBorder(BorderFactory.createMatteBorder(0,1,1,1,Color.black));
        this.setLayout(null);
    }
    private void addCreateAppointmentBtn(){
        RoundedButton createAppointmentBtn = new RoundedButton("Agregar Cita", 20);
        createAppointmentBtn.setBounds(77, 30, 145, 52);
        createAppointmentBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createAppointmentBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createAppointmentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               
            }
        });
        this.add(createAppointmentBtn);
    }

    private void addDeleteAppointmentBtn(){
        RoundedButton deleteAppointmentBtn = new RoundedButton("Eliminar Cita", 20);
        deleteAppointmentBtn.setBounds(77, 115, 145, 52);
        deleteAppointmentBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        deleteAppointmentBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        deleteAppointmentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               
            }
        });
        this.add(deleteAppointmentBtn);
    }
    private void addSortAppointmentByDateBtn(){
        RoundedButton sortAppointmentByDateBtn = new RoundedButton("Consultar Por Fecha", 20);
        sortAppointmentByDateBtn.setBounds(49, 200, 200, 52);
        sortAppointmentByDateBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        sortAppointmentByDateBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        sortAppointmentByDateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               
            }
        });
        this.add(sortAppointmentByDateBtn);
    }
    private void addSortAppointmentByPersonBtn(){
        RoundedButton sortAppointmentByPersonBtn = new RoundedButton("Consultar Por Responsable", 20);
        sortAppointmentByPersonBtn.setBounds(22, 285, 250, 52);
        sortAppointmentByPersonBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        sortAppointmentByPersonBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        sortAppointmentByPersonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               
            }
        });
        this.add(sortAppointmentByPersonBtn);
    }
    private void addSortAppointmentByVaccinesExpireDateBtn(){
        RoundedButton sortAppointmentByVaccinesBtn = new RoundedButton("<html>Consultar Vacunas<br/>Proximas a Caducar</html>", 20);
        sortAppointmentByVaccinesBtn.setBounds(46, 370, 200, 85);
        sortAppointmentByVaccinesBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        sortAppointmentByVaccinesBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        sortAppointmentByVaccinesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               
            }
        });
        this.add(sortAppointmentByVaccinesBtn);
    }

    public VeterinaryClinicView getVeterinaryClinicView() {
        return veterinaryClinicView;
    }
}
