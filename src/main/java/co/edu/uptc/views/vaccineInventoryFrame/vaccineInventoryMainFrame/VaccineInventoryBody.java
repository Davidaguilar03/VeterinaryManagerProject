package co.edu.uptc.views.vaccineInventoryFrame.vaccineInventoryMainFrame;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import co.edu.uptc.pojos.Vaccine;
import co.edu.uptc.utilities.CenterTableCellRenderer;
import co.edu.uptc.views.GlobalView;

public class VaccineInventoryBody extends JPanel {
    private DefaultTableModel vaccineTableModel;
    private JTable vaccinesTable;
    private VaccineInventoryView vaccineInventoryView;

    public VaccineInventoryBody(VaccineInventoryView vaccineInventoryView) {
        this.vaccineInventoryView = vaccineInventoryView;
        this.initPanel();
        this.addTableHeader();
        this.addVaccinesTable();
    }

    private void initPanel() {
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addTableHeader() {
        JLabel headerLabel = new JLabel("Inventario de Vacunas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(445, 30, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addVaccinesTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_TABLE_COLOR));
        tablePanel.setBounds(15, 20, 1015, 455);
        tablePanel.setLayout(null);
        String[] columnNames = {
                "ID.Vacuna", "Nombre", "Duracion(Dias)"
        };
        vaccineTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        vaccinesTable = new JTable(vaccineTableModel);
        vaccinesTable.setFillsViewportHeight(true);
        vaccinesTable.getTableHeader().setReorderingAllowed(false);
        vaccinesTable.getTableHeader().setResizingAllowed(false);
        vaccinesTable.setDragEnabled(false);
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        for (int i = 0; i < vaccinesTable
                .getColumnCount(); i++) {
            vaccinesTable
                    .getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        vaccinesTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e){
                if (!e.getValueIsAdjusting() && vaccinesTable.getSelectedRow() != -1) {  
                    vaccineInventoryView.setVaccineStatus(createSelectedRowVaccine());                                   
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(vaccinesTable);
        scrollPane.setBounds(24, 40, 970, 400);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }

    public void addVaccine(Vaccine vaccine) {
        Object[] vaccineData = { vaccine.getId(), vaccine.getName(), vaccine.getShelfLife() };
        vaccineTableModel.addRow(vaccineData);
    }

    public Vaccine createSelectedRowVaccine(){
        Vaccine vaccine = new Vaccine();
        vaccine.setId((int)vaccineTableModel.getValueAt(vaccinesTable.getSelectedRow(), 0));
        vaccine.setName((String)vaccineTableModel.getValueAt(vaccinesTable.getSelectedRow(), 1));
        vaccine.setShelfLife((int)vaccineTableModel.getValueAt(vaccinesTable.getSelectedRow(),2 ));
        return vaccine;
    }

    public void deleteVaccine(){
        Vaccine vaccine = createSelectedRowVaccine();
        vaccineInventoryView.getVeterinaryClinicView().getPresenter().deleteVaccine(vaccine);
        vaccineTableModel.removeRow(vaccinesTable.getSelectedRow());
        vaccineInventoryView.setVaccineStatus(null);
    }

    public void cleanTable(){
        vaccineTableModel.setRowCount(0);
    }

}
