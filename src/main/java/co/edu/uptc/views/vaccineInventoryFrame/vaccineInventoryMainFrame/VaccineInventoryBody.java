package co.edu.uptc.views.vaccineInventoryFrame.vaccineInventoryMainFrame;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class VaccineInventoryBody extends JPanel {

    public VaccineInventoryBody(){
        initPanel();
    }

    private void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
    }
}
