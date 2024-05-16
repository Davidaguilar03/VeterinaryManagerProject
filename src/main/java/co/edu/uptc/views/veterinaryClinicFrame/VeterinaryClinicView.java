package co.edu.uptc.views.veterinaryClinicFrame;

import javax.swing.JFrame;

import co.edu.uptc.interfaces.VeterinaryInterface;
import co.edu.uptc.interfaces.VeterinaryInterface.Presenter;

import java.awt.BorderLayout;


public class VeterinaryClinicView extends JFrame implements VeterinaryInterface.View{
    private VeterinaryInterface.Presenter presenter;

    public VeterinaryClinicView(){
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
        VeterinaryClinicHeader mainHeader = new VeterinaryClinicHeader();
        this.add(mainHeader, BorderLayout.NORTH);
    }

    private void createMainAside(){
        VeterinaryClinicAside mainAside = new VeterinaryClinicAside();
        this.add(mainAside, BorderLayout.WEST);
    }

    private void createMainBody(){
        VeterinaryClinicBody mainBody = new VeterinaryClinicBody();
        this.add(mainBody);
    }
    @Override
    public void setPresenter(Presenter presenter) {
       this.presenter = presenter;
    }

    public VeterinaryInterface.Presenter getPresenter(){
        return presenter;
    }
}
