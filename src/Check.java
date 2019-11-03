import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Check {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
      Scanner sc=new Scanner(System.in);

      boolean chk=true;
      do{
          System.out.println("Do You Want to Sign Up or Login: 1.Sign Up 2.Login 3.QUIT");
          int x=sc.nextInt();
          switch(x){
              case 1: SignUp sp=new SignUp();
                        sp.detailsToFile();
                        break;
              case 2: Login lg=new Login();
                        break;
              case 3: chk=false;
          }
      }while(chk);

}
}
