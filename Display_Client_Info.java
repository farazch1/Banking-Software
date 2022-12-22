package Banking3;

import javax.swing.*;
import java.awt.event.*;

public class Display_Client_Info extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textArea1;
    private JTextField textField1;

    public Display_Client_Info() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
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

    Bank BankObjectToseeclient=new Bank("HBL");
    private void onOK() {
        // add your code here
       BankObjectToseeclient.DisplayClientInfo(textField1.getText());
    }

    private void onCancel() {
        // add your code here if necessary
        Main_Menu mm=new Main_Menu();
        Destroy_ClientInfo_Window();
        mm.destroy_windows();
        mm.main_display();
    }
    //------------------------------------------------------------------------------------------------------------------
    void Destroy_ClientInfo_Window()
    {
        this.dispose();
    }
    void Display_ClientInfo_Window()
    {
        Display_Client_Info dialog = new Display_Client_Info();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
