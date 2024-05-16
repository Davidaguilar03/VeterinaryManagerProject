package co.edu.uptc.views.petDataBaseFrame;

import javax.swing.JDialog;


import java.awt.BorderLayout;


public class petDataBaseView extends JDialog{

    public petDataBaseView(){
        initFrame();
        createMainHeader();
        createMainAside();
        createMainBody();
    }
    public void begin(){
        this.setVisible(true);
    }

    private void initFrame(){
        this.setTitle("Clinica Veterinaria");
        this.setLayout(new BorderLayout());
        this.setSize(1366,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void createMainHeader(){
        petDataBaseHeader mainHeader = new petDataBaseHeader();
        this.add(mainHeader, BorderLayout.NORTH);
    }

    private void createMainAside(){
        petDataBaseAside mainAside = new petDataBaseAside();
        this.add(mainAside, BorderLayout.WEST);
    }

    private void createMainBody(){
        petDataBaseBody mainBody = new petDataBaseBody();
        this.add(mainBody);
    }
}
