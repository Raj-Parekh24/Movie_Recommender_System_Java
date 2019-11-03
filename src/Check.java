import java.io.EOFException;
import java.io.FileNotFoundException;
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
                  try {
                      Login lg = new Login();
                  }catch (FileNotFoundException ex){
                      System.out.println("No one is registered till now.\nSo,please create accounts");
                  }
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
