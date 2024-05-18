package co.edu.uptc.views.petDataBaseFrame.petDataBaseMainFrame;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PetDataBaseBody extends JPanel {

    public PetDataBaseBody(){
        initPanel();
    }

    private void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
    }
}
