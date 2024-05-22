package co.edu.uptc.views.vaccineInventoryFrame.EditVaccineDialog;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import co.edu.uptc.pojos.Vaccine;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;



public class EditVaccineDialogFooter extends JPanel{
    private EditVaccineDialogView editVaccineDialogView;

    public EditVaccineDialogFooter(EditVaccineDialogView editVaccineDialogView){
        this.editVaccineDialogView=editVaccineDialogView;
        this.initPanel();
        this.addEditVaccineBtn();
        this.addCancelVaccineBtn();
    }

    private void initPanel(){
        this.setBackground(GlobalView.FOOTER_DIALOG_BACKGROUND);
        this.setForeground(GlobalView.FOOTER_TEXT_DIALOG_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1,1,1,1,GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addEditVaccineBtn(){
        RoundedButton createEditVaccineBtn = new RoundedButton("Editar Vacuna", 20);
        createEditVaccineBtn.setBounds(20, 25, 180, 50);
        createEditVaccineBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createEditVaccineBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createEditVaccineBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               EditVaccineDialogBody editVaccineDialogBody = editVaccineDialogView.getEditVaccineDialogBody();
               Vaccine auxVaccine = editVaccineDialogView.getVaccineInventoryView().getVaccineInventoryBody().createSelectedRowVaccine();
               auxVaccine.setName(editVaccineDialogBody.getTxtName().getText());
               auxVaccine.setShelfLife(Integer.parseInt(editVaccineDialogBody.getTxtShelfLife().getText()));
               editVaccineDialogView.getVaccineInventoryView().getVeterinaryClinicView().getPresenter().editVaccine(auxVaccine);
               editVaccineDialogView.getVaccineInventoryView().loadVaccineData();
                Window window = SwingUtilities.getWindowAncestor(EditVaccineDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(createEditVaccineBtn);
    }

    private void addCancelVaccineBtn() {
        RoundedButton createCancelVaccineBtn = new RoundedButton("Cancelar", 20);
        createCancelVaccineBtn.setBounds(240, 25, 180, 50);
        createCancelVaccineBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createCancelVaccineBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createCancelVaccineBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Window window = SwingUtilities.getWindowAncestor(EditVaccineDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(createCancelVaccineBtn);
    }

    public EditVaccineDialogView getAddVaccineDialogView() {
        return editVaccineDialogView;
    }

    
}
