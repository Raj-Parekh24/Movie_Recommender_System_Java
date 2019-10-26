import java.util.Scanner;

public class Check {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        boolean ch=false;
        String us=new String();
        String p=new String();
        User us1 = new SignUp();
        while(ch!=true){
            System.out.println("Enter a Username");
            us=sc.nextLine();
            ch=us1.usname(us);
        }
        ch=false;
        while(ch!=true){
            System.out.println("Enter a Phone number!");
            us=sc.nextLine();
            ch=us1.pho(us);
        }
        ch=false;
        while(ch!=true){
            System.out.println("Enter a Email Address!");
            us=sc.nextLine();
            ch=us1.emal(us);
        }
        ch=false;
        while(ch!=true){
            System.out.println("Enter a Password!");
            us=sc.nextLine();
            ch=us1.pass(us);
        }
        ch=false;
        while(ch!=true){
            System.out.println("Confirm Your Password!");
            us=sc.nextLine();
            ch=us1.Confirmpass(us);
        }
    }
}
