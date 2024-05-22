package co.edu.uptc.views.vaccineInventoryFrame.addVaccineDialog;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.views.GlobalView;
import lombok.Getter;
@Getter
public class AddVaccineDialogBody extends JPanel{
    private AddVaccineDialogView addVaccineDialogView;
    private JTextField txtName;
    private JTextField txtShelfLife;
    
    public AddVaccineDialogBody(AddVaccineDialogView addVaccineDialogView){
        this.addVaccineDialogView = addVaccineDialogView;
        this.initPanel();
    }

    private void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
        this.createLblName();
        this.createTextFileName();
        this.createLblShelfLife();
        this.createTextFileShelfLife();
    }

    private void createLblName(){
        JLabel lblName = new JLabel("Nombre: ");
        lblName.setBounds(70, 20, 80, 25);
        lblName.setFont(new Font("Semi_Bold", 1, 16));
        this.add(lblName);
    }

    private void createTextFileName() {
        txtName = new JTextField("Ingrese el Nombre");
        txtName.setBounds(70, 50, 300, 40);
        txtName.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtName.getText().equals("Ingrese el Nombre")) {
                    txtName.setText("");
                    txtName.setForeground(GlobalView.TEXT_COLOR);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtName.getText().isEmpty()) {
                    txtName.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
                    txtName.setText("Ingrese el Nombre");
                }
            }
        });
        this.add(txtName);
    }

    private void createLblShelfLife(){
        JLabel lblShelfLife = new JLabel("Vida Util: ");
        lblShelfLife.setBounds(70, 100, 100, 25);
        lblShelfLife.setFont(new Font("Semi_Bold", 1, 16));
        this.add(lblShelfLife);
    }

    private void createTextFileShelfLife() {
        txtShelfLife = new JTextField("Ingrese la Duración en Dias");
        txtShelfLife.setBounds(70, 130, 300, 40);
        txtShelfLife.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtShelfLife.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtShelfLife.getText().equals("Ingrese la Duración en Dias")) {
                    txtShelfLife.setText("");
                    txtShelfLife.setForeground(GlobalView.TEXT_COLOR);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtShelfLife.getText().isEmpty()) {
                    txtShelfLife.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
                    txtShelfLife.setText("Ingrese la Duración en Dias");
                }
            }
        });
        this.add(txtShelfLife);
    }
}
