package co.edu.uptc.views.peopleDataBaseFrame.editPersonDialog;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import co.edu.uptc.pojos.Person;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;

@Getter
public class EditPersonDialogFooter extends JPanel {
    private EditPersonDialogView editPersonDialogView;

    public EditPersonDialogFooter(EditPersonDialogView editPersonDialogView) {
        this.editPersonDialogView = editPersonDialogView;
        this.initPanel();
        this.addEditPersonBtn();
        this.addCancelPersonBtn();
    }

    private void initPanel() {
        this.setBackground(GlobalView.FOOTER_DIALOG_BACKGROUND);
        this.setForeground(GlobalView.FOOTER_TEXT_DIALOG_BACKGROUND);
        this.setPreferredSize(new Dimension(0, 100));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addEditPersonBtn() {
        RoundedButton createSavePersonBtn = new RoundedButton("Editar Persona", 20);
        createSavePersonBtn.setBounds(100, 25, 180, 50);
        createSavePersonBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createSavePersonBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createSavePersonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editPerson();
                Window window = SwingUtilities.getWindowAncestor(EditPersonDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(createSavePersonBtn);
    }

    private void addCancelPersonBtn() {
        RoundedButton createCancelPersonBtn = new RoundedButton("Cancelar", 20);
        createCancelPersonBtn.setBounds(325, 25, 180, 50);
        createCancelPersonBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createCancelPersonBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createCancelPersonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Window window = SwingUtilities.getWindowAncestor(EditPersonDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(createCancelPersonBtn);
    }

    public void editPerson() {
        EditPersonDialogBody editPersonDialogBody = editPersonDialogView.getEditPersonDialogBody();
        Person auxPerson = editPersonDialogView.getPeopleDataBaseView().getPeopleDataBaseBody().createSelectedRowPerson();
        auxPerson.setName(editPersonDialogBody.getTxtName().getText());
        auxPerson.setAge(Integer.parseInt(editPersonDialogBody.getTxtAge().getText()));
        auxPerson.setTypeOfDocument(editPersonDialogBody.getDocumentTypesOptions().getSelectedItem().toString());
        auxPerson.setDocumentNumber(Integer.parseInt(editPersonDialogBody.getTxtDocumentNumber().getText()));
        editPersonDialogView.getPeopleDataBaseView().getVeterinaryClinicView().getPresenter().editPerson(auxPerson);
        editPersonDialogView.getPeopleDataBaseView().loadPeopleData();
    }
}
