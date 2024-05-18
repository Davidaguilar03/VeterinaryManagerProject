package co.edu.uptc.views.peopleDataBaseFrame;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PeopleDataBaseBody extends JPanel {

    public PeopleDataBaseBody(){
        initPanel();
    }

    private void initPanel(){
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.black));
    }
}
