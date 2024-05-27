package co.edu.uptc.views.veterinaryClinicMainFrame.appointmentInformationDialog;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;

public class AppointmentInformationDialogHeader extends JPanel{
    private PropertiesService propertiesService;

    public AppointmentInformationDialogHeader(){
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
        RoundedButton addApointmentDialogTitle = new RoundedButton("Informacion de la Cita", 20);
        addApointmentDialogTitle.setBounds(150, 10, 500, 80);
        addApointmentDialogTitle.setFont(new Font("Semi_Bold", 1, 32));
        ;
        addApointmentDialogTitle.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        ImageIcon vaccineIcon = new ImageIcon(propertiesService.getKeyValue("CalendarIconPath"));
        addApointmentDialogTitle.setIcon(vaccineIcon);
        addApointmentDialogTitle.setContentAreaFilled(false);
        this.add(addApointmentDialogTitle);
    }
}
