package Banking3;

import javax.swing.*;
import java.awt.event.*;

public class Add_Account_GUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonBack;
    private JTextField textField1;
    private JTextField textField2;

    public Add_Account_GUI() {
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
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
    Bank BankObjectToAddAccount=new Bank("HBL");

    private void onOK()
    {
        BankObjectToAddAccount.addac(textField1.getText(),Integer.parseInt(textField2.getText()));

    }

    private void onCancel() {
        // add your code here if necessary
        Main_Menu mm=new Main_Menu();
        // add your code here if necessary
        Destroy_Add_Account_Window();
        mm.destroy_windows();
        mm.main_display();
    }






    void Destroy_Add_Account_Window()
    {
        this.dispose();
    }



    void Display_Add_Account_Window()
    {
        Add_Account_GUI dialog = new Add_Account_GUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }


}
