package co.edu.uptc.views.veterinaryClinicMainFrame.sortByDateDialog;

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
public class SortByDateDialogFooter extends JPanel{
    private SortByDateDialogView sortByDateDialogView;

    public SortByDateDialogFooter(SortByDateDialogView sortByDateDialogView){
        this.sortByDateDialogView=sortByDateDialogView;
        this.initPanel();
        this.addSortByDateBtn();
        this.addCancelBtn();
    }

    private void initPanel(){
        this.setBackground(GlobalView.FOOTER_DIALOG_BACKGROUND);
        this.setForeground(GlobalView.FOOTER_TEXT_DIALOG_BACKGROUND);
        this.setPreferredSize(new Dimension(0,100));
        this.setBorder(BorderFactory.createMatteBorder(1,1,1,1,GlobalView.BORDER_COLOR));
        this.setLayout(null);
    }

    private void addSortByDateBtn(){
        RoundedButton sortByDateBtn = new RoundedButton("Filtrar", 20);
        sortByDateBtn.setBounds(20, 25, 180, 50);
        sortByDateBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        sortByDateBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        sortByDateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //to do
                Window window = SwingUtilities.getWindowAncestor(SortByDateDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(sortByDateBtn);
    }

    private void addCancelBtn(){
        RoundedButton cancelBtn = new RoundedButton("Cancelar", 20);
        cancelBtn.setBounds(240, 25, 180, 50);
        cancelBtn.setBackground(GlobalView.SECUNDARY_BTN_BACKGROUND);
        cancelBtn.setForeground(GlobalView.SECUNDARY_BTN_TEXT_BACKGROUND);
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Window window = SwingUtilities.getWindowAncestor(SortByDateDialogFooter.this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    dialog.dispose();
                }
            }
        });
        this.add(cancelBtn);
    }
}
