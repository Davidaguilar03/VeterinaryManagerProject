package co.edu.uptc.views.peopleDataBaseFrame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.resources.Global;

public class peopleDataBaseAside extends JPanel{

    public peopleDataBaseAside(){
        initPanel();
    }

    private void initPanel(){
        this.setBackground(Global.ASIDE_BACKGROUND);
        this.setForeground(Global.ASIDE_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(298,0));
        this.setBorder(BorderFactory.createMatteBorder(0,1,1,1,Color.black));
    }
}
