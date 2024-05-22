package co.edu.uptc.views.vaccineInventoryFrame.vaccineInventoryMainFrame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.vaccineInventoryFrame.EditVaccineDialog.EditVaccineDialogView;
import co.edu.uptc.views.vaccineInventoryFrame.addVaccineDialog.AddVaccineDialogView;

public class VaccineInventoryAside extends JPanel{
    private VaccineInventoryView vaccineInventoryView;
    private RoundedButton deleteVaccineBtn;
    private RoundedButton editVaccineBtn;

    public VaccineInventoryAside(VaccineInventoryView vaccineInventoryView){
        this.vaccineInventoryView=vaccineInventoryView;
        this.initPanel();
        this.addCreateVaccineBtn();
        this.addDeleteVaccineBtn();
        this.addEditVaccineBtn();
    }

    public void enableDeleteVaccineBtn(boolean value) {   
        deleteVaccineBtn.setEnabled(value);
     }

    public void enableEditVaccineBtn(boolean value){
        editVaccineBtn.setEnabled(value);
    }

    private void initPanel(){
        this.setBackground(GlobalView.ASIDE_BACKGROUND);
        this.setForeground(GlobalView.ASIDE_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(298,0));
        this.setBorder(BorderFactory.createMatteBorder(0,1,1,1,GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }
    private void addCreateVaccineBtn(){
        RoundedButton createVaccineBtn = new RoundedButton("Agregar Vacuna", 20);
        createVaccineBtn.setBounds(77, 30, 145, 52);
        createVaccineBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createVaccineBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createVaccineBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               createAddVaccineDialog();
            }
        });
        this.add(createVaccineBtn);
    }

    private void addDeleteVaccineBtn(){
        deleteVaccineBtn = new RoundedButton("Eliminar Vacuna", 20);
        deleteVaccineBtn.setBounds(77, 115, 145, 52);
        deleteVaccineBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        deleteVaccineBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        deleteVaccineBtn.setEnabled(false);
        deleteVaccineBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               vaccineInventoryView.getVaccineInventoryBody().deleteVaccine();
            }
        });
        this.add(deleteVaccineBtn);
    }

    private void addEditVaccineBtn(){
        editVaccineBtn = new RoundedButton("Editar Vacuna", 20);
        editVaccineBtn.setBounds(77, 195, 145, 52);
        editVaccineBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        editVaccineBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        editVaccineBtn.setEnabled(false);
        editVaccineBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               createEditVaccineDialog();
            }
        });
        this.add(editVaccineBtn);
    }
    private void createAddVaccineDialog(){
        AddVaccineDialogView addVaccineDialogView = new AddVaccineDialogView(vaccineInventoryView);
        addVaccineDialogView.begin();
    }
    
    private void createEditVaccineDialog(){
        EditVaccineDialogView editVaccineDialogView = new EditVaccineDialogView(vaccineInventoryView);
        editVaccineDialogView.begin();
    }
}
