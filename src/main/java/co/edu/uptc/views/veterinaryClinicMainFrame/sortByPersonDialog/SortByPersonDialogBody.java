package co.edu.uptc.views.veterinaryClinicMainFrame.sortByPersonDialog;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.views.GlobalView;
import lombok.Getter;
@Getter
public class SortByPersonDialogBody extends JPanel{
    private SortByPersonDialogView sortByPersonDialogView;

    public SortByPersonDialogBody(SortByPersonDialogView sortByPersonDialogView){
        this.sortByPersonDialogView = sortByPersonDialogView;
        this.initPanel();
    }

    public void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }
}
