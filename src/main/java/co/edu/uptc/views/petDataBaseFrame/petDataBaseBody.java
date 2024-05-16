package co.edu.uptc.views.petDataBaseFrame;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class petDataBaseBody extends JPanel {

    public petDataBaseBody(){
        initPanel();
    }

    private void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
    }
}
