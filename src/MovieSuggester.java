import java.util.ArrayList;
import java.util.Map;

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
                int z = (int) (Math.random() * allMovielist.get(indexOfGenre()).size()) + 1;//since first is genre name and movie start form 1st index not 0
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
            int q=(int)(Math.random()*allMovielist.get(z).size())+1;//since first is genre name and movie start form 1st index not 0
            y.add(allMovielist.get(z).get(q));
        }
        return y;
    }


}
