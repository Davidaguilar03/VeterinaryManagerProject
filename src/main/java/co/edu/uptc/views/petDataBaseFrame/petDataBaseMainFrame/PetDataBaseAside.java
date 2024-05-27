package co.edu.uptc.views.petDataBaseFrame.petDataBaseMainFrame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import co.edu.uptc.views.petDataBaseFrame.addPetDialog.AddPetDialogView;
import co.edu.uptc.views.petDataBaseFrame.editPetDialog.EditPetDialogView;
import lombok.Getter;

@Getter
public class PetDataBaseAside extends JPanel{
    private PetDataBaseView petDataBaseView;
    private RoundedButton deletePetBtn;
    private RoundedButton editPetBtn;
    private AddPetDialogView addPetDialogView;

    public PetDataBaseAside(PetDataBaseView petDataBaseView){
        this.petDataBaseView=petDataBaseView;
        this.initPanel();
        this.addCreatePetBtn();
        this.addDeletePetBtn();
        this.addEditPetBtn();
    }

    public void enableDeletePetBtn(Boolean value){
        deletePetBtn.setEnabled(value);
    }

    public void enableEditPetBtn(Boolean value){
        editPetBtn.setEnabled(value);
    }

    private void initPanel(){
        this.setBackground(GlobalView.ASIDE_BACKGROUND);
        this.setForeground(GlobalView.ASIDE_TEXT_BACKGROUND);
        this.setPreferredSize(new Dimension(298,0));
        this.setBorder(BorderFactory.createMatteBorder(0,1,1,1,GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addCreatePetBtn(){
        RoundedButton createPetBtn = new RoundedButton("Agregar Mascota", 20);
        createPetBtn.setBounds(77, 30, 145, 52);
        createPetBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createPetBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createPetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               createAddPetDialog();
            }
        });
        this.add(createPetBtn);
    }

    private void addDeletePetBtn(){
        deletePetBtn = new RoundedButton("Eliminar Mascota", 20);
        deletePetBtn.setBounds(77, 115, 145, 52);
        deletePetBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        deletePetBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        deletePetBtn.setEnabled(false);
        deletePetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               petDataBaseView.getPetDataBaseBody().deletePet();
            }
        });
        this.add(deletePetBtn);
    }

    private void addEditPetBtn(){
        editPetBtn = new RoundedButton("Editar Mascota", 20);
        editPetBtn.setBounds(77, 195, 145, 52);
        editPetBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        editPetBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        editPetBtn.setEnabled(false);
        editPetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               createEditPetDialog();
            }
        });
        this.add(editPetBtn);
    }

    public PetDataBaseView getPetDataBaseView() {
        return petDataBaseView;
    }

    private void createAddPetDialog(){
        addPetDialogView = new AddPetDialogView(petDataBaseView);
        addPetDialogView.begin();;
    }

    private void createEditPetDialog(){
        EditPetDialogView editPetDialogView = new EditPetDialogView(petDataBaseView);
    editPetDialogView.begin(); 
   }
    
}
