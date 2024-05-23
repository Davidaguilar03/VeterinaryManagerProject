package co.edu.uptc.views.peopleDataBaseFrame.editPersonDialog;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import co.edu.uptc.utilities.PropertiesService;
import co.edu.uptc.views.peopleDataBaseFrame.peopleDataBaseMainFrame.PeopleDataBaseView;
import lombok.Getter;

@Getter
public class EditPersonDialogView extends JDialog{
    private PeopleDataBaseView peopleDataBaseView;
    private EditPersonDialogBody editPersonDialogBody;
    private EditPersonDialogFooter editPersonDialogFooter;
    private PropertiesService propertiesService;

    public EditPersonDialogView(PeopleDataBaseView peopleDataBaseView){
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
        this.setTitle("Editar Persona");
        this.setResizable(false);
        this.setLocationRelativeTo(peopleDataBaseView);
        ImageIcon windowIcon = new ImageIcon(propertiesService.getKeyValue("VeterinaryWindowIconPath"));
        Image image = windowIcon.getImage();
        this.setIconImage(image);
    }

    private void createMainHeader(){
        EditPersonDialogHeader addPersonDialogHeader = new EditPersonDialogHeader();
        this.add(addPersonDialogHeader,BorderLayout.NORTH);
    }

    private void createMainBody(){
        editPersonDialogBody = new EditPersonDialogBody(this);
        this.add(editPersonDialogBody);
    }

    private void createMainFooter(){
        editPersonDialogFooter = new EditPersonDialogFooter(this);
        this.add(editPersonDialogFooter, BorderLayout.SOUTH);
    }

}

