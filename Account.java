package Banking3;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.util.*;
public class Account
{

    String number;
    float amount;
    Client ACholder;
    int acount;
    public String Id;


    Account(float amt,Client c)
    {
        acount +=1;
        this.number = ("AID-"+ acount);
        this.amount = amt;
        this.ACholder = c;
        Bank.AcList.add(this);
        c.AcoList.add(this);

    }
    Account()
    {}
    void addacounttofile()
    {
        File accountadd =new File("src/Banking3/Accounts.txt");
        try
        {
            Scanner scn=new Scanner(accountadd);
            while(scn.hasNextLine())
            {
                acount =0;
                String s[]=scn.nextLine().split(",");
                String ss[]=new String[s[1].length()];
                ss= s[1].split("");
                long NLine=-1;
                try(LineNumberReader linenmr= new LineNumberReader(new FileReader(new File("src/Banking3/Accounts.txt"))))
                {
                    linenmr.skip(Long.MAX_VALUE);
                    acount +=linenmr.getLineNumber()+1;
                }


            }Id = "AID-"+ acount;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        filehan();

    }
    void filehan()
    {
        try
        {
            FileWriter fos=new FileWriter("src/Banking3/Accounts.txt",true);
            fos.write(this.ACholder+","+Id+","+amount+","+"\n");
            fos.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }
    }


    void depositspecial()
    {
        File accountadd =new File("src/Banking3/Accounts.txt");
        try
        {
            Scanner scn=new Scanner(accountadd);
            while(scn.hasNextLine())
            {
                acount =0;
                String s[]=scn.nextLine().split(",");
                String ss[]=new String[s[1].length()];
                ss= s[1].split("");
                long NLine=-1;
                try(LineNumberReader linenmr= new LineNumberReader(new FileReader(new File("src/Banking3/Accounts.txt"))))
                {
                    linenmr.skip(Long.MAX_VALUE);
                    acount +=linenmr.getLineNumber()+1;
                }

            }Id = "AID-"+ acount;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        fileinputfordepositspecial();
    }
    void fileinputfordepositspecial()
    {
        try
        {
            FileWriter fos=new FileWriter("src/Banking3/Accounts.txt",true);
            fos.write(this.ACholder+","+Id+","+amount+","+"\n");
            fos.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();

        }
    }




    float withdraw(float amount)
    {
        this.amount=this.amount-amount;
        return this.amount;

    }
    float deposit(float amount)
    {
        this.amount=this.amount+amount;
        return this.amount;
    }
    public String toString()
    {
        return "Account No.: "+this.number+"Total Amount: "+this.amount;
    }


    public void setNumber(String number) {
        this.number = number;
    }


    float amount(){
        return this.amount;
    }

    public void setAmount(float amount)
    {
        this.amount = amount;
    }
    public float getAmount()
    {
        return amount;
    }


    public String getNumber() {
        return number;
    }



}
