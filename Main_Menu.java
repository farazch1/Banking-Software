package Banking3;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_Menu extends JDialog
{
    private static List<Person> persons = new ArrayList<Person>();
    private static Person  searchPerson(String ID)
    {
        for(Person p:persons)
        {
            if(p.getCNIC().compareTo(ID)==0)
                return p;
        }
        return null;
    }
    private static void loadPeople()
    {
        try {
            File file = new File("src/Banking3/Persons.txt");
            Scanner sc = new Scanner(file);

// read() method : reading and printing Characters
            // one by one
            while (sc.hasNextLine())
            {
                String l=sc.nextLine();
                String st[]=l.split(" ");
                Person p=new Person(st[0],st[1],st[2]);
                persons.add(p);

            }}
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    private static void writepeoples()
    {
        try
        {
            FileWriter clientadd=new FileWriter("src/Banking3/Persons.txt",false);
            clientadd.write("Person{,"+"Name=',Hina Khalid,', CNIC=',2345,', number=',03004511752,'"+",},\n" +
                    "Person{,"+"Name=',Hassan,', CNIC=',2343,', number=',0301411534,'"+",},\n"+
                    "Person{,"+"Name=',Kashif,', CNIC=',4444,', number=',0301411534,'"+",},");
            clientadd.close();
        }
        catch (Exception e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
    }

    private static void loadCustomers()
    {
        Bank bank = new Bank("MyBank");

        try
        {
            File readperso=new File("src/Banking3/customerss.txt");
            Scanner rsc=new Scanner(readperso);
            String stores="";
            while(rsc.hasNextLine())
            {
                String readedpersons = rsc.nextLine();
                stores =stores+ readedpersons;
            }
            String spl[]=stores.split(",");
            int ni;
            int cn;
            int nu;
            for (int i=1;i<=stores.length();i++)
            {
                ni=8*i-6;
                cn =8*i-4;
                nu=8*i-2;
                Person p = new Person(spl[ni],spl[cn],spl[nu]);
                bank.addClient(p);
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static void loadAccounts()
    {
        Bank bank = new Bank("MyBank");

        try
        {
            File readperso=new File("src/Banking3/Accounts.txt");
            Scanner rsc=new Scanner(readperso);
            String stores="";
            while(rsc.hasNextLine())
            {
                String readedpersons = rsc.nextLine();
                stores =stores+ readedpersons;
            }
            String spl[]=stores.split(",");
            int ni;
            int cn;
            int nu;
            int acid;
            int ammounnt;
            for (int i=1;i<=stores.length();i++)
            {
                ni=10*i-8;
                cn =10*i-6;
                nu=10*i-4;
                acid=10*i-2;
                ammounnt=10*i-1;
                Person p = new Person(spl[ni],spl[cn],spl[nu]);
                Client bwq=new Client(p);
                bank.addAccount(Float.parseFloat(spl[ammounnt]),bwq);
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton addClientButton;
    private JButton addAccountButton;
    private JButton withdrawMoneyButton;
    private JButton depositMoneyButton;
    private JButton clientInfoButton;
    private JButton bankInfoButton;
    private JButton accountDetailsButton;
    private JButton exitButton;

    public Main_Menu() {
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

        addClientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {onAddClient();}
        });
        addAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onAddAccounts();

            }
        });
        withdrawMoneyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onWithdraw();

            }
        });
        depositMoneyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onDeposit();

            }
        });
        clientInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onShowClientData();

            }
        });
        bankInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onShowBankInfo();

            }
        });
        accountDetailsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onShowAccountDetailInfo();

            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Come Again Please!");
                dispose();

            }
        });




        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                destroy_windows();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                destroy_windows();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }
//----------------------------------------------------------------------------------------------------------------------
    add_cle ac=new add_cle();
    Add_Account_GUI Add_Account_For_MainScreen=new Add_Account_GUI();
    Withdraw_Window Withdraw_From_Account=new Withdraw_Window();
    Deposit_Window Deposit_In_account=new Deposit_Window();
    Display_Client_Info DSPIA=new Display_Client_Info();
    Account_Details ACDPIA=new Account_Details();
//----------------------------------------------------------------------------------------------------------------------
    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void onAddClient()
    {
        contentPane.setVisible(false);
        ac.display_addcle();
    }
    private void onAddAccounts()
    {
        contentPane.setVisible(false);
        Add_Account_For_MainScreen.Display_Add_Account_Window();
    }
    private void onWithdraw()
    {
        contentPane.setVisible(false);
        Withdraw_From_Account.Display_Withdraw_Window();

    }
    private void onDeposit()
    {
        contentPane.setVisible(false);
        Deposit_In_account.Display_Deposit_Window();

    }

    private void onShowClientData()
    {
        contentPane.setVisible(false);
        DSPIA.Display_ClientInfo_Window();
    }
    private void onShowBankInfo()
    {
        Bank BankObjectToSeeBank=new Bank("HBL");
        JOptionPane.showMessageDialog(null,BankObjectToSeeBank);

    }
    private void onShowAccountDetailInfo()
    {
        contentPane.setVisible(false);
        ACDPIA.Display_AccountInfos_Window();

    }







//----------------------------------------------------------------------------------------------------------------------
    void destroy_windows()
    {
        this.dispose();
    }


    void main_display()
    {
        Main_Menu dialog = new Main_Menu();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }



    public static void main(String[] args)
    {
        Bank bank=new Bank("MyBank");
        writepeoples();
        loadPeople();
        loadCustomers();
        loadAccounts();
        Main_Menu uperh=new Main_Menu();
        uperh.main_display();


    }
}
