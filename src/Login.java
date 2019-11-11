import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Login {
    private String uemail,upassword;
    private WriteToFile writeToFile=new WriteToFile();

    Login() throws Exception {
        Scanner sc=new Scanner(System.in);
        if(checkForUserSignedIn()){
            System.out.println("Some User is Already Signed in");
            System.out.println("SIGN OUT Press 1 :- \nElse we are closing the application");
            int c=sc.nextInt();
            if(c==1)
            {
                signOut();
            }
            else {
                System.out.println("Terminatting");
                System.exit(0);
            }
        }
        else {
            getDetailsFromUser();
            searchEmailId();
        }
    }

    void searchEmailId() throws Exception {
        ArrayList<SignUp> signUps = writeToFile.readFile();
        boolean checke = true, checkp = true;
        int index=0;
           do {
               for (SignUp i : signUps) {
                   if (i.getEmail().equals(getUemail())) {
                       do {
                           checke=false;
                           if (i.getPasswd().equals(getUpassword())) {
                               checkp = false;
                               System.out.println("Logged in Successfully");
                               i.setLoginStatus(true);
                               writeToFile.fileWrite(writeToFile.readFile(),i,index);//this will make changes to file
                               MovieSuggester movieSuggester=new MovieSuggester(i);
                               movieSuggester.getMenuDrive();
                               break;
                           }
                           else {
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
                   index=0;
               }
           } while(checke);
    }

    public boolean checkForUserSignedIn() throws IOException, ClassNotFoundException {
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

    private void getDetailsFromUser()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your registered email id :- ");
        setUemail(sc.nextLine());
        System.out.println("Enter your password :-");
        setUpassword(sc.nextLine());
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public void signOut() throws IOException, ClassNotFoundException {
        boolean a=false;
        ArrayList<SignUp> users=writeToFile.readFile();
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).isLoginStatus())
            {
                users.get(i).setLoginStatus(false);
                writeToFile.fileWrite(writeToFile.readFile(),users.get(i),i);
            }
        }
    }


}
