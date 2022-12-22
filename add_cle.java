package Banking3;

import javax.swing.*;
import java.awt.event.*;

public class add_cle extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonBack;
    private JTextField textField1;

    public add_cle() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBack();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onBack();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBack();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
    Bank banktoaddcl=new Bank("HBL");

    private void onOK()
    {
        banktoaddcl.addcl(textField1.getText());
    }

    private void onBack() {
        Main_Menu mm=new Main_Menu();
        // add your code here if necessary
        destroy_addclwindow();
        mm.destroy_windows();
        mm.main_display();

    }


    void display_addcle()
    {
        add_cle dialog = new add_cle();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);

    }
    void destroy_addclwindow()
    {
        this.dispose();
    }

}
