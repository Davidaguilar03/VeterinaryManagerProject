package co.edu.uptc.views.petDataBaseFrame.petDataBaseMainFrame;

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

import co.edu.uptc.pojos.Person;
import co.edu.uptc.pojos.Pet;
import co.edu.uptc.utilities.CenterTableCellRenderer;
import co.edu.uptc.views.GlobalView;


public class PetDataBaseBody extends JPanel {
    private PetDataBaseView petDataBaseView;
    private DefaultTableModel petDataBaseTableModel;
    private JTable petDataBaseTable;

    public PetDataBaseBody(PetDataBaseView petDataBaseView) {
        this.petDataBaseView = petDataBaseView;
        this.initPanel();
        this.addTableHeader();
        this.addPetDataBaseTable();
    }

    private void initPanel() {
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addTableHeader() {
        JLabel headerLabel = new JLabel("Registro de Mascotas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(445, 30, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addPetDataBaseTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_TABLE_COLOR));
        tablePanel.setBounds(15, 20, 1015, 455);
        tablePanel.setLayout(null);
        String[] columnNames = {
                "ID.Mascota", "Nombre", "Especie", "Edad", "Raza", "Dueño"
        };
        petDataBaseTableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        petDataBaseTable = new JTable(petDataBaseTableModel);
        petDataBaseTable.setFillsViewportHeight(true);
        petDataBaseTable.getTableHeader().setReorderingAllowed(false);
        petDataBaseTable.getTableHeader().setResizingAllowed(false);
        petDataBaseTable.setDragEnabled(false);
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        for (int i = 0; i < petDataBaseTable
                .getColumnCount(); i++) {
            petDataBaseTable
                    .getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        petDataBaseTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e){
                if (!e.getValueIsAdjusting() && petDataBaseTable.getSelectedRow() != -1) {  
                    //petDataBaseView.setPetStatus(createSelectedRowPet());                                   
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(petDataBaseTable);
        scrollPane.setBounds(24, 40, 970, 400);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }

    public Person searchPersonByid(int id) {
        return petDataBaseView.getVeterinaryClinicView().getPresenter().searchPersonById(id);
    }

    public void addPet(Pet pet) {
        Object[] petData = { pet.getId(), pet.getName(), pet.getSpecies(), pet.getAge(), pet.getBreed(),
                this.searchPersonByid(pet.getOwner().getPersonId()).getName() };
        petDataBaseTableModel.addRow(petData);
    }

    // public Pet createSelectedRowPet(){
    //     Pet pet = new Pet();
    //     pet.setId((int)petDataBaseTableModel.getValueAt(petDataBaseTable.getSelectedRow(), 0));
    // }

    public void cleanTable(){
        petDataBaseTableModel.setRowCount(0);
    }
}
