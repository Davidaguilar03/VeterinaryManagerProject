package co.edu.uptc.views.veterinaryClinicMainFrame.sortByVaccineExpireDateDialog;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.PlainDocument;

import co.edu.uptc.utilities.NumericDocumentFilter;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;
@Getter
public class SortByVaccineExpireDateDialogBody extends JPanel{
    private SortByVaccineExpireDateDialogView sortByVaccineExpireDateDialogView;
    private JTextField txtSortDays;

    public SortByVaccineExpireDateDialogBody(SortByVaccineExpireDateDialogView sortByVaccineExpireDateDialogView){
        this.sortByVaccineExpireDateDialogView=sortByVaccineExpireDateDialogView;
        this.initPanel();
        this.createLblSortDays();
        this.createTextFileSortDays();
    }

    public void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void createLblSortDays(){
        JLabel lblSortDays = new JLabel("Dias Restantes a Vencer: ");
        lblSortDays.setBounds(70, 15, 300, 25);
        lblSortDays.setFont(new Font("Semi_Bold", 1, 16));
        this.add(lblSortDays);
    }

    private void createTextFileSortDays() {
        txtSortDays = new JTextField("Ingrese los Dias Restantes a Vencer");
        txtSortDays.setBounds(70, 45, 300, 40);
        txtSortDays.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        ((PlainDocument) txtSortDays.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        txtSortDays.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtSortDays.getText().equals("Ingrese los Dias Restantes a Vencer")) {
                    txtSortDays.setText("");
                    txtSortDays.setForeground(GlobalView.TEXT_COLOR);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtSortDays.getText().isEmpty()) {
                    txtSortDays.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
                    txtSortDays.setText("Ingrese los Dias Restantes a Vencer");
                }
            }
        });
        this.add(txtSortDays);
    }
}
