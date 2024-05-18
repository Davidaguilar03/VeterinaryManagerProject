package co.edu.uptc.views.veterinaryClinicFrame;

import java.awt.Color;
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
import co.edu.uptc.views.peopleDataBaseFrame.PeopleDataBaseView;
import co.edu.uptc.views.petDataBaseFrame.PetDataBaseView;
import co.edu.uptc.views.vaccineInventoryFrame.VaccineInventoryView;

public class VeterinaryClinicHeader extends JPanel{
  private ImageIcon imageIcon;
  private PropiertiesService propiertiesService = new PropiertiesService();
  private VeterinaryClinicView veterinaryClinicView;

    public VeterinaryClinicHeader(VeterinaryClinicView veterinaryClinicView){
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
        this.setPreferredSize(new Dimension(0,236));
        this.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
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
        ImageIcon vaccineIcon = new ImageIcon(propiertiesService.getKeyValue("VaccineIconPath"));
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
        ImageIcon petIcon = new ImageIcon(propiertiesService.getKeyValue("PetIconPath"));
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
        ImageIcon userIcon = new ImageIcon(propiertiesService.getKeyValue("UserIconPath"));
        PeopleDataBaseBtn.setIcon(userIcon);
        PeopleDataBaseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                createPeopleDataBaseFrame();
            }
        });
        this.add(PeopleDataBaseBtn);
    }

    private void createVaccineInventoryFrame(){
        VaccineInventoryView vaccineInventoryView = new VaccineInventoryView(this.veterinaryClinicView);
        vaccineInventoryView.begin();
    }

    private void createPetDataBaseFrame(){
        PetDataBaseView petDataBaseView = new PetDataBaseView(this.veterinaryClinicView);
        petDataBaseView.begin();
    }

    private void createPeopleDataBaseFrame(){
        PeopleDataBaseView peopleDataBaseView = new PeopleDataBaseView(this.veterinaryClinicView);
        peopleDataBaseView.begin();
    }

    private void addImageIcon(){
        imageIcon = new ImageIcon(propiertiesService.getKeyValue("LogoPath"));
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
