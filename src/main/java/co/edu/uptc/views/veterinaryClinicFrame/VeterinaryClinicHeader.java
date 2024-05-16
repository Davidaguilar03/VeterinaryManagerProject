package co.edu.uptc.views.veterinaryClinicFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.resources.Global;
import co.edu.uptc.resources.PropiertiesService;

public class VeterinaryClinicHeader extends JPanel{
  private ImageIcon imageIcon;
  private PropiertiesService propiertiesService = new PropiertiesService();

    public VeterinaryClinicHeader(){
        initPanel();
        this.addImageIcon();
        this.addTitleLabel();
    }

    private void initPanel(){
        this.setBackground(Global.HEADER_BACKGROUND);
        this.setForeground(Global.HEADER_TEXT_BACKGROUND);
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
