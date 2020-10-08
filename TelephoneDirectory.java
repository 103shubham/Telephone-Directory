import java.io.*;
import java.util.Scanner;
import java.util.Formatter;
public class TelephoneDirectory{

    public String name;
    public long number;
    public String city;

    Scanner s = new Scanner(System.in);

    public TelephoneDirectory() {};
    public TelephoneDirectory(String name, long number, String city){
        this.name = name;
        this.number = number;
        this.city = city;
    }

    public String setName(){
        String tel_name;
        tel_name =s.nextLine();
        return tel_name;
    }


    public long setNumber(){
        long tel_number;
        tel_number = s.nextLong();
        return tel_number;
    }


    public String setCity(){
        String tel_city;
        tel_city = s.next();
        return tel_city;
    }

    public static void main(String args[]){
        int num;
        String td_name;
        long td_number;
        String td_city;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no. of the data you want to enter");
        num = s.nextInt();

        for(int i=1;i<=num;i++){
            TelephoneDirectory td = new TelephoneDirectory();

            System.out.println("Enter the Name, Phone No. and City for person "+i);
            td_name = td.setName();
            td_number = td.setNumber();
            td_city = td.setCity();

            System.out.println("Name :- "+td_name);
            System.out.println("Phone No :- "+td_number);
            System.out.println("City :- "+td_city);

            try(FileWriter fw = new FileWriter("TelephoneDirectory.txt", true);
                BufferedWriter bf =  new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bf);){
                  //  pw.println(td_name +"\t\t\t\t"+td_number+"\t\t\t\t"+td_city);
                  pw.format("\n%-20s %10s %25s",td_name,td_number,td_city);
                }
                catch(IOException e){
                    e.printStackTrace();
                }



        }
    }




}
