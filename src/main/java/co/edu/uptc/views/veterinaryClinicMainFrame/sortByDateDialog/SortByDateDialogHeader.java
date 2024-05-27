package co.edu.uptc.views.veterinaryClinicMainFrame.sortByDateDialog;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;

import javax.swing.JPanel;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;

public class SortByDateDialogHeader extends JPanel{

    public SortByDateDialogHeader(){
        this.initPanel();
        this.addSortByDateTitle();
    }

    private void initPanel(){
        this.setBackground(GlobalView.HEADER_BACKGROUND);
        this.setForeground(GlobalView.HEADER_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addSortByDateTitle(){
        RoundedButton addSortByDateTitle = new RoundedButton("Fitrar Por Fecha", 20);
        addSortByDateTitle.setBounds(40, 10, 370, 80);
        addSortByDateTitle.setFont(new Font("Semi_Bold", 1, 32));
        addSortByDateTitle.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        this.add(addSortByDateTitle);
    }
}
