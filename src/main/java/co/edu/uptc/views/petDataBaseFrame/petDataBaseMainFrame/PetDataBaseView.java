package co.edu.uptc.views.petDataBaseFrame.petDataBaseMainFrame;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import co.edu.uptc.pojos.Pet;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;
import lombok.Getter;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.ArrayList;

@Getter
public class PetDataBaseView extends JDialog{
    private VeterinaryClinicView veterinaryClinicView;
    private PetDataBaseBody petDataBaseBody;
    private PropertiesService propertiesService;
    private PetDataBaseAside petDataBaseAside;
    

    public PetDataBaseView(VeterinaryClinicView veterinaryClinicView){
        super(veterinaryClinicView,true);
        this.veterinaryClinicView=veterinaryClinicView;
        propertiesService = new PropertiesService();
        this.initFrame();
        this.createPetDataBaseHeader();
        this.createPetDataBaseAside();
        this.createPetDataBaseBody();
    }
    public void begin(){
        this.loadPetsData();
        this.setVisible(true);
    }

    private void initFrame(){
        this.setTitle("Registro de Mascotas");
        this.setLayout(new BorderLayout());
        this.setSize(1366,768);
        this.setLocationRelativeTo(veterinaryClinicView);
        this.setResizable(false);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    public void loadPetsData(){
        ArrayList<Pet> pets = veterinaryClinicView.getPresenter().getPets();
        petDataBaseBody.cleanTable();
        for (Pet pet : pets) {
            petDataBaseBody.addPet(pet);
        }
    }

    public void setPetStatus(Pet pet){
        if(pet != null){
            petDataBaseAside.enableDeletePetBtn(true);
            petDataBaseAside.enableEditPetBtn(true);
        }else{
            petDataBaseAside.enableDeletePetBtn(false);
            petDataBaseAside.enableEditPetBtn(false);
        }
    }

    private void createPetDataBaseHeader(){
        PetDataBaseHeader petDataBaseHeader = new PetDataBaseHeader();
        this.add(petDataBaseHeader, BorderLayout.NORTH);
    }

    private void createPetDataBaseAside(){
        petDataBaseAside = new PetDataBaseAside(this);
        this.add(petDataBaseAside, BorderLayout.WEST);
    }

    private void createPetDataBaseBody(){
        petDataBaseBody = new PetDataBaseBody(this);
        this.add(petDataBaseBody);
    }

    public VeterinaryClinicView getVeterinaryClinicView() {
        return veterinaryClinicView;
    }
    public PetDataBaseBody getMainBody() {
        return petDataBaseBody;
    }

    
}
