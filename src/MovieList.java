import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieList{

    protected ArrayList<ArrayList<String>> allMovielist = new ArrayList<ArrayList<String>>();
    protected ArrayList<String> handler =new ArrayList<String>();
    protected SignUp user;

    public MovieList(SignUp signUp)
    {
        genreAdd();
        user=signUp;
        if(user.movieSeen==null)
        {
            user.movieSeen= new HashMap<String,Integer>();
            intialValue();
        }
    }

    private void intialValue()
    {
         for(ArrayList<String> m:allMovielist){
             user.movieSeen.put(m.get(0),0);
         }
     }

    private void genreAdd()
    {
       addAction();
       addComedy();
       addRomance();
       addHorror();
       addSciFi();
    }

    void searchDisplayGenres(){
        System.out.println("Please Enter Your Choice:");
        System.out.println("1. Action 2.Comedy 3.Romance 4.Horror 5.SciFi");
    }

    void searchDisplayMoviesThroughGenre(int x) throws Exception{
        //System.out.println(x);
        if (x>=1 && x<=55) {
            for (int i=1; i<allMovielist.get(x-1).size(); i++) {
                System.out.println(allMovielist.get(x-1).get(i));
            }
        }
        else {
            throw new Exception("Genre not found");// over here replace myexception object
        }
        //System.out.println(allMovielist.get(0).get(0));
        play((allMovielist.get(x-1).get(0)));
        //over here it throws eof exception
    }
    boolean play(String mvname) throws IOException, ClassNotFoundException {
        boolean r=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("Do you Want to Play it: 1.YES  2.NO ");
        int x=sc.nextInt();
        if(x==1) {
            mapUpdate(mvname);
            r = false;
        }
        else{
            System.out.println("We are directing you to Main Menu");
            r=true;
        }return r;
    }
    boolean searchMovies(String s) throws IOException, ClassNotFoundException {
        boolean x=true;
        boolean r=false;
        for(ArrayList<String> i:allMovielist)
        {
            for(String check:i)
            {
                if(check.equals(s))
                {
                    System.out.println("Movie Found SuccessFully");
                    x=false;
                    //code to add it to map
                    String a=getGenreType(s);
                    System.out.println("It is of "+a+" Genre");
                    if(play(a))
                        r=true;

                }
            }
        }
        if(x)
        {
            System.out.println("No Such Movie Found");
        }
        return r;
    }

    boolean searchMoviesExist(String s)
    {
        boolean x=false;
        for(ArrayList<String> i:allMovielist)
        {
            for(String check:i)
            {
                if(check.equals(s))
                {
                    x=true;
                    //code to add it to map
                    break;
                }
            }
        }
        return x;
    }

    public String getGenreType(String movie)
    {
        String s=null;
        for(ArrayList<String> x:allMovielist)
        {
            for(String i:x)
            {
                if(i.equals(movie))
                {
                    s= x.get(0);
                    break;
                }
            }
        }
        if(s==null) {
            return "No such movie found";
        }
        else return s;
    }

    public void mapUpdate(String genre) throws IOException, ClassNotFoundException {
        if(genre.equals("No such movie found")){
            return;
        }
        Map<String,Integer> userData=user.getMovieSeen();
        Map<String,Integer> update=new HashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : userData.entrySet()) {
           if(entry.getKey().equals(genre)){
               update.put(entry.getKey(),entry.getValue()+1);
           }
           else {
               update.put(entry.getKey(),entry.getValue());
           }
        }
        user.setMovieSeen(update);
        update=user.getMovieSeen();
        for(Map.Entry<String,Integer> x :update.entrySet()){
            System.out.println(x.getKey()+"  "+x.getValue());
        }
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.fileWrite(writeToFile.readFile(),user,user.getEmail());
    }

    private void addAction()
    {
        handler.add("Action Movies");
        handler.add("Watchman");
        handler.add("Terminator: Dark Fate");
        handler.add("Star Wars: The Rise of Skywalker");
        handler.add("Zombieland: Double Tap");
        handler.add("El Camino: A Breaking Bad Movie");
        handler.add("Daybreak");
        handler.add("Batwoman");
        allMovielist.add(handler);
        handler=null;
    }

    private void addComedy()
    {
        handler =new ArrayList<String>();
        handler.add("Comedy Movies");
        handler.add("The Laundromat");
        handler.add("Living with Yourself ");
        handler.add("Zombieland: Double Tap");
        handler.add("Modern Love");
        handler.add("Hocus Pocus");
        handler.add("The Boys");
        handler.add("Once Upon a Time in Hollywood");
        allMovielist.add(handler);
        handler=null;
    }

    private void addRomance()
    {
        handler =new ArrayList<String>();
        handler.add("Romantic Movies");
        handler.add("Game of Thrones");
        handler.add("Big Mouth");
        handler.add("Friends");
        handler.add("The King");
        handler.add("Maleficent");
        handler.add("Vikings");
        handler.add("Riverdale");
        allMovielist.add(handler);
        handler=null;
    }

    private void addHorror()
    {
        handler =new ArrayList<String>();
        handler.add("Horror Movies");
        handler.add("Zombieland: Double Tap");
        handler.add("The Walking Dead");
        handler.add("American Horror Story");
        handler.add("Supernatural");
        handler.add("It Chapter Two");
        handler.add("Stranger Things");
        handler.add("3 from Hell");
        allMovielist.add(handler);
        handler=null;
    }

    private void addSciFi()
    {
        handler =new ArrayList<String>();
        handler.add("Sci-Fi Movies");
        handler.add("Watchmen");
        handler.add("Star Wars: The Rise of Skywalker");
        handler.add("Bloodshot");
        handler.add("Arrow");
        handler.add("The Flash");
        handler.add("Avengers: Endgame");
        handler.add("Black Mirror");
        handler.add("InterStellar");
        handler.add("Inception");
        handler.add("Arrival");
        handler.add("Ad Stra");
        allMovielist.add(handler);
        handler=null;
    }

}
