package Banking3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver
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


    public static void main(String args[])
    {
        Bank bank=new Bank("MyBank");
        //the department only exists in the university
        writepeoples();
        loadPeople();
        loadCustomers();
        loadAccounts();
        Scanner input = new Scanner(System.in);
        String choice="";
        while(choice.compareTo("F")!=0)
        {
            System.out.println("Enter the following \n C - adding clients \n A - adding account");
            System.out.println(" W - withdrawing money \n D - deposit money \n I - client Info \n B- Bank's Info ");
            System.out.println(" X - Account detail \n F - exit");
            switch(input.next())
            {
                case "C":
                {
//                    bank.addcl("77");
                    break;
                }
                case "A":
                {
//                    bank.addac();
                    break;
                }

                case "B":
                {
                    System.out.println(bank);
                    break;
                }
                case "F":
                {
                    System.exit(1);
                }
                case"D":
                {
//                    bank.DepositInFile();
                    break;
                }
                case"W":
                {
//                    bank.WithdrawFromFile();
                    break;
                }
                case"I":
                {
//                    bank.DisplayClientInfo();
                    break;
                }
                case"X":
                {
//                    bank.DisplayAccountInfo();
                    break;
                }
                default:
                    System.out.println("Enter valid input");

            }
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
}