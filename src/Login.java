import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Login {
    String uemail,upassword;
    WriteToFile writeToFile=new WriteToFile();

    Login(String uemail, String upassword) {
        this.uemail = uemail;
        this.upassword = upassword;
    }

    void searchEmailId() throws IOException, ClassNotFoundException {
        ArrayList<SignUp> signUps = writeToFile.readFile();
        boolean checke = true, checkp = true;
        do {
            for (SignUp i : signUps) {
                if (i.getEmail().equals(uemail)) {
                    do {
                        checke=false;
                        if (i.getPasswd().equals(upassword)) {
                            checkp = false;
                            System.out.println("Logged in successfully");
                            break;
                        } else {
                            System.out.println("Please enter your password correctly");
                            Scanner s = new Scanner(System.in);
                            upassword = s.nextLine();
                        }
                    } while (checkp);
                }
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
