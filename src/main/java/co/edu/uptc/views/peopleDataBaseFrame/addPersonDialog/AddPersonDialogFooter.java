package co.edu.uptc.views.peopleDataBaseFrame.addPersonDialog;

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



public class AddPersonDialogFooter extends JPanel{
    private AddPersonDialogView addPersonDialogView;

    public AddPersonDialogFooter(AddPersonDialogView addPersonDialogView){
        this.addPersonDialogView=addPersonDialogView;
        this.initPanel();
        this.addSavePersonBtn();
        this.addCancelPersonBtn();
    }

    private void initPanel(){
        this.setBackground(GlobalView.FOOTER_DIALOG_BACKGROUND);
        this.setForeground(GlobalView.FOOTER_TEXT_DIALOG_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1,1,1,1,GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addSavePersonBtn(){
        RoundedButton createSavePersonBtn = new RoundedButton("Guardar Persona", 20);
        createSavePersonBtn.setBounds(100, 25, 180, 50);
        createSavePersonBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createSavePersonBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createSavePersonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //to do
                Window window = SwingUtilities.getWindowAncestor(AddPersonDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(createSavePersonBtn);
    }

    private void addCancelPersonBtn(){
        RoundedButton createCancelPersonBtn = new RoundedButton("Cancelar", 20);
        createCancelPersonBtn.setBounds(325, 25, 180, 50);
        createCancelPersonBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createCancelPersonBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createCancelPersonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Window window = SwingUtilities.getWindowAncestor(AddPersonDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(createCancelPersonBtn);
    }
}
