package co.edu.uptc.views.veterinaryClinicMainFrame.sortByPersonDialog;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import co.edu.uptc.pojos.Appointment;
import co.edu.uptc.pojos.Person;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;
@Getter
public class SortByPersonDialogFooter extends JPanel{
    private SortByPersonDialogView sortByPersonDialogView;

    public SortByPersonDialogFooter(SortByPersonDialogView sortByPersonDialogView){
        this.sortByPersonDialogView = sortByPersonDialogView;
        this.initPanel();
        this.addSortByPersonBtn();
        this.addCancelBtn();
    }

    private void initPanel(){
        this.setBackground(GlobalView.FOOTER_DIALOG_BACKGROUND);
        this.setForeground(GlobalView.FOOTER_TEXT_DIALOG_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1,1,1,1,GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addSortByPersonBtn(){
        RoundedButton sortByPersonBtn = new RoundedButton("Filtrar", 20);
        sortByPersonBtn.setBounds(180, 25, 180, 50);
        sortByPersonBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        sortByPersonBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        sortByPersonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                sortByPerson();
                Window window = SwingUtilities.getWindowAncestor(SortByPersonDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(sortByPersonBtn);
    }

    private void addCancelBtn(){
        RoundedButton cancelBtn = new RoundedButton("Cancelar", 20);
        cancelBtn.setBounds(440, 25, 180, 50);
        cancelBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        cancelBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Window window = SwingUtilities.getWindowAncestor(SortByPersonDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(cancelBtn);
    }

    private void sortByPerson(){
        Person auxPerson = sortByPersonDialogView.getSortByPersonDialogBody().createSelectedRowPerson();
        ArrayList<Appointment>sortAppointments = sortByPersonDialogView.getVeterinaryClinicView().getPresenter().sortByPerson(auxPerson);
        sortByPersonDialogView.getVeterinaryClinicView().getVeterinaryClinicBody().cleanTable();
        for (Appointment appointment : sortAppointments) {
            sortByPersonDialogView.getVeterinaryClinicView().getVeterinaryClinicBody().addAppointment(appointment);
        }
    }
}
