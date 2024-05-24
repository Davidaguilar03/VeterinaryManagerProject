package co.edu.uptc.views.petDataBaseFrame.editPetDialog;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import co.edu.uptc.utilities.RoundedButton;
import co.edu.uptc.views.GlobalView;
import lombok.Getter;

@Getter
public class EditPetDialogFooter extends JPanel{
    private EditPetDialogView editPetDialogView;

    public EditPetDialogFooter(EditPetDialogView editPetDialogView){
        this.editPetDialogView=editPetDialogView;
        this.initPanel();
        this.addSavePetBtn();
        this.addCancelPetBtn();
    }

    private void initPanel(){
        this.setBackground(GlobalView.FOOTER_DIALOG_BACKGROUND);
        this.setForeground(GlobalView.FOOTER_TEXT_DIALOG_BACKGROUND);
        this.setPreferredSize(new Dimension(0, 100));
        this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

        private void addSavePetBtn() {
        RoundedButton createSavePetBtn = new RoundedButton("Editar Mascota", 20);
        createSavePetBtn.setBounds(150, 25, 180, 50);
        createSavePetBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createSavePetBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createSavePetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                editPet();
               Window window = SwingUtilities.getWindowAncestor(EditPetDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(createSavePetBtn);
    }

    private void addCancelPetBtn() {
        RoundedButton createCancelPetBtn = new RoundedButton("Cancelar", 20);
        createCancelPetBtn.setBounds(380, 25, 180, 50);
        createCancelPetBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        createCancelPetBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        createCancelPetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Window window = SwingUtilities.getWindowAncestor(EditPetDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(createCancelPetBtn);
    }
    
    private void editPet(){
       // to do
    }
    
}
