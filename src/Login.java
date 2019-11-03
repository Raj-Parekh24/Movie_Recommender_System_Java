import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Login {
    private String uemail,upassword;
    private WriteToFile writeToFile=new WriteToFile();

    Login(String uemail, String upassword) {
        this.uemail = uemail;
        this.upassword = upassword;
    }
    void searchEmailId() throws IOException, ClassNotFoundException {
        ArrayList<SignUp> signUps = writeToFile.readFile();
        boolean checke = true, checkp = true;
        int index=0;
       if(checkForUserSignedIn())//check wether some user is their or not
       {
           System.out.println("Some user has already logged in. ");
       }
       else {
           do {
               for (SignUp i : signUps) {
                   if (i.getEmail().equals(uemail)) {
                       do {
                           checke=false;
                           if (i.getPasswd().equals(upassword)) {
                               checkp = false;
                               System.out.println("Logged in successfully");
                               i.setLoginStatus(true);
                               writeToFile.fileWrite(writeToFile.readFile(),i,index);//this will make changes to file

                               break;
                           } else {
                               System.out.println("Please enter your password correctly");
                               Scanner s = new Scanner(System.in);
                               upassword = s.nextLine();
                           }
                       } while (checkp);
                   }
                   index++;// checks for the users index
               }
               if(checke)
               {
                   System.out.println("Please enter your email id correctly");
                   Scanner s = new Scanner(System.in);
                   uemail = s.nextLine();
               }
           } while(checke);
       }
    }

    private boolean checkForUserSignedIn() throws IOException, ClassNotFoundException {
        boolean a=false;
        ArrayList<SignUp> users=writeToFile.readFile();
        for(SignUp i:users)
        {
            if(i.isLoginStatus()) {
                a = true;
                break;
            }
        }
        return a;
    }

}
