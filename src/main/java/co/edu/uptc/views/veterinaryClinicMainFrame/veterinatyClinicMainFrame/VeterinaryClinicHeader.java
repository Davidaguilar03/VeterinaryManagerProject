package co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.utilities.*;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.peopleDataBaseFrame.peopleDataBaseMainFrame.PeopleDataBaseView;
import co.edu.uptc.views.petDataBaseFrame.petDataBaseMainFrame.PetDataBaseView;
import co.edu.uptc.views.vaccineInventoryFrame.vaccineInventoryMainFrame.VaccineInventoryView;
import lombok.Getter;
@Getter
public class VeterinaryClinicHeader extends JPanel{
  private ImageIcon imageIcon;
  private PropertiesService propertiesService;
  private VeterinaryClinicView veterinaryClinicView;
  private PetDataBaseView petDataBaseView;
  private VaccineInventoryView vaccineInventoryView;
  private PeopleDataBaseView peopleDataBaseView;

    public VeterinaryClinicHeader(VeterinaryClinicView veterinaryClinicView){
        propertiesService = new PropertiesService();
        this.veterinaryClinicView=veterinaryClinicView;
        this.initPanel();
        this.addImageIcon();
        this.addTitleLabel();
        this.addVaccineInventaryBtn();
        this.addPetDataBaseBtn();
        this.addPeopleDataBaseBtn();
    }

    private void initPanel(){
        this.setBackground(GlobalView.HEADER_BACKGROUND);
        this.setForeground(GlobalView.HEADER_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(100,236));
        this.setBorder(BorderFactory.createMatteBorder(1,1,1,1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addTitleLabel(){
        JLabel titleLabel = new JLabel("<html>Clinica<br/>Veterinaria</html>");
        titleLabel.setFont( new Font("Semi_Bold", 1, 40));;
        Dimension titleDimension = titleLabel.getPreferredSize();
        titleLabel.setBounds(62,55, (int)titleDimension.getWidth(), (int)titleDimension.getHeight());
        this.add(titleLabel);
    }

    private void addVaccineInventaryBtn(){
        RoundedButton vaccineInventaryBtn = new RoundedButton("<html>Inventario de<br/>Vacunas</html>", 20);
        vaccineInventaryBtn.setBounds(315, 78, 200, 80);
        vaccineInventaryBtn.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        ImageIcon vaccineIcon = new ImageIcon(propertiesService.getKeyValue("VaccineIconPath"));
        vaccineInventaryBtn.setIcon(vaccineIcon);
        vaccineInventaryBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                createVaccineInventoryFrame();
            }
        });
        this.add(vaccineInventaryBtn);
    }

    private void addPetDataBaseBtn(){
        RoundedButton PetDataBaseBtn = new RoundedButton("<html>Registro de<br/>Mascotas</html>", 20);
        PetDataBaseBtn.setBounds(596, 78, 200, 80);
        PetDataBaseBtn.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        ImageIcon petIcon = new ImageIcon(propertiesService.getKeyValue("PetIconPath"));
        PetDataBaseBtn.setIcon(petIcon);
        PetDataBaseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                createPetDataBaseFrame();
            }
        });
        this.add(PetDataBaseBtn);
    }

    private void addPeopleDataBaseBtn(){
        RoundedButton PeopleDataBaseBtn = new RoundedButton("<html>Registro de<br/>Personas</html>", 20);
        PeopleDataBaseBtn.setBounds(876, 78, 200, 80);
        PeopleDataBaseBtn.setBackground(GlobalView.PRIMARY_BTN_BACKGROUND);
        ImageIcon userIcon = new ImageIcon(propertiesService.getKeyValue("UserIconPath"));
        PeopleDataBaseBtn.setIcon(userIcon);
        PeopleDataBaseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                createPeopleDataBaseFrame();
            }
        });
        this.add(PeopleDataBaseBtn);
    }

    private void createVaccineInventoryFrame(){
        vaccineInventoryView = new VaccineInventoryView(this.veterinaryClinicView);
        vaccineInventoryView.begin();
    }

    private void createPetDataBaseFrame(){
        petDataBaseView = new PetDataBaseView(this.veterinaryClinicView);
        petDataBaseView.begin();
    }

    private void createPeopleDataBaseFrame(){
        peopleDataBaseView = new PeopleDataBaseView(this.veterinaryClinicView);
        peopleDataBaseView.begin();
    }

    private void addImageIcon(){
        imageIcon = new ImageIcon(propertiesService.getKeyValue("LogoPath"));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imageIcon != null) {
            Image image = imageIcon.getImage();
            g.drawImage(image, 1140, 25, 211, 211, this);
        }
    }
}
