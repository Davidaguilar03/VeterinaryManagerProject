package co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.pojos.Appointment;
import co.edu.uptc.pojos.Person;
import co.edu.uptc.utilities.CenterTableCellRenderer;

public class VeterinaryClinicBody extends JPanel {
    private VeterinaryClinicView veterinaryClinicView;
    private DefaultTableModel tableModel;
    private JTable appointmentsTable;
    
    public VeterinaryClinicBody(VeterinaryClinicView veterinaryClinicView){
        this.veterinaryClinicView=veterinaryClinicView;
        initPanel();
        addAppointmentsTable();
        addTableHeader();
    }

    private void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
        this.setLayout(null);
    }

    private void addTableHeader(){
        JLabel headerLabel = new JLabel("Historial de Citas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(445,30, (int)headerDimension.getWidth(), (int)headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addAppointmentsTable(){
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        tablePanel.setBounds(15, 20, 1015, 455);
        tablePanel.setLayout(null);
        String[] columnNames = {
            "ID.Cita","Fecha","Mascota","Especie","Responsable","Información de la Cita"
        };
        tableModel = new DefaultTableModel(columnNames,0) {
            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
          };
        appointmentsTable = new JTable(tableModel);
        appointmentsTable.setFillsViewportHeight(true);
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        for (int i = 0; i < appointmentsTable.getColumnCount(); i++) {
            appointmentsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        JScrollPane scrollPane = new JScrollPane(appointmentsTable);
        scrollPane.setBounds(24, 40, 970, 400);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }
    public Person searchPersonByid(int id){
        return veterinaryClinicView.getPresenter().searchPersonById(id);
    }

    public void addAppointment(Appointment appointment){
        Object[] appointmentData = {appointment.getId(),appointment.getDate().toString(),appointment.getPet().getName(),appointment.getPet().getBreed(),this.searchPersonByid(appointment.getKeeper().getPersonId()).getName(),"Mas Información"};
        tableModel.addRow(appointmentData);
    }

    public VeterinaryClinicView getVeterinaryClinicView() {
        return veterinaryClinicView;
    }

    
}
