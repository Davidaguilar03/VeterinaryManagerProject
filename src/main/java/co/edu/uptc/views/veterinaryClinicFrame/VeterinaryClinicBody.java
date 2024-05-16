package co.edu.uptc.views.veterinaryClinicFrame;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class VeterinaryClinicBody extends JPanel {

    public VeterinaryClinicBody(){
        initPanel();
    }

    private void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
    }
}
