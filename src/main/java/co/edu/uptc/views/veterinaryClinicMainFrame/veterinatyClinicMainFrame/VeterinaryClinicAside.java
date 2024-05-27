package co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import javax.swing.JPanel;

import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.veterinaryClinicMainFrame.addAppointmentDialog.AddApointmentDialogView;
import lombok.Getter;
@Getter
public class VeterinaryClinicAside extends JPanel{
    private VeterinaryClinicView veterinaryClinicView;
    private AddApointmentDialogView addApointmentDialogView;

    public VeterinaryClinicAside(VeterinaryClinicView veterinaryClinicView){
        this.veterinaryClinicView=veterinaryClinicView;
        this.initPanel();
        this.addCreateAppointmentBtn();
        this.addSortAppointmentByDateBtn();
        this.addSortAppointmentByPersonBtn();
        this.addSortAppointmentByVaccinesExpireDateBtn();
    }

    private void initPanel(){
        this.setBackground(GlobalView.ASIDE_BACKGROUND);
        this.setForeground(GlobalView.ASIDE_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(298,100));
        this.setBorder(BorderFactory.createMatteBorder(0,1,1,1,GlobalView.BORDER_COLOR));
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER,30,30);
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

    
    private void addSortAppointmentByDateBtn(){
        RoundedButton sortAppointmentByDateBtn = new RoundedButton("Consultar Por Fecha", 20);
        sortAppointmentByDateBtn.setPreferredSize(new Dimension(180, 52));
        sortAppointmentByDateBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        sortAppointmentByDateBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        sortAppointmentByDateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               
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
               
            }
        });
        this.add(sortAppointmentByVaccinesBtn);
    }

    private void createAppointmentDialog(){
        addApointmentDialogView = new AddApointmentDialogView(veterinaryClinicView);
        addApointmentDialogView.begin();
    }
}
