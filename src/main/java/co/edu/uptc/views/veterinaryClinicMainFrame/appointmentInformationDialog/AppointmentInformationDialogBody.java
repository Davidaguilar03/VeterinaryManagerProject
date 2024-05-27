package co.edu.uptc.views.veterinaryClinicMainFrame.appointmentInformationDialog;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.pojos.Appointment;
import co.edu.uptc.pojos.Person;
import co.edu.uptc.pojos.Vaccine;
import co.edu.uptc.utilities.CenterTableCellRenderer;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;
import lombok.Getter;

@Getter
public class AppointmentInformationDialogBody extends JPanel{
    private VeterinaryClinicView veterinaryClinicView;
    private DefaultTableModel vaccineTableModel;
    private JTable vaccinesTable;
    private JTextField txtResponsableName;
    private JTextField txtResponsableAge;
    private JTextField documentType;
    private JTextField txtDocumentNumber;
    private JTextField txtPetName;
    private JTextField txtPetAge;
    private JTextField txtSpecies;
    private JTextField txtBreed;
    

    public AppointmentInformationDialogBody(VeterinaryClinicView veterinaryClinicView){
        this.veterinaryClinicView=veterinaryClinicView;
        this.initPanel();
        this.createLblResponsableName();
        this.createTextFileResponsableName();
        this.createLblResponsableAge();
        this.createTextFileResponsableAge();
        this.createLblDocumentType();
        this.createTextFileDocumentType();
        this.createLblDocumentNumber();
        this.createTextFileDocumentNumber();
        this.createLblPetName();
        this.createTextFilePetName();
        this.createLblPetAge();
        this.createTextFilePetAge();
        this.createLblSpecies();
        this.createTextFileSpecies();
        this.createLblBreed();
        this.createTextFileBreed();
        this.addVaccinesTableHeader();
        this.addVaccinesTable();
    }

    private void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void createLblResponsableName() {
        JLabel lblName = new JLabel("Nombre del Responsable: ");
        lblName.setBounds(30, 20, 150, 25);
        lblName.setFont(new Font("Semi_Bold", 1, 12));
        this.add(lblName);
    }

    private void createTextFileResponsableName() {
        txtResponsableName = new JTextField();
        txtResponsableName.setBounds(30, 50, 150, 30);
        txtResponsableName.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtResponsableName.setEditable(false);
        txtResponsableName.setBackground(GlobalView.JTEXTFIELD_COLOR);
        this.add(txtResponsableName);
    }

    private void createLblResponsableAge() {
        JLabel lblAge = new JLabel("Edad del Responsable: ");
        lblAge.setBounds(200, 20, 150, 25);
        lblAge.setFont(new Font("Semi_Bold", 1, 12));
        this.add(lblAge);
    }

    private void createTextFileResponsableAge() {
        txtResponsableAge = new JTextField();
        txtResponsableAge.setBounds(200, 50, 150, 30);
        txtResponsableAge.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtResponsableAge.setEditable(false);
        txtResponsableAge.setBackground(GlobalView.JTEXTFIELD_COLOR);
        this.add(txtResponsableAge);
    }

    private void createLblDocumentType() {
        JLabel lblDocumentType = new JLabel("Tipo de Documento: ");
        lblDocumentType.setBounds(30, 80, 150, 25);
        lblDocumentType.setFont(new Font("Semi_Bold", 1, 12));
        this.add(lblDocumentType);
    }

    private void createTextFileDocumentType() {
        documentType = new JTextField();
        documentType.setBounds(30, 110, 150, 30);
        documentType.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        documentType.setEditable(false);
        documentType.setBackground(GlobalView.JTEXTFIELD_COLOR);
        this.add(documentType);
    }

    private void createLblDocumentNumber() {
        JLabel lblDocumentNumber = new JLabel("Numero de Documento: ");
        lblDocumentNumber.setBounds(200, 80, 150, 25);
        lblDocumentNumber.setFont(new Font("Semi_Bold", 1, 12));
        this.add(lblDocumentNumber);
    }

    private void createTextFileDocumentNumber() {
        txtDocumentNumber = new JTextField();
        txtDocumentNumber.setBounds(200, 110, 150, 30);
        txtDocumentNumber.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtDocumentNumber.setEditable(false);
        txtDocumentNumber.setBackground(GlobalView.JTEXTFIELD_COLOR);
        this.add(txtDocumentNumber);
    }

    private void createLblPetName() {
        JLabel lblName = new JLabel("Nombre de la Mascota:");
        lblName.setBounds(430, 20, 150, 25);
        lblName.setFont(new Font("Semi_Bold", 1, 12));
        this.add(lblName);
    }

