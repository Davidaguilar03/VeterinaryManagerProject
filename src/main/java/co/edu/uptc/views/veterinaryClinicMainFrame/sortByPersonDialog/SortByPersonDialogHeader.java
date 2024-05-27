package co.edu.uptc.views.veterinaryClinicMainFrame.sortByPersonDialog;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;

public class SortByPersonDialogHeader extends JPanel{

    public SortByPersonDialogHeader(){
        this.initPanel();
        this.addSortByPersonTitle();
    }

    private void initPanel(){
        this.setBackground(GlobalView.HEADER_BACKGROUND);
        this.setForeground(GlobalView.HEADER_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addSortByPersonTitle(){
        RoundedButton addSortByPersonTitle = new RoundedButton("Fitrar Por Persona", 20);
        addSortByPersonTitle.setBounds(110, 10, 370, 80);
        addSortByPersonTitle.setFont(new Font("Semi_Bold", 1, 32));
        addSortByPersonTitle.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        this.add(addSortByPersonTitle);
    }
}
