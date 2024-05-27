package co.edu.uptc.views.veterinaryClinicMainFrame.sortByVaccineExpireDateDialog;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.views.GlobalView;
import lombok.Getter;
@Getter
public class SortByVaccineExpireDateDialogBody extends JPanel{
    private SortByVaccineExpireDateDialogView sortByVaccineExpireDateDialogView;

    public SortByVaccineExpireDateDialogBody(SortByVaccineExpireDateDialogView sortByVaccineExpireDateDialogView){
        this.sortByVaccineExpireDateDialogView=sortByVaccineExpireDateDialogView;
        this.initPanel();
    }

    public void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }
}
