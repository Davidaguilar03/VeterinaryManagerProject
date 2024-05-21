package co.edu.uptc.views.vaccineInventoryFrame.addVaccineDialog;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;

public class AddVaccineDialogHeader extends JPanel {
    private PropertiesService propertiesService;

    public AddVaccineDialogHeader() {
        propertiesService = new PropertiesService();
        this.initPanel();
        this.addVaccineDialogTitle();
    }

    private void initPanel(){
        this.setBackground(GlobalView.HEADER_BACKGROUND);
        this.setForeground(GlobalView.HEADER_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addVaccineDialogTitle(){
        RoundedButton addVaccineDialogTitle = new RoundedButton("Agregar Vacuna", 20);
        addVaccineDialogTitle.setBounds(40, 10, 370, 80);
        addVaccineDialogTitle.setFont(new Font("Semi_Bold", 1, 32));
        addVaccineDialogTitle.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        ImageIcon vaccineIcon = new ImageIcon(propertiesService.getKeyValue("VaccineIconPath"));
        addVaccineDialogTitle.setIcon(vaccineIcon);
        addVaccineDialogTitle.setContentAreaFilled(false);
        this.add(addVaccineDialogTitle);
    }
}
