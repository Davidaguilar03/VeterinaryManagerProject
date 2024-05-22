package co.edu.uptc.views.vaccineInventoryFrame.EditVaccineDialog;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.pojos.Vaccine;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;
@Getter
public class EditVaccineDialogBody extends JPanel{
    private EditVaccineDialogView editVaccineDialogView;
    private JTextField txtName;
    private JTextField txtShelfLife;
    
    public EditVaccineDialogBody(EditVaccineDialogView editVaccineDialogView){
        this.editVaccineDialogView = editVaccineDialogView;
        this.initPanel();
    }

    private void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
        this.createLblName();
        this.createTextFileName();
        this.createLblShelfLife();
        this.createTextFileShelfLife();
        this.loadVaccineInformation();
    }

    private void createLblName(){
        JLabel lblName = new JLabel("Nombre: ");
        lblName.setBounds(70, 20, 80, 25);
        lblName.setFont(new Font("Semi_Bold", 1, 16));
        this.add(lblName);
    }

    private void createTextFileName() {
        txtName = new JTextField();
        txtName.setBounds(70, 50, 300, 40);
        txtName.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        this.add(txtName);
    }

    private void createLblShelfLife(){
        JLabel lblShelfLife = new JLabel("Vida Util: ");
        lblShelfLife.setBounds(70, 100, 100, 25);
        lblShelfLife.setFont(new Font("Semi_Bold", 1, 16));
        this.add(lblShelfLife);
    }

    private void createTextFileShelfLife() {
        txtShelfLife = new JTextField();
        txtShelfLife.setBounds(70, 130, 300, 40);
        txtShelfLife.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        this.add(txtShelfLife);
    }

    private void loadVaccineInformation(){
       Vaccine auxVaccine = editVaccineDialogView.getVaccineInventoryView().getVaccineInventoryBody().createSelectedRowVaccine();
        txtName.setText(auxVaccine.getName());
        txtShelfLife.setText(auxVaccine.getShelfLife()+"");
    }
}
