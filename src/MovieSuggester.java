import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MovieSuggester extends MovieList {
    public MovieSuggester(SignUp signUp) {
        super(signUp);
    }

    private int indexOfGenre() {
        int y=0;
        for(ArrayList<String> x:allMovielist )
        {
            if(x.get(0).equals(maxGenre())){
                break;
            }
            y++;
        }
        return y;
    }

    private int movieSuggesttionSum() {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : user.movieSeen.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }

    private String maxGenre() {
        int max=0;
        String favGenre=null;
            for (Map.Entry<String, Integer> entry : user.movieSeen.entrySet()) {
                if (max <= entry.getValue()) {
                    favGenre = entry.getKey();
                }
            }
        return favGenre;
    }

    public ArrayList<String> getMovies()  {
        ArrayList<String> y=new ArrayList<String>();
        if(movieSuggesttionSum()>=10) {
            for (int i = 0; i < 5; i++) {
                int z = (int) (Math.random() * (allMovielist.get(indexOfGenre()).size()-1)) + 1;//since first is genre name and movie start form 1st index not 0
                y.add(allMovielist.get(indexOfGenre()).get(z));
            }
        }
        else {
            y=getStartSuggestion();
        }
        return y;
    }

    private ArrayList<String> getStartSuggestion()
    {
        ArrayList<String> y=new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            int z = (int)( Math.random() * allMovielist.size()) ;
            int q=(int)(Math.random()*(allMovielist.get(z).size()-1))+1;//since first is genre name and movie start form 1st index not 0
            y.add(allMovielist.get(z).get(q));
        }
        return y;
    }

    void getMenuDrive() throws Exception {
        Scanner sc=new Scanner(System.in);
        boolean chk=true;
        clearScreen();
        do{
            System.out.println("For Movie Searching By type press 1 :-\nFor Movie Searching By name press 2:- \nFor Our Side recommendation press 3:- ");
            int x=sc.nextInt();
            switch(x){
                case 1: {
                    searchDisplayGenres();
                    int y=sc.nextInt();
                   searchDisplayMoviesThroughGenre(y);
                    break;
                }
                case 2:{
                    System.out.println("Enter movie you want to search");
                    String movieName=sc.nextLine();
                    searchMovies(movieName);
                    break;
                }
                case 3:{
                    System.out.println("Our Suggested Movies are :- ");
                    displaySuggestedMovies();
                    askToPlay();
                    break;
                }
                default : {
                    System.out.println("We are transferring you to main window :-");
                    chk=false;
                }
            }
        }while(chk);
    }

    private void clearScreen() throws IOException,InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    private void displaySuggestedMovies()
    {
        ArrayList<String> rmovies=getMovies();
        for(String i:rmovies)
        {
            System.out.println(i);
        }
    }

    private void playMovie(String movieName, ArrayList<String> suggested) throws IOException, ClassNotFoundException {
        if(checkForSuggestedMovies(suggested,movieName)) {
            if (searchMoviesExist(movieName)) {
                mapUpdate(getGenreType(movieName));
            } else {
                System.out.println("Please enter the correct name of movie as suggested");
            }
        }
        else {
            System.out.println("Please enter movie from suggested movie");
        }
    }

    private void askToPlay() throws IOException, ClassNotFoundException {
        Scanner sc=new Scanner(System.in);
        boolean check=true;
        do {
            System.out.println("Enter 1 to watch more ;-\nEnter 2 to exit panel :-");
          switch (sc.nextInt()){
              case 1:{
                  System.out.print("Enter the movie you wan to watch :- ");
                  sc.skip("\n");
                  String movieName = sc.nextLine();
                  playMovie(movieName, getMovies());
                  break;
              }
              default:{
                  System.out.println("Terminatting");
                  check=false;
                  break;
              }
          }
        }while (check);
    }

    private boolean checkForSuggestedMovies(ArrayList<String> q,String movieName){
        boolean a=false;
        for(String i:q){
            if(i.equals(movieName)){
                a=true;
                break;
            }
        }
        return a;
    }
}