    private void createTextFilePetName() {
        txtPetName = new JTextField();
        txtPetName.setBounds(430, 50, 150, 30);
        txtPetName.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtPetName.setEditable(false);
        txtPetName.setBackground(GlobalView.JTEXTFIELD_COLOR);
        this.add(txtPetName);
    }

    private void createLblPetAge() {
        JLabel lblAge = new JLabel("Edad de la Mascota:");
        lblAge.setBounds(600, 20, 150, 25);
        lblAge.setFont(new Font("Semi_Bold", 1, 12));
        this.add(lblAge);
    }

    private void createTextFilePetAge() {
        txtPetAge = new JTextField();
        txtPetAge.setBounds(600, 50, 150, 30);
        txtPetAge.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtPetAge.setEditable(false);
        txtPetAge.setBackground(GlobalView.JTEXTFIELD_COLOR);
        this.add(txtPetAge);
    }

    private void createLblSpecies() {
        JLabel lblSpecies = new JLabel("Especie: ");
        lblSpecies.setBounds(430, 80, 150, 25);
        lblSpecies.setFont(new Font("Semi_Bold", 1, 12));
        this.add(lblSpecies);
    }

    private void createTextFileSpecies() {
        txtSpecies = new JTextField();
        txtSpecies.setBounds(430, 110, 150, 30);
        txtSpecies.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtSpecies.setEditable(false);
        txtSpecies.setBackground(GlobalView.JTEXTFIELD_COLOR);
        this.add(txtSpecies);
    }
    

    private void createLblBreed() {
        JLabel lblBreed = new JLabel("Raza: ");
        lblBreed.setBounds(600, 80, 80, 25);
        lblBreed.setFont(new Font("Semi_Bold", 1, 12));
        this.add(lblBreed);
    }

    private void createTextFileBreed() {
        txtBreed = new JTextField();
        txtBreed.setBounds(600, 110, 150, 30);
        txtBreed.setForeground(GlobalView.PLACEHOLDER_TEXT_COLOR);
        txtBreed.setEditable(false);
        txtBreed.setBackground(GlobalView.JTEXTFIELD_COLOR);
        this.add(txtBreed);
    }

    private void addVaccinesTableHeader() {
        JLabel headerLabel = new JLabel("Vacunas Aplicadas");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        Dimension headerDimension = headerLabel.getPreferredSize();
        headerLabel.setBounds(300, 160, (int) headerDimension.getWidth(), (int) headerDimension.getHeight());
        this.add(headerLabel);
    }

    private void addVaccinesTable() {
        JPanel tablePanel = new JPanel();
        tablePanel.setOpaque(false);
        tablePanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_TABLE_COLOR));
        tablePanel.setBounds(30, 150, 719, 250);
        tablePanel.setLayout(null);
        String[] columnNames = {
                "ID.Vacuna", "Nombre", "Duracion(Dias)","Fecha de Vencimiento"
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
        JScrollPane scrollPane = new JScrollPane(vaccinesTable);
        scrollPane.setBounds(24, 40, 670, 200);
        tablePanel.add(scrollPane);
        this.add(tablePanel);
    }

    public void addVaccine(Vaccine vaccine) {
        Object[] vaccineData = { vaccine.getId(), vaccine.getName(), vaccine.getShelfLife(),vaccine.getExpireDate().toString() };
        vaccineTableModel.addRow(vaccineData);
    }
    public Person searchPersonByid(int id) {
        return veterinaryClinicView.getPresenter().searchPersonById(id);
    }

    public void loadAppointmentInformation(Appointment appointment){
    txtResponsableName.setText(this.searchPersonByid(appointment.getKeeper().getPersonId()).getName());
    txtResponsableAge.setText(this.searchPersonByid(appointment.getKeeper().getPersonId()).getAge()+"");
    documentType.setText(this.searchPersonByid(appointment.getKeeper().getPersonId()).getTypeOfDocument());
    txtDocumentNumber.setText(this.searchPersonByid(appointment.getKeeper().getPersonId()).getDocumentNumber()+"");;
    txtPetName.setText(appointment.getPet().getName());;
    txtPetAge.setText(appointment.getPet().getAge()+"");;
    txtSpecies.setText(appointment.getPet().getSpecies());;
    txtBreed.setText(appointment.getPet().getBreed());;
    ArrayList<Vaccine> appointmentVaccines = appointment.getVaccines();
    for (Vaccine vaccine : appointmentVaccines) {
        this.addVaccine(vaccine);
    }
    }
}
