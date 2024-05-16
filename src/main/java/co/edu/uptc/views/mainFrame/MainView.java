package co.edu.uptc.views.mainFrame;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainView extends JFrame{

    public MainView(){
        initFrame();
        createMainHeader();
        createMainAside();
        createMainBody();
    }
    public void begin(){
        this.setVisible(true);
    }

    private void initFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clinica Veterinaria");
        this.setLayout(new BorderLayout());
        this.setSize(1366,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void createMainHeader(){
        MainHeader mainHeader = new MainHeader();
        this.add(mainHeader, BorderLayout.NORTH);
    }

    private void createMainAside(){
        MainAside mainAside = new MainAside();
        this.add(mainAside, BorderLayout.WEST);
    }

    private void createMainBody(){
        MainBody mainBody = new MainBody();
        this.add(mainBody);
    }
}
