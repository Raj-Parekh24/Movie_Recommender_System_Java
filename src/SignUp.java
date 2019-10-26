public class SignUp extends User {
    private String ConfirmationString;
    private boolean rr = false;

   public boolean Confirmpass(String b) {
        if ((b.equals(ConfirmationString))) {
            setPasswd(b);
            System.out.println("Password Confirmed Successfully!");
            rr = true;
        }
        return rr;
    }

   private boolean onedigi(String a) {

        int f = 1;
        for (int i = 0; i < a.length(); i++) {
            if ((a.charAt(i) >= 48 && a.charAt(i) <= 57)) f = 0;

        }
        if (f == 0) return true;
        else return false;
    }

    private boolean oneCAp(String a) {

        int f = 1;
        for (int i = 0; i < a.length(); i++) {
            if ((a.charAt(i) >= 65 && a.charAt(i) <= 91)) f = 0;

        }
        if (f == 0) return true;
        else return false;
    }

    public boolean pass(String a) {
        boolean rr = false;
        int f = 1;
        try {
            if (a.length() == 0) {
                throw new NullPointerException();
            } else if (!onedigi(a)) {
                throw new MyException("Atleast one Digit should be there in Password!");
            } else if (!oneCAp(a)) {
                throw new MyException("Atleast one Capital Alphabet should be there in Password!");
            } else {
                ConfirmationString = a;
                System.out.println("Password Entered Successfully and Now Please Confirm it down!");
                f = 0;
            }
        } catch (NullPointerException e) {
            System.out.println("Enter a Valid Password!   ");
        } catch (MyException d) {
            System.out.println(d.getMessage());
        }
        if (f == 0)
            return true;
        else
            return false;
    }

    private boolean domain(String a) {
        String b = "@gmail.com";
        int c = 0;
        boolean r = true;
        if(!a.contains(b))
            r=false;
        return r;
    }

    public boolean emal(String a) {
        int f = 1;
        try {
            if (a.length() == 0) {
                throw new NullPointerException();
            } else if (!domain(a)) {
                throw new MyException("Enter a Valid Domain!");
            } else {
               setEmail(a);
                System.out.println("Email Added Successfully!");
                f = 0;
            }
        } catch (NullPointerException e) {
            System.out.println("Enter a Valid Email!   ");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        if (f == 0)
            return true;
        else
            return false;
    }

    public  boolean usname(String a) {
        int f = 1;
        try {
            if (a.length() == 0) {
                throw new NullPointerException();
            } else {
                setUsername(a);
                System.out.println("Username Registered Successfully!");
                f = 0;
            }
        } catch (NullPointerException e) {
            System.out.println("Enter a Valid Username!   ");
        }
        if (f == 0)
            return true;
        else
            return false;
    }

    private   boolean numOrStr(String a) {
        boolean f = true;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) >= 48 && a.charAt(i) <= 57) ;
            else f = false;
        }
        return f;
    }

    public boolean pho(String a) {
        int f = 1;
        try {

            if (a.length() == 0) {
                a = null;
                System.out.println(a.length());
            } else if (a.length() != 10) {
                throw new MyException("Enter a Valid Phone Number of 10 Digits!   ");
            } else if (!numOrStr(a)) {
                throw new MyException("Enter Only Digits i.e 0 to 9!");
            } else {
                setPhone(a);
                System.out.println("Phone Number Added Successfully!");
                f = 0;
            }
        } catch (NullPointerException e) {
            System.out.println("Enter a Valid Phone Number!   ");
        } catch (MyException dd) {
            System.out.println(dd.getMessage());
        }
        if (f == 0) return true;
        else return false;
    }
}