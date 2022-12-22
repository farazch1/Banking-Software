package Banking3;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank
{

    String name;
    public Bank(String bankname)
    {
        this.name=bankname;
    }

    public static List<Client> ClList=new ArrayList<>();
    static ArrayList<Account> AcList = new ArrayList<>();

    public void addcl(String pcnc)
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            File readperso=new File("src/Banking3/Persons.txt");
            Scanner rsc=new Scanner(readperso);
            String stores="";
            while(rsc.hasNextLine())
            {
                String readedpersons = rsc.nextLine();
                stores =stores+ readedpersons;
            }
            String spl[]=stores.split(",");

            String pcnic = pcnc;
            int i=1;
            while(i<stores.length())
            {
                int pe=11*i-6;
                try {
                    if (pcnic.compareTo(spl[pe]) == 0)
                    {
                        Person p = new Person("Customer{,Name,"+spl[pe-3],",CNIC:,"+spl[pe],",Number: ,"+spl[pe+3]+",}");
                        Client c = new Client(p);
                        c.addtofile();
                        JOptionPane.showMessageDialog(null,"Person is Added as Customer/Client Successfully! ");
                        System.out.println("Person is Added as Customer/Client Successfully! ");
                        System.out.println(p);
                        break;
                    }
                    else {
                        i++;

                    }
                }catch (ArrayIndexOutOfBoundsException exp)
                {
                    JOptionPane.showMessageDialog(null,"No Such Person Found!");
                    System.out.println("No Such Person Found!");
                    break;
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }
    public void addac(String customerscnicforcheck,int ammountotdeposit)
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            File readperso=new File("src/Banking3/customerss.txt");
            Scanner rsc=new Scanner(readperso);
            String stores="";
            while(rsc.hasNextLine())
            {
                String readedpersons = rsc.nextLine();
                stores =stores+ readedpersons;
            }
            String spl[]=stores.split(",");
            String pcnic = customerscnicforcheck;
            int i=1;
            while(i<stores.length())
            {
                int pe=8*i-4;
                try {
                    if (pcnic.compareTo(spl[pe]) == 0)
                    {
                        Person p = new Person("Account{,Name,"+spl[pe-2],",CNIC:,"+spl[pe],",Number: ,"+spl[pe+2]+",}");
                        Client c = new Client(p);
                        float amuent=ammountotdeposit;
                        Account acac=new Account(amuent,c);
                        acac.addacounttofile();
                        JOptionPane.showMessageDialog(null,"Client's Account has been created Successfully!");
//                        System.out.println("Client's Account has been created Successfully!");
                        break;
                    }
                    else {
                        i++;

                    }
                }catch (ArrayIndexOutOfBoundsException exp)
                {
                    JOptionPane.showMessageDialog(null,"No Such Customer Found on this CNIC!");
//                    System.out.println("No Such Customer Found on this CNIC!");
                    break;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }


    void DepositInFile(String mokCNIC,String Real_AID,int Deposit_amount)
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            File readperso=new File("src/Banking3/Accounts.txt");
            Scanner rsc=new Scanner(readperso);
            String stores="";
            while(rsc.hasNextLine())
            {
                String readedpersons = rsc.nextLine();
                stores =stores+ readedpersons;
            }
            String spl[]=stores.split(",");
            System.out.println("Enter CNIC of Account: ");
            String mok=mokCNIC;
            System.out.println("Enter Account ID: ");
            String pcnic = Real_AID;
            float oldamount;
            float newamount;
            float updatedamount;
            int i=1;
            while(i<stores.length())
            {
                int pe=10*i-2;
                try {
                    if (pcnic.compareTo(spl[pe]) == 0)
                    {
                        oldamount= Float.parseFloat(spl[pe+1]);
                        System.out.println("Enter Deposit Amount: ");
                        newamount=Deposit_amount;
                        updatedamount=oldamount+newamount;
                        spl[pe+1]= String.valueOf(updatedamount);
                        JOptionPane.showMessageDialog(null,"The Money Has Been Deposited");
                        System.out.println("The Money Has been deposited ");
                        break;
                    }
                    else {
                        i++;

                    }

                }catch (ArrayIndexOutOfBoundsException exp)
                {
                    System.out.println("No Such Account Found!");
                    break;
                }

            }
            try {
                PrintWriter writer = new PrintWriter("src/Banking3/Accounts.txt");
                writer.print("");
// other operations
                writer.close();
                int nemeq;
                int Cneq;
                int numbereq;
                int balanceeq;
                float blanacer;
                for (int itr=1;itr<spl.length;itr++)
                {
                    nemeq=10*itr-8;
                    Cneq=10*itr-6;
                    numbereq=10*itr-4;
                    balanceeq=10*itr-1;
                    Person p = new Person("Account{,Name,"+spl[nemeq],",CNIC:,"+spl[Cneq],",Number: ,"+spl[numbereq]+",}");
                    Client c = new Client(p);
                    blanacer= Float.parseFloat(spl[balanceeq]);
                    Account acac=new Account(blanacer,c);
                    acac.depositspecial();

                }

            }catch (ArrayIndexOutOfBoundsException exp)
            {
                System.out.println("No Such Customer Found on this CNIC!");
            }
            System.out.println(spl[20]);


        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }

    void WithdrawFromFile(String mokCNIC,String Real_AID,int Withdraw_amount)
    {
        {
            try
            {
                Scanner sc=new Scanner(System.in);
                File readperso=new File("src/Banking3/Accounts.txt");
                Scanner rsc=new Scanner(readperso);
                String stores="";
                while(rsc.hasNextLine())
                {
                    String readedpersons = rsc.nextLine();
                    stores =stores+ readedpersons;
                }
                String spl[]=stores.split(",");
                String mok=mokCNIC;
                String pcnic = Real_AID;
                float oldamount;
                float newamount;
                float updatedamount;
                int i=1;
                while(i<stores.length())
                {
                    int pe=10*i-2;
                    try {
                        if (pcnic.compareTo(spl[pe]) == 0)
                        {
                            oldamount= Float.parseFloat(spl[pe+1]);
                            newamount=Withdraw_amount;
                            updatedamount=oldamount-newamount;
                            spl[pe+1]= String.valueOf(updatedamount);
                            JOptionPane.showMessageDialog(null,"The Money Has Been Withdrawn");
                            System.out.println("The Money Has been Withdrawn");
                            break;
                        }
                        else {
                            i++;

                        }

                    }catch (ArrayIndexOutOfBoundsException exp)
                    {
                        JOptionPane.showMessageDialog(null,"No Such Account Found!(Task Done)");
                        System.out.println("No Such Account Found!(Task Done)");
                        break;
                    }

                }
                try {
                    PrintWriter writer = new PrintWriter("src/Banking3/Accounts.txt");
                    writer.print("");
// other operations
                    writer.close();
                    int nemeq;
                    int Cneq;
                    int numbereq;
                    int balanceeq;
                    float blanacer;
                    for (int itr=1;itr<spl.length;itr++)
                    {
                        nemeq=10*itr-8;
                        Cneq=10*itr-6;
                        numbereq=10*itr-4;
                        balanceeq=10*itr-1;
                        Person p = new Person("Account{,Name,"+spl[nemeq],",CNIC:,"+spl[Cneq],",Number: ,"+spl[numbereq]+",}");
                        Client c = new Client(p);
                        blanacer= Float.parseFloat(spl[balanceeq]);
                        Account acac=new Account(blanacer,c);
//                        acac.depositspecial();
                        acac.addacounttofile();

                    }

                }catch (ArrayIndexOutOfBoundsException exp)
                {
                    System.out.println("Done!");
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();

            }
        }
    }

    void DisplayClientInfo(String CCNICC)
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            File readperso=new File("src/Banking3/customerss.txt");
            Scanner rsc=new Scanner(readperso);
            String stores="";
            while(rsc.hasNextLine())
            {
                String readedpersons = rsc.nextLine();
                stores =stores+ readedpersons;
            }
            String spl[]=stores.split(",");
            System.out.println("Enter CNIC of Client to View Info: ");
            String pcnic = CCNICC;
            int i=1;
            while(i<stores.length())
            {
                int pe=8*i-4;
                try {
                    if (pcnic.compareTo(spl[pe]) == 0)
                    {
                        Person p = new Person("Customer{,Name,"+spl[pe-2],",CNIC:,"+spl[pe],",Number: ,"+spl[pe+2]+",}");
                        JOptionPane.showMessageDialog(null,p,"Client Found",1,null);
                        break;
                    }
                    else {
                        i++;

                    }
                }catch (ArrayIndexOutOfBoundsException exp)
                {
                    JOptionPane.showMessageDialog(null,"No Such Client Found","Client Not Found",1,null);
                    break;
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }


    void DisplayAccountInfo(String AcdaNumber)
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            File readperso=new File("src/Banking3/Accounts.txt");
            Scanner rsc=new Scanner(readperso);
            String stores="";
            while(rsc.hasNextLine())
            {
                String readedpersons = rsc.nextLine();
                stores =stores+ readedpersons;
            }
            String spl[]=stores.split(",");
            System.out.println("Enter CNIC of Accounts to View Info: ");
            String pcnic = AcdaNumber;
            int i=1;
            while(i<stores.length())
            {
                int pe=10*i-6;
                try {
                    if (pcnic.compareTo(spl[pe]) == 0)
                    {
                        Person p = new Person("Account{,Name,"+spl[pe-2],",CNIC:,"+spl[pe],",Number: ,"+spl[pe+2]+",}");
                        System.out.println();
                        JOptionPane.showMessageDialog(null,p+"ID:"+spl[pe+4]+","+"Ammount:"+spl[pe+5],"Account Found",1,null);
                        break;
                    }
                    else {
                        i++;

                    }
                }catch (ArrayIndexOutOfBoundsException exp)
                {
                    System.out.println("No Such Person Found!");
                    break;
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }

    Client addClient(Person p)
    {
        Client c = new Client(p);
        return c;
    }
    Account addAccount(float amount , Client c)
    {
        Account accc=new Account(amount,c);
        return accc;

    }
    Boolean removeClient(String id)
    {
        boolean del=true;
        for (Client client : ClList)
        {
            if ((client.ID).compareTo(id) == 0)
            {
                ClList.remove(client);
                return true;

            }
        }return false;
    }


    float sum=0;
    float totalAmount()
    {
        for (Client client:ClList){
            for (Account account:client.AcoList){
                sum += account.amount();
            }
        }
        return sum;
    }

    Account searchAccount(String id)
    {
        for (Account account : AcList)
        {
            if (account.getNumber().compareTo(id)==0)
            {
                return account;
            }

        }
        return null;
    }

    Client searchCustomerDetail(String CNIC)
    {
        for (Client cln : ClList)
        {
            if (cln.persondetails.getCNIC().equals(CNIC))
            {
                return cln;
            }

        }
        return null;
    }
    public String toString()
    {
        String disp = "";
        for (Client client :ClList)
        {
            disp += ("\n-------------\n");
            disp += (client +"");
            for (Account account: client.AcoList)
            {
                disp += account+"\n------\n";
            }
            disp += ("\n\n");
        }
        return disp;
    }

}
