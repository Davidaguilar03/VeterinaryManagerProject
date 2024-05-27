package co.edu.uptc.views.veterinaryClinicMainFrame.addAppointmentDialog;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import co.edu.uptc.pojos.Keeper;
import co.edu.uptc.pojos.Person;
import co.edu.uptc.pojos.Pet;
import co.edu.uptc.pojos.Vaccine;
import co.edu.uptc.utilities.CenterTableCellRenderer;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;
import lombok.Getter;
@Getter
public class AddApointmentDialogBody extends JPanel {
    private VeterinaryClinicView veterinaryClinicView;
    private DefaultTableModel peopleDataBaseTableModel;
    private JTable peopleDataBaseTable;
    private DefaultTableModel petDataBaseTableModel;
    private JTable petDataBaseTable;
    private DefaultTableModel vaccineTableModel;
    private JTable vaccinesTable;

    public AddApointmentDialogBody(VeterinaryClinicView veterinaryClinicView) {
        this.veterinaryClinicView = veterinaryClinicView;
        this.initPanel();
        this.addPeopleTableHeader();
        this.addPeopleDataBaseTable();
        this.addPetTableHeader();
        this.addPetDataBaseTable();
        this.addVaccineTableHeader();
        this.addVaccinesTable();
    }

    public void initPanel() {
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addPeopleTableHeader() {
        JLabel headerLabel = new JLabel("Registro de Personas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(310, 20, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addPeopleDataBaseTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_TABLE_COLOR));
        tablePanel.setBounds(10, 10, 765, 150);
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
            public void valueChanged(ListSelectionEvent e){
                if (!e.getValueIsAdjusting() && peopleDataBaseTable.getSelectedRow() != -1) {  
                    createSelectedRowPerson();                                   
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(peopleDataBaseTable);
        scrollPane.setBounds(20, 40, 725, 100);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }

    public Person createSelectedRowPerson(){
        Person person = new Person();
        person.setId((int)peopleDataBaseTableModel.getValueAt(peopleDataBaseTable.getSelectedRow(), 0));
        person.setName((String)peopleDataBaseTableModel.getValueAt(peopleDataBaseTable.getSelectedRow(), 1));
        person.setAge((int)peopleDataBaseTableModel.getValueAt(peopleDataBaseTable.getSelectedRow(), 2));
        person.setTypeOfDocument((String)peopleDataBaseTableModel.getValueAt(peopleDataBaseTable.getSelectedRow(), 3));
        person.setDocumentNumber((int)peopleDataBaseTableModel.getValueAt(peopleDataBaseTable.getSelectedRow(), 4));
        return person;
    }

    public void addPerson(Person person) {
        Object[] personData = {person.getId(),person.getName(),person.getAge(),person.getTypeOfDocument(),person.getDocumentNumber()};
        peopleDataBaseTableModel.addRow(personData);
    }

    private void addPetTableHeader() {
        JLabel headerLabel = new JLabel("Registro de Mascotas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(310, 190, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addPetDataBaseTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_TABLE_COLOR));
        tablePanel.setBounds(10, 180, 765, 150);
        tablePanel.setLayout(null);
        String[] columnNames = {
                "ID.Mascota", "Nombre", "Especie", "Edad", "Raza", "Responsable"
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
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && petDataBaseTable.getSelectedRow() != -1) {
                    createSelectedRowPet();
                }
            }
        });
        TableColumn documentNumberColumn = petDataBaseTable.getColumnModel().getColumn(5);
        documentNumberColumn.setPreferredWidth(200);
        JScrollPane scrollPane = new JScrollPane(petDataBaseTable);
        scrollPane.setBounds(20, 40, 725, 100);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }

    public void addPet(Pet pet) {
        Object[] petData = { pet.getId(), pet.getName(), pet.getSpecies(), pet.getAge(), pet.getBreed(),
                this.getPetResponsable(pet) };
        petDataBaseTableModel.addRow(petData);
    }

    private int getPetResponsablePerson(String personString) {
        int petResponsabPersonId = 0;
        String[] personStrings = personString.split("-");
        ArrayList<Person> persons = veterinaryClinicView.getPresenter().getPersons();
        for (Person person : persons) {
            if (personStrings[0].equalsIgnoreCase(person.getName())) {
                petResponsabPersonId = person.getId();
            }
        }
        return petResponsabPersonId;
    }

    public String getPetResponsableRelationship(String personString) {
        String petResponsabPersonRelationship = new String();
        String[] personStrings = personString.split("-");
        petResponsabPersonRelationship = personStrings[1];
        return petResponsabPersonRelationship;
    }

    public Pet createSelectedRowPet() {
        Pet pet = new Pet();
        pet.setId((int) petDataBaseTableModel.getValueAt(petDataBaseTable.getSelectedRow(), 0));
        pet.setName((String) petDataBaseTableModel.getValueAt(petDataBaseTable.getSelectedRow(), 1));
        pet.setSpecies((String) petDataBaseTableModel.getValueAt(petDataBaseTable.getSelectedRow(), 2));
        pet.setAge((int) petDataBaseTableModel.getValueAt(petDataBaseTable.getSelectedRow(), 3));
        pet.setBreed((String) petDataBaseTableModel.getValueAt(petDataBaseTable.getSelectedRow(), 4));
        ArrayList<Keeper> keepers = new ArrayList<>();
        Keeper keeper = new Keeper();
        keeper.setPersonId(this.getPetResponsablePerson(
                (String) petDataBaseTableModel.getValueAt(petDataBaseTable.getSelectedRow(), 5)));
        keeper.setRelationship(this.getPetResponsableRelationship(
                (String) petDataBaseTableModel.getValueAt(petDataBaseTable.getSelectedRow(), 5)));
        keepers.add(keeper);
        pet.setKeepers(keepers);
        return pet;
    }

    private String getPetResponsable(Pet pet){
        String petResponsable = new String();
        for (Keeper keeper : pet.getKeepers()) {
            if (keeper.getRelationship().equalsIgnoreCase("Dueño")) {
                petResponsable = this.searchPersonByid(keeper.getPersonId()).getName() +"-(Dueño)";
            }else if (keeper.getRelationship().equalsIgnoreCase("Familiar")) {
                petResponsable = this.searchPersonByid(keeper.getPersonId()).getName() +"-(Familiar)";
            }
        }
        return petResponsable;
    }

    private void addVaccineTableHeader() {
        JLabel headerLabel = new JLabel("Inventario de Vacunas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(310, 360, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addVaccinesTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_TABLE_COLOR));
        tablePanel.setBounds(10, 350, 765, 170);
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
        vaccinesTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
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
                    createSelectedRowVaccines();                                   
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(vaccinesTable);
        scrollPane.setBounds(20, 40, 725, 120);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }
    public ArrayList<Vaccine> createSelectedRowVaccines() {
        ArrayList<Vaccine> selectedVaccines = new ArrayList<>();
        int[] selectedRows = vaccinesTable.getSelectedRows();
    
        for (int row : selectedRows) {
            Vaccine vaccine = new Vaccine();
            vaccine.setId((int) vaccineTableModel.getValueAt(row, 0));
            vaccine.setName((String) vaccineTableModel.getValueAt(row, 1));
            vaccine.setShelfLife((int) vaccineTableModel.getValueAt(row, 2));
            selectedVaccines.add(vaccine);
        }
    
        return selectedVaccines;
    }

    public void addVaccine(Vaccine vaccine) {
        Object[] vaccineData = { vaccine.getId(), vaccine.getName(), vaccine.getShelfLife() };
        vaccineTableModel.addRow(vaccineData);
    }

    public Person searchPersonByid(int id) {
        return veterinaryClinicView.getPresenter().searchPersonById(id);
    }

}
