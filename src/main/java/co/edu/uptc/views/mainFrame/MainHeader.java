package co.edu.uptc.views.mainFrame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.views.Global;

public class MainHeader extends JPanel{

    public MainHeader(){
        initPanel();
    }

    public void initPanel(){
        this.setBackground(Global.HEADER_BACKGROUND);
        this.setPreferredSize(new Dimension(0,236));
        this.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.black));
    }
}
