package co.edu.uptc.views.veterinaryClinicMainFrame.appointmentInformationDialog;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;
import lombok.Getter;

@Getter
public class AppointmentInformationDialogBody extends JPanel{
    private VeterinaryClinicView veterinaryClinicView;
    private DefaultTableModel vaccineTableModel;
    private JTable vaccinesTable;

    public AppointmentInformationDialogBody(VeterinaryClinicView veterinaryClinicView){
        this.veterinaryClinicView=veterinaryClinicView;
        this.initPanel();
    }

    private void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }
}
