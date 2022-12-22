package Banking3;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client
{
    public Client()
    {}
    public String ID;
    public float amount;
    public Person persondetails;
    public List<Account> AcoList=new ArrayList<>();
    static int count;


    public Client(Person p)
    {
        persondetails = p;
        count+= 1;
        ID = "CID-"+count;
        Bank.ClList.add(this);
    }
    public void addtofile()
    {
        File clientadd=new File("src/Banking3/customerss.txt");
        try
        {
            Scanner scn=new Scanner(clientadd);
            while(scn.hasNextLine())
            {
                count=0;
                String s[]=scn.nextLine().split(",");
                String ss[]=new String[s[1].length()];
                ss= s[1].split("");
                long NLine=-1;
                try(LineNumberReader linenmr= new LineNumberReader(new FileReader(new File("src/Banking3/customerss.txt"))))
                {
                    linenmr.skip(Long.MAX_VALUE);
                    count+=linenmr.getLineNumber()+1;
                }
                ID = "CID-"+count;

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        intofile();
    }
    void intofile()
    {
        try
        {
            FileWriter fos=new FileWriter("src/Banking3/customerss.txt",true);
            fos.write(this.persondetails+","+ID+"\n");
            fos.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }
    }


    public String toString()//displays the personal info
    {
        return String.valueOf(getPersondetails());
    }
    public float withdraw(float amount,String accNo)
    {
        for (Account account :AcoList)
        {
            if (accNo.equals(account.number))
            {
                account.withdraw(amount);
                return account.amount;
            }
        }
        return 0;
    }
    public float deposit(float amount,String accNo)
    {
        for (Account account:AcoList){
            if (accNo.compareTo(account.number) == 0){
                account.deposit(amount);
                return account.amount;
            }
        }
        return 0;
    }
    public void addAccount(int nuber, Account a)
    {
        AcoList.add(a);

    }

    float totalam=0;
    float totalAmount()
    {
        for (Account account:AcoList)
        {
            totalam += account.amount;
        }
        return totalam;
    }



    public void setPersondetails(Person persondetails) {
        this.persondetails = persondetails;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Person getPersondetails()
    {
        return persondetails;
    }


    public String getID()
    {
        return ID;
    }










}
