package co.edu.uptc.views.vaccineInventoryFrame.addVaccineDialog;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;



public class AddVaccineDialogFooter extends JPanel{
    private AddVaccineDialogView addVaccineDialogView;

    public AddVaccineDialogFooter(AddVaccineDialogView addVaccineDialogView){
        this.addVaccineDialogView=addVaccineDialogView;
        this.initPanel();
        this.addSaveVaccineBtn();
        this.addCancelVaccineBtn();
    }

    private void initPanel(){
        this.setBackground(GlobalView.FOOTER_DIALOG_BACKGROUND);
        this.setForeground(GlobalView.FOOTER_TEXT_DIALOG_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1,1,1,1,GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addSaveVaccineBtn(){
        RoundedButton createSaveVaccineBtn = new RoundedButton("Guardar Vacuna", 20);
        createSaveVaccineBtn.setBounds(20, 25, 180, 50);
        createSaveVaccineBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createSaveVaccineBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createSaveVaccineBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               
            }
        });
        this.add(createSaveVaccineBtn);
    }

    private void addCancelVaccineBtn() {
        RoundedButton createCancelVaccineBtn = new RoundedButton("Cancelar", 20);
        createCancelVaccineBtn.setBounds(240, 25, 180, 50);
        createCancelVaccineBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createCancelVaccineBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createCancelVaccineBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               
            }
        });
        this.add(createCancelVaccineBtn);
    }

    public AddVaccineDialogView getAddVaccineDialogView() {
        return addVaccineDialogView;
    }

    
}
