package co.edu.uptc.views.vaccineInventoryFrame.EditVaccineDialog;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;

public class EditVaccineDialogHeader extends JPanel {
    private PropertiesService propertiesService;

    public EditVaccineDialogHeader() {
        propertiesService = new PropertiesService();
        this.initPanel();
        this.editVaccineDialogTitle();
    }

    private void initPanel(){
        this.setBackground(GlobalView.HEADER_BACKGROUND);
        this.setForeground(GlobalView.HEADER_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void editVaccineDialogTitle(){
        RoundedButton editVaccineDialogTitle = new RoundedButton("Editar Vacuna", 20);
        editVaccineDialogTitle.setBounds(40, 10, 370, 80);
        editVaccineDialogTitle.setFont(new Font("Semi_Bold", 1, 32));
        editVaccineDialogTitle.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        ImageIcon vaccineIcon = new ImageIcon(propertiesService.getKeyValue("VaccineIconPath"));
        editVaccineDialogTitle.setIcon(vaccineIcon);
        editVaccineDialogTitle.setContentAreaFilled(false);
        this.add(editVaccineDialogTitle);
    }
}
