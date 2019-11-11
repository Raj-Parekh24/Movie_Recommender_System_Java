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
      do    {
          clearScreen();
          System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
          System.out.println("SIGN UP press 1   |   LOGIN press 2   |    QUIT press 3:- ");
          System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
          int x=sc.nextInt();
          try{
              if(x!=1 && x!=2 && x!=3)
                  throw new Exception("Please Enter a Valid Input!");
          }catch (Exception e){
              System.out.println(e.getMessage());
          }
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
                      System.out.println("No One is Registered till now.\nSo,Please Create a account");
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
