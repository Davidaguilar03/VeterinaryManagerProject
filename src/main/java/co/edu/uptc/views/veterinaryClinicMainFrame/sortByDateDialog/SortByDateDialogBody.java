package co.edu.uptc.views.veterinaryClinicMainFrame.sortByDateDialog;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.views.GlobalView;
import lombok.Getter;
@Getter
public class SortByDateDialogBody extends JPanel{
    private SortByDateDialogView sortByDateDialogView;

    public SortByDateDialogBody(SortByDateDialogView sortByDateDialogView){
        this.sortByDateDialogView = sortByDateDialogView;
        this.initPanel();
    }

    public void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    
}
