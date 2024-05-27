package co.edu.uptc.views.veterinaryClinicMainFrame.sortByPersonDialog;

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
import javax.swing.table.TableColumn;

import co.edu.uptc.pojos.Person;
import co.edu.uptc.utilities.CenterTableCellRenderer;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;

@Getter
public class SortByPersonDialogBody extends JPanel {
    private SortByPersonDialogView sortByPersonDialogView;
    private DefaultTableModel peopleDataBaseTableModel;
    private JTable peopleDataBaseTable;

    public SortByPersonDialogBody(SortByPersonDialogView sortByPersonDialogView) {
        this.sortByPersonDialogView = sortByPersonDialogView;
        this.initPanel();
        this.addPeopleTableHeader();
        this.addPeopleDataBaseTable();
    }

    public void initPanel() {
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addPeopleTableHeader() {
        JLabel headerLabel = new JLabel("Registro de Personas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(300, 20, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addPeopleDataBaseTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_TABLE_COLOR));
        tablePanel.setBounds(10, 10, 765, 250);
        tablePanel.setLayout(null);
        String[] columnNames = {
                "ID.Persona", "Nombre", "Edad", "Tipo de Documento", "Numero de Documento"
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
        peopleDataBaseTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && peopleDataBaseTable.getSelectedRow() != -1) {
                    createSelectedRowPerson();
                }
            }
        });
        TableColumn documentNumberColumn = peopleDataBaseTable.getColumnModel().getColumn(4);
        documentNumberColumn.setPreferredWidth(110);
        TableColumn ageColumn = peopleDataBaseTable.getColumnModel().getColumn(2);
        ageColumn.setPreferredWidth(30);
        JScrollPane scrollPane = new JScrollPane(peopleDataBaseTable);
        scrollPane.setBounds(20, 40, 725, 200);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }

    public void addPerson(Person person) {
        Object[] personData = { person.getId(), person.getName(), person.getAge(), person.getTypeOfDocument(),
                person.getDocumentNumber() };
        peopleDataBaseTableModel.addRow(personData);
    }

    public Person createSelectedRowPerson() {
        Person person = new Person();
        person.setId((int) peopleDataBaseTableModel.getValueAt(peopleDataBaseTable.getSelectedRow(), 0));
        person.setName((String) peopleDataBaseTableModel.getValueAt(peopleDataBaseTable.getSelectedRow(), 1));
        person.setAge((int) peopleDataBaseTableModel.getValueAt(peopleDataBaseTable.getSelectedRow(), 2));
        person.setTypeOfDocument((String) peopleDataBaseTableModel.getValueAt(peopleDataBaseTable.getSelectedRow(), 3));
        person.setDocumentNumber((int) peopleDataBaseTableModel.getValueAt(peopleDataBaseTable.getSelectedRow(), 4));
        return person;
    }
}
