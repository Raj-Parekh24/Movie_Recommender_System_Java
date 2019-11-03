import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Check {
    public static void main(String[] args) throws Exception {
      Scanner sc=new Scanner(System.in);
      boolean chk=true;
      do{
          clearScreen();
          System.out.println("For Sign Up press 1 :-\nFor login press 2:- \nFor quit press 3:- ");
          int x=sc.nextInt();
          switch(x){
              case 1: {
                  SignUp sp=new SignUp();
                  sp.detailsToFile();
                  break;
              }
              case 2:{
                  Login lg=new Login();
                  break;
              }
              case 3: chk=false;
          }
      }while(chk);
}

    public static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
