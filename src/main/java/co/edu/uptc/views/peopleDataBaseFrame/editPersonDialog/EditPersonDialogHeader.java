package co.edu.uptc.views.peopleDataBaseFrame.editPersonDialog;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;

public class EditPersonDialogHeader extends JPanel{
    private PropertiesService propertiesService;

    public EditPersonDialogHeader(){
        propertiesService = new PropertiesService();
        this.initPanel();
        this.addPersonDialogTitle();
    }

    private void initPanel(){
        this.setBackground(GlobalView.HEADER_BACKGROUND);
        this.setForeground(GlobalView.HEADER_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addPersonDialogTitle(){
        RoundedButton addPersonDialogTitle = new RoundedButton("Agregar Persona", 20);
        addPersonDialogTitle.setBounds(100, 10, 400, 80);
        addPersonDialogTitle.setFont(new Font("Semi_Bold", 1, 32));
        addPersonDialogTitle.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        ImageIcon vaccineIcon = new ImageIcon(propertiesService.getKeyValue("UserIconPath"));
        addPersonDialogTitle.setIcon(vaccineIcon);
        addPersonDialogTitle.setContentAreaFilled(false);
        this.add(addPersonDialogTitle);
    }
}
