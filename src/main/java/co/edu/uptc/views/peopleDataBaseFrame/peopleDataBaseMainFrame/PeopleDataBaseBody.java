package co.edu.uptc.views.peopleDataBaseFrame.peopleDataBaseMainFrame;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.pojos.Person;
import co.edu.uptc.utilities.CenterTableCellRenderer;
import co.edu.uptc.views.GlobalView;


public class PeopleDataBaseBody extends JPanel {
    private DefaultTableModel peopleDataBaseTableModel;
    private JTable peopleDataBaseTable;


    public PeopleDataBaseBody(){
        this.initPanel();
        this.addTableHeader();
        this.addPeopleDataBaseTable();
    }

    private void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addTableHeader() {
        JLabel headerLabel = new JLabel("Registro de Personas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(445, 30, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addPeopleDataBaseTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_TABLE_COLOR));
        tablePanel.setBounds(15, 20, 1015, 455);
        tablePanel.setLayout(null);
        String[] columnNames = {
                "ID.Persona", "Nombre","Edad","Tipo de Documento","Numero de Documento"
        };
        peopleDataBaseTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        peopleDataBaseTable = new JTable(peopleDataBaseTableModel);
        peopleDataBaseTable.setFillsViewportHeight(true);
        peopleDataBaseTable.getTableHeader().setReorderingAllowed(false);
        peopleDataBaseTable.getTableHeader().setResizingAllowed(false);
        peopleDataBaseTable.setDragEnabled(false);
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        for (int i = 0; i < peopleDataBaseTable
                .getColumnCount(); i++) {
            peopleDataBaseTable
                    .getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        JScrollPane scrollPane = new JScrollPane(peopleDataBaseTable);
        scrollPane.setBounds(24, 40, 970, 400);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }

    public void addPerson(Person person) {
        Object[] personData = {person.getId(),person.getName(),person.getAge(),person.getTypeOfDocument(),person.getDocumentNumber()};
        peopleDataBaseTableModel.addRow(personData);
    }

}
