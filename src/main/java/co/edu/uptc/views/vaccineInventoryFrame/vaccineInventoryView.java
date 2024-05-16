package co.edu.uptc.views.vaccineInventoryFrame;

import javax.swing.JDialog;
import java.awt.BorderLayout;


public class vaccineInventoryView extends JDialog{

    public vaccineInventoryView(){
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
        vaccineInventoryHeader mainHeader = new vaccineInventoryHeader();
        this.add(mainHeader, BorderLayout.NORTH);
    }

    private void createMainAside(){
        vaccineInventoryAside mainAside = new vaccineInventoryAside();
        this.add(mainAside, BorderLayout.WEST);
    }

    private void createMainBody(){
        vaccineInventoryBody mainBody = new vaccineInventoryBody();
        this.add(mainBody);
    }
}
