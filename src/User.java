public abstract class User {
    private String username;
   private String email;
    private String passwd;
    private String phone;
   public abstract boolean usname(String a);
    public abstract boolean emal(String a);
    public abstract boolean pass(String a);

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public abstract boolean pho(String a);
    public abstract boolean Confirmpass(String a);
}
