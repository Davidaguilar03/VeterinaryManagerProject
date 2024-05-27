package co.edu.uptc.views.veterinaryClinicMainFrame.sortByVaccineExpireDateDialog;

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
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;
@Getter
public class SortByVaccineExpireDateDialogFooter extends JPanel{
    private SortByVaccineExpireDateDialogView sortByVaccineExpireDateDialogView;

    public SortByVaccineExpireDateDialogFooter(SortByVaccineExpireDateDialogView sortByVaccineExpireDateDialogView){
        this.sortByVaccineExpireDateDialogView=sortByVaccineExpireDateDialogView;
        this.initPanel();
        this.addSortByVaccineBtn();
        this.addCancelBtn();
    }

    private void initPanel(){
         this.setBackground(GlobalView.FOOTER_DIALOG_BACKGROUND);
        this.setForeground(GlobalView.FOOTER_TEXT_DIALOG_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1,1,1,1,GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addSortByVaccineBtn(){
        RoundedButton sortByVaccineBtn = new RoundedButton("Filtrar", 20);
        sortByVaccineBtn.setBounds(20, 25, 180, 50);
        sortByVaccineBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        sortByVaccineBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        sortByVaccineBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                sortByVaccine();
                Window window = SwingUtilities.getWindowAncestor(SortByVaccineExpireDateDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(sortByVaccineBtn);
    }

    private void addCancelBtn(){
        RoundedButton cancelBtn = new RoundedButton("Cancelar", 20);
        cancelBtn.setBounds(240, 25, 180, 50);
        cancelBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        cancelBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Window window = SwingUtilities.getWindowAncestor(SortByVaccineExpireDateDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(cancelBtn);
    }

    private void sortByVaccine(){
        int sortDays = Integer.parseInt(sortByVaccineExpireDateDialogView.getSortByVaccineExpireDateDialogBody().getTxtSortDays().getText());
        ArrayList<Appointment> sortAppointments = sortByVaccineExpireDateDialogView.getVeterinaryClinicView().getPresenter().sortByVaccineExpireDate(sortDays);
        sortByVaccineExpireDateDialogView.getVeterinaryClinicView().getVeterinaryClinicBody().cleanTable();
        for (Appointment appointment : sortAppointments) {
            sortByVaccineExpireDateDialogView.getVeterinaryClinicView().getVeterinaryClinicBody().addAppointment(appointment);
        }
    }
}
