package co.edu.uptc.views.veterinaryClinicMainFrame.addAppointmentDialog;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;

public class AddApointmentDialogBody extends JPanel{
    private VeterinaryClinicView veterinaryClinicView;

    public AddApointmentDialogBody(VeterinaryClinicView veterinaryClinicView){
        this.veterinaryClinicView=veterinaryClinicView;
        this.initPanel();
    }

    public void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }
}
