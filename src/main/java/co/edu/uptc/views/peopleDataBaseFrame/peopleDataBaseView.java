package co.edu.uptc.views.peopleDataBaseFrame;

import javax.swing.JDialog;
import java.awt.BorderLayout;


public class peopleDataBaseView extends JDialog{

    public peopleDataBaseView(){
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
        peopleDataBaseHeader mainHeader = new peopleDataBaseHeader();
        this.add(mainHeader, BorderLayout.NORTH);
    }

    private void createMainAside(){
        peopleDataBaseAside mainAside = new peopleDataBaseAside();
        this.add(mainAside, BorderLayout.WEST);
    }

    private void createMainBody(){
        peopleDataBaseBody mainBody = new peopleDataBaseBody();
        this.add(mainBody);
    }
}
