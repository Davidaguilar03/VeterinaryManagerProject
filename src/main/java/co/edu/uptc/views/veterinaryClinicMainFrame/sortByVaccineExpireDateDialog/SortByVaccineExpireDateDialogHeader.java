package co.edu.uptc.views.veterinaryClinicMainFrame.sortByVaccineExpireDateDialog;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;

public class SortByVaccineExpireDateDialogHeader extends JPanel {

    public SortByVaccineExpireDateDialogHeader(){
        this.initPanel();
        this.addSortByVaccineTitle();
    }

    private void initPanel(){
        this.setBackground(GlobalView.HEADER_BACKGROUND);
        this.setForeground(GlobalView.HEADER_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }
    
    private void addSortByVaccineTitle(){
        RoundedButton addSortByDateTitle = new RoundedButton("Fitrar Por Vacunas", 20);
        addSortByDateTitle.setBounds(40, 10, 370, 80);
        addSortByDateTitle.setFont(new Font("Semi_Bold", 1, 32));
        addSortByDateTitle.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        this.add(addSortByDateTitle);
    }
}
