package co.edu.uptc.views.peopleDataBaseFrame.peopleDataBaseMainFrame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.peopleDataBaseFrame.addPersonDialog.AddPersonDialogView;
import lombok.Getter;

@Getter
public class PeopleDataBaseAside extends JPanel{
    private PeopleDataBaseView peopleDataBaseView;
    private RoundedButton deletePersonBtn;
    private RoundedButton editPersonBtn;
    
    public PeopleDataBaseAside(PeopleDataBaseView peopleDataBaseView){
        this.peopleDataBaseView=peopleDataBaseView;
        this.initPanel();
        this.addCreatePersonBtn();
        this.addDeletePersonBtn();
        this.addEditPersonBtn();
    }

    public void enableDeletePersonBtn(Boolean value){
        deletePersonBtn.setEnabled(value);
    }

    public void enableEditPersonBtn(Boolean value){
        editPersonBtn.setEnabled(value);
    }


    private void initPanel(){
        this.setBackground(GlobalView.ASIDE_BACKGROUND);
        this.setForeground(GlobalView.ASIDE_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(298,0));
        this.setBorder(BorderFactory.createMatteBorder(0,1,1,1,GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addCreatePersonBtn(){
        RoundedButton createPersonBtn = new RoundedButton("Agregar Persona", 20);
        createPersonBtn.setBounds(77, 30, 145, 52);
        createPersonBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createPersonBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createPersonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               createAddPersonDialog();
            }
        });
        this.add(createPersonBtn);
    }

    private void addDeletePersonBtn(){
        deletePersonBtn = new RoundedButton("Eliminar Persona", 20);
        deletePersonBtn.setBounds(77, 115, 145, 52);
        deletePersonBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        deletePersonBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        deletePersonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               peopleDataBaseView.getPeopleDataBaseBody().deletePerson();
            }
        });
        this.add(deletePersonBtn);
    }

    private void addEditPersonBtn(){
        editPersonBtn = new RoundedButton("Editar Persona", 20);
        editPersonBtn.setBounds(77, 195, 145, 52);
        editPersonBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        editPersonBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        editPersonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               
            }
        });
        this.add(editPersonBtn);
    }

    private void createAddPersonDialog(){
        AddPersonDialogView addPersonDialogView = new AddPersonDialogView(peopleDataBaseView);
        addPersonDialogView.begin();
    }
    
}
