package co.edu.uptc.views.petDataBaseFrame.editPetDialog;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.PlainDocument;

import co.edu.uptc.pojos.Keeper;
import co.edu.uptc.pojos.Person;
import co.edu.uptc.pojos.Pet;
import co.edu.uptc.utilities.CenterTableCellRenderer;
import co.edu.uptc.utilities.NumericDocumentFilter;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;

@Getter
public class EditPetDialogBody extends JPanel {
    private EditPetDialogView editPetDialogView;
    private JTextField txtName;
    private JTextField txtAge;
    private JComboBox<String> txtSpecies;
    private JTextField txtBreed;
    private DefaultTableModel peopleDataBaseTableModel;
    private JTable peopleDataBaseTable;
    private String relationshipSelection;
    private JRadioButton ownerRadioButton;
    private JRadioButton familiarRadioButton;
    private ButtonGroup relationshipGroup;

    public EditPetDialogBody(EditPetDialogView editPetDialogView) {
        this.editPetDialogView = editPetDialogView;
        this.initPanel();
        this.createLblName();
        this.createTextFileName();
        this.createLblAge();
        this.createTextFileAge();
        this.createLblSpecies();
        this.createTextFileSpecies();
        this.createLblBreed();
        this.createTextFileBreed();
        this.addPeopleTableHeader();
        this.addPeopleDataBaseTable();
        this.createRelationshipSelection();
        this.loadPetData();
    }

    private void initPanel() {
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void createLblName() {
        JLabel lblName = new JLabel("Nombre: ");
        lblName.setBounds(50, 20, 80, 25);
        lblName.setFont(new Font("Semi_Bold", 1, 16));
        this.add(lblName);
    }

    private void createTextFileName() {
        txtName = new JTextField("Ingrese el Nombre");
        txtName.setBounds(50, 50, 250, 40);
        txtName.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtName.getText().equals("Ingrese el Nombre")) {
                    txtName.setText("");
                    txtName.setForeground(GlobalView.TEXT_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtName.getText().isEmpty()) {
                    txtName.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
                    txtName.setText("Ingrese el Nombre");
                }
            }
        });
        this.add(txtName);
    }

    private void createLblAge() {
        JLabel lblAge = new JLabel("Edad: ");
        lblAge.setBounds(50, 100, 80, 25);
        lblAge.setFont(new Font("Semi_Bold", 1, 16));
        this.add(lblAge);
    }

    private void createTextFileAge() {
        txtAge = new JTextField("Ingrese la Edad");
        txtAge.setBounds(50, 130, 250, 40);
        txtAge.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        ((PlainDocument) txtAge.getDocument()).setDocumentFilter(new NumericDocumentFilter());
        txtAge.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtAge.getText().equals("Ingrese la Edad")) {
                    txtAge.setText("");
                    txtAge.setForeground(GlobalView.TEXT_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtAge.getText().isEmpty()) {
                    txtAge.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
                    txtAge.setText("Ingrese la Edad");
                }
            }
        });
        this.add(txtAge);
    }

    private void createLblSpecies() {
        JLabel lblSpecies = new JLabel("Especie: ");
        lblSpecies.setBounds(400, 20, 80, 25);
        lblSpecies.setFont(new Font("Semi_Bold", 1, 16));
        this.add(lblSpecies);
    }

    private void createTextFileSpecies() {
        String[] speciesTypesOptions = { "Perro", "Gato" };
        txtSpecies = new JComboBox<>(speciesTypesOptions);
        txtSpecies.setBounds(400, 50, 250, 40);
        this.add(txtSpecies);
    }

    private void createLblBreed() {
        JLabel lblBreed = new JLabel("Raza: ");
        lblBreed.setBounds(400, 100, 80, 25);
        lblBreed.setFont(new Font("Semi_Bold", 1, 16));
        this.add(lblBreed);
    }

    private void createTextFileBreed() {
        txtBreed = new JTextField("Ingrese la Raza");
        txtBreed.setBounds(400, 130, 250, 40);
        txtBreed.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtBreed.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtBreed.getText().equals("Ingrese la Raza")) {
                    txtBreed.setText("");
                    txtBreed.setForeground(GlobalView.TEXT_COLOR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtBreed.getText().isEmpty()) {
                    txtBreed.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
                    txtBreed.setText("Ingrese la Raza");
                }
            }
        });
        this.add(txtBreed);
    }

    private void addPeopleTableHeader() {
        JLabel headerLabel = new JLabel("Registro de Personas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(265, 210, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addPeopleDataBaseTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_TABLE_COLOR));
        tablePanel.setBounds(20, 200, 650, 250);
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
        scrollPane.setBounds(20, 40, 610, 200);
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

    private void createRelationshipSelection() {
        JPanel relationshipSelectionPanel = new JPanel();
        relationshipSelectionPanel.setLayout(new GridLayout(1, 2));
        ownerRadioButton = new JRadioButton("Dueño");
        ownerRadioButton.setBackground(GlobalView.RELATIONSHIP_SELECTION_COLOR);
        familiarRadioButton = new JRadioButton("Familiar");
        familiarRadioButton.setBackground(GlobalView.RELATIONSHIP_SELECTION_COLOR);
        relationshipGroup = new ButtonGroup();
        relationshipGroup.add(ownerRadioButton);
        relationshipGroup.add(familiarRadioButton);
        relationshipSelectionPanel.add(ownerRadioButton);
        relationshipSelectionPanel.add(familiarRadioButton);
        relationshipSelectionPanel.setBounds(265, 470, 180, 30);
        relationshipSelectionPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_COLOR));
        this.add(relationshipSelectionPanel);

        ActionListener relationshipSelectionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ownerRadioButton.isSelected()) {
                    relationshipSelection = "Dueño";
                } else if (familiarRadioButton.isSelected()) {
                    relationshipSelection = "Familiar";
                }
            }
        };
        ownerRadioButton.addActionListener(relationshipSelectionListener);
        familiarRadioButton.addActionListener(relationshipSelectionListener);
    }

    private void loadPetData() {
        Pet auxPet = editPetDialogView.getPetDataBaseView().getPetDataBaseBody().createSelectedRowPet();
        txtName.setText(auxPet.getName());
        txtAge.setText(String.valueOf(auxPet.getAge()));
        txtSpecies.setSelectedItem(auxPet.getSpecies());
        txtBreed.setText(auxPet.getBreed());
        if (!auxPet.getKeepers().isEmpty()) {
            Keeper lastKeeper = auxPet.getKeepers().get(auxPet.getKeepers().size() - 1);
            String relationship = lastKeeper.getRelationship();
            if (relationship.equalsIgnoreCase("Dueño")) {
                ownerRadioButton.setSelected(true);
            } else if (relationship.equalsIgnoreCase("Familiar")) {
                familiarRadioButton.setSelected(true);
            }
        }
    }
    

}
