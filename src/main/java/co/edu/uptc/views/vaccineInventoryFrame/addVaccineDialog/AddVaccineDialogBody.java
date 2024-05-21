package co.edu.uptc.views.vaccineInventoryFrame.addVaccineDialog;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.views.GlobalView;

public class AddVaccineDialogBody extends JPanel{
    private AddVaccineDialogView addVaccineDialogView;
    
    public AddVaccineDialogBody(AddVaccineDialogView addVaccineDialogView){
        this.addVaccineDialogView = addVaccineDialogView;
        this.initPanel();
    }

    private void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }


    public AddVaccineDialogView getAddVaccineDialogView() {
        return addVaccineDialogView;
    }

}
