package co.edu.uptc.views.veterinaryClinicMainFrame.sortByDateDialog;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import co.edu.uptc.views.GlobalView;
import lombok.Getter;

@Getter
public class SortByDateDialogBody extends JPanel {
    private SortByDateDialogView sortByDateDialogView;
    private UtilDateModel model;
    private LocalDate sortDate;
    private JFormattedTextField textField;

    public SortByDateDialogBody(SortByDateDialogView sortByDateDialogView) {
        this.sortByDateDialogView = sortByDateDialogView;
        this.initPanel();
        this.createLblDate();
        this.createDatePicker();
    }

    public void initPanel() {
        this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void createLblDate() {
        JLabel lblDate = new JLabel("Seleccione la Fecha: ");
        lblDate.setBounds(100, 10, 150, 25);
        lblDate.setFont(new Font("Semi_Bold", 1, 12));
        this.add(lblDate);
    }

    private void createDatePicker() {
        model = new UtilDateModel();
        Properties properties = new Properties();
        properties.put("text.today", "Hoy");
        properties.put("text.month", "Mes");
        properties.put("text.year", "Año");
        properties.put("popup_hook", "false");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

        textField = datePicker.getJFormattedTextField();
        textField.setEditable(false);

        model.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Date selectedDate = (Date) model.getValue();
                if (selectedDate != null) {
                    sortDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    textField.setText(dateFormat.format(selectedDate));
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setBounds(100, 30, 210, 35);
        panel.add(datePicker);
        this.add(panel);
    }
}
