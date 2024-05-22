package co.edu.uptc.views.peopleDataBaseFrame.addPersonDialog;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.peopleDataBaseFrame.peopleDataBaseMainFrame.PeopleDataBaseView;
import lombok.Getter;

@Getter
public class AddPersonDialogView extends JDialog{
    private PeopleDataBaseView peopleDataBaseView;
    private AddPersonDialogBody addPersonDialogBody;
    private AddPersonDialogFooter addPersonDialogFooter;
    private PropertiesService propertiesService;

    public AddPersonDialogView(PeopleDataBaseView peopleDataBaseView){
        super(peopleDataBaseView,true);
        this.peopleDataBaseView=peopleDataBaseView;
        propertiesService = new PropertiesService();
        this.initDialog();
        this.createMainHeader();
        this.createMainBody();
        this.createMainFooter();
    }

    public void begin(){
        this.setVisible(true);
    }

    private void initDialog(){
        this.setLayout(new BorderLayout());
        this.setSize(600,500);
        this.setTitle("Agregar Persona");
        this.setResizable(false);
        this.setLocationRelativeTo(peopleDataBaseView);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    private void createMainHeader(){
        AddPersonDialogHeader addPersonDialogHeader = new AddPersonDialogHeader();
        this.add(addPersonDialogHeader,BorderLayout.NORTH);
    }

    private void createMainBody(){
        addPersonDialogBody = new AddPersonDialogBody(this);
        this.add(addPersonDialogBody);
    }

    private void createMainFooter(){
        addPersonDialogFooter = new AddPersonDialogFooter(this);
        this.add(addPersonDialogFooter, BorderLayout.SOUTH);
    }

}

