package co.edu.uptc.views.petDataBaseFrame.editPetDialog;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;

public class EditPetDialogHeader extends JPanel{
    private PropertiesService propertiesService;
    

    public EditPetDialogHeader(){
        propertiesService = new PropertiesService();
        this.initPanel();
        this.addPetDialogTitle();
    }

    private void initPanel(){
        this.setBackground(GlobalView.HEADER_BACKGROUND);
        this.setForeground(GlobalView.HEADER_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addPetDialogTitle(){
        RoundedButton addPetDialogTitle = new RoundedButton("Editar Mascota", 20);
        addPetDialogTitle.setBounds(150, 10, 400, 80);
        addPetDialogTitle.setFont(new Font("Semi_Bold", 1, 32));
        addPetDialogTitle.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        ImageIcon petIcon = new ImageIcon(propertiesService.getKeyValue("PetIconPath"));
        addPetDialogTitle.setIcon(petIcon);
        addPetDialogTitle.setContentAreaFilled(false);
        this.add(addPetDialogTitle);
    }
}
