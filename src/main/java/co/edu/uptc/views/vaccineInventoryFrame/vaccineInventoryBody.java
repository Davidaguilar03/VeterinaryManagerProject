package co.edu.uptc.views.vaccineInventoryFrame;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class vaccineInventoryBody extends JPanel {

    public vaccineInventoryBody(){
        initPanel();
    }

    private void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
    }
}
