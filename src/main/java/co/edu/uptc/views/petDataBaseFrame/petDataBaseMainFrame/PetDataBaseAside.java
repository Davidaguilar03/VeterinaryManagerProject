package co.edu.uptc.views.petDataBaseFrame.petDataBaseMainFrame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.views.GlobalView;

public class PetDataBaseAside extends JPanel{

    public PetDataBaseAside(){
        initPanel();
    }

    private void initPanel(){
        this.setBackground(GlobalView.ASIDE_BACKGROUND);
        this.setForeground(GlobalView.ASIDE_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(298,0));
        this.setBorder(BorderFactory.createMatteBorder(0,1,1,1,Color.black));
    }
}
