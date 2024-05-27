package co.edu.uptc.views.veterinaryClinicMainFrame.addAppointmentDialog;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;

public class AddAppointmentDialogHeader extends JPanel {
    private PropertiesService propertiesService;

    public AddAppointmentDialogHeader(){
        propertiesService = new PropertiesService();
        this.initPanel();
        this.addApointmentDialogTitle();
    }

   
    private void initPanel(){
        this.setBackground(GlobalView.HEADER_BACKGROUND);
        this.setForeground(GlobalView.HEADER_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addApointmentDialogTitle() {
        RoundedButton addApointmentDialogTitle = new RoundedButton("Agregar Cita", 20);
        addApointmentDialogTitle.setBounds(200, 10, 400, 80);
        addApointmentDialogTitle.setFont(new Font("Semi_Bold", 1, 40));
        ;
        addApointmentDialogTitle.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        ImageIcon vaccineIcon = new ImageIcon(propertiesService.getKeyValue("CalendarIconPath"));
        addApointmentDialogTitle.setIcon(vaccineIcon);
        addApointmentDialogTitle.setContentAreaFilled(false);
        this.add(addApointmentDialogTitle);
    }

}
