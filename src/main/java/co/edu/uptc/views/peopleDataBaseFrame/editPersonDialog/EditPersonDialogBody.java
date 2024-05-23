package co.edu.uptc.views.peopleDataBaseFrame.editPersonDialog;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

import co.edu.uptc.pojos.Person;
import co.edu.uptc.utilities.NumericDocumentFilter;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;

@Getter
public class EditPersonDialogBody extends JPanel {
    private EditPersonDialogView editPersonDialogView;
    private JTextField txtName;
    private JTextField txtAge;
    private JComboBox<String> documentTypesOptions;
    private JTextField txtDocumentNumber;

    public EditPersonDialogBody(EditPersonDialogView editPersonDialogView) {
        this.editPersonDialogView = editPersonDialogView;
        this.initPanel();
    }

    private void initPanel() {
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
        this.createLblName();
        this.createTextFileName();
        this.createLblAge();
        this.createTextFileAge();
        this.createLblDocumentType();
        this.createTextFileDocumentType();
        this.createLblDocumentNumber();
        this.createTextFileDocumentNumber();
        this.loadPersonInformation();
    }

    private void createLblName() {
        JLabel lblName = new JLabel("Nombre: ");
        lblName.setBounds(30, 20, 80, 25);
        lblName.setFont(new Font("Semi_Bold", 1, 16));
        this.add(lblName);
    }

    private void createTextFileName() {
        txtName = new JTextField("Ingrese el Nombre");
        txtName.setBounds(30, 50, 250, 40);
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

    private void createLblAge() {
        JLabel lblAge = new JLabel("Edad: ");
        lblAge.setBounds(320, 20, 80, 25);
        lblAge.setFont(new Font("Semi_Bold", 1, 16));
        this.add(lblAge);
    }

    private void createTextFileAge() {
        txtAge = new JTextField("Ingrese la Edad");
        txtAge.setBounds(320, 50, 250, 40);
        txtAge.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        ((PlainDocument) txtAge.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        txtAge.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtAge.getText().equals("Ingrese la Edad")) {
                    txtAge.setText("");
                    txtAge.setForeground(GlobalView.TEXT_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtAge.getText().isEmpty()) {
                    txtAge.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
                    txtAge.setText("Ingrese la Edad");
                }
            }
        });
        this.add(txtAge);
    }

    private void createLblDocumentType() {
        JLabel lblDocumentType = new JLabel("Tipo de Documento: ");
        lblDocumentType.setBounds(30, 120, 180, 25);
        lblDocumentType.setFont(new Font("Semi_Bold", 1, 16));
        this.add(lblDocumentType);
    }

    private void createTextFileDocumentType() {
        String[] documentTypes = { "Cedula de Ciudadania", "Pasaporte", "Targeta de Identidad", "Registro Civil" };
        documentTypesOptions = new JComboBox<>(documentTypes);
        documentTypesOptions.setBounds(30, 150, 250, 40);
        this.add(documentTypesOptions);
    }

    private void createLblDocumentNumber() {
        JLabel lblDocumentNumber = new JLabel("Numero de Documento: ");
        lblDocumentNumber.setBounds(320, 120, 200, 25);
        lblDocumentNumber.setFont(new Font("Semi_Bold", 1, 16));
        this.add(lblDocumentNumber);
    }

    private void createTextFileDocumentNumber() {
        txtDocumentNumber = new JTextField("Ingrese el Numero de Documento");
        txtDocumentNumber.setBounds(320, 150, 250, 40);
        txtDocumentNumber.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        ((PlainDocument) txtDocumentNumber.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        txtDocumentNumber.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtDocumentNumber.getText().equals("Ingrese el Numero de Documento")) {
                    txtDocumentNumber.setText("");
                    txtDocumentNumber.setForeground(GlobalView.TEXT_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtDocumentNumber.getText().isEmpty()) {
                    txtDocumentNumber.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
                    txtDocumentNumber.setText("Ingrese el Numero de Documento");
                }
            }
        });
        this.add(txtDocumentNumber);
    }

    private void loadPersonInformation(){
        Person auxPerson = editPersonDialogView.getPeopleDataBaseView().getPeopleDataBaseBody().createSelectedRowPerson();
        txtName.setText(auxPerson.getName());
        txtAge.setText(auxPerson.getAge()+"");
        documentTypesOptions.setSelectedItem(auxPerson.getTypeOfDocument());
        txtDocumentNumber.setText(auxPerson.getDocumentNumber()+"");
    }

}
