package Banking3;

import javax.swing.*;
import java.awt.event.*;

public class Withdraw_Window extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public Withdraw_Window() {
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

    Bank BankObjectToWithdrawMoney=new Bank("HBL");

    private void onOK() {
        // add your code here
        BankObjectToWithdrawMoney.WithdrawFromFile(textField1.getText(),textField2.getText(),Integer.parseInt(textField3.getText()) );

    }

    private void onCancel()
    {
        Main_Menu mm=new Main_Menu();
        Destroy_Withdraw_Window();
        mm.destroy_windows();
        mm.main_display();
    }

    //------------------------------------------------------------------------------------------------------------------
    void Destroy_Withdraw_Window()
    {
        this.dispose();
    }
    void Display_Withdraw_Window()
    {
        Withdraw_Window dialog = new Withdraw_Window();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
