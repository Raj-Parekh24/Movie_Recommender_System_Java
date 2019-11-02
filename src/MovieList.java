import java.util.ArrayList;

public class MovieList{

    ArrayList<ArrayList<String>> allMovielist = new ArrayList<ArrayList<String>>();
    ArrayList<String> actionlist =new ArrayList<String>();
    ArrayList<String> comedylist =new ArrayList<String>();
    ArrayList<String> romancelist =new ArrayList<String>();
   ArrayList<String> horrorlist =new ArrayList<String>();
    ArrayList<String> scifilist =new ArrayList<String>();

    public void genreAdd()
    {
        actionlist.add("Watchman");
        actionlist.add("Terminator: Dark Fate");
        actionlist.add("Star Wars: The Rise of Skywalker");
        actionlist.add("Zombieland: Double Tap");
        actionlist.add("El Camino: A Breaking Bad Movie");
        actionlist.add("Daybreak");
        actionlist.add("Batwoman");
        allMovielist.add(actionlist);
        comedylist.add("The Laundromat");
        comedylist.add("Living with Yourself ");
        comedylist.add("Zombieland: Double Tap");
        comedylist.add("Modern Love");
        comedylist.add("Hocus Pocus");
        comedylist.add("The Boys");
        comedylist.add("Once Upon a Time in Hollywood");
        allMovielist.add(comedylist);
        romancelist.add("Game of Thrones");
        romancelist.add("Big Mouth");
        romancelist.add("Friends");
        romancelist.add("The King");
        romancelist.add("Maleficent");
        romancelist.add("Vikings");
        romancelist.add("Riverdale");
        allMovielist.add(romancelist);
        horrorlist.add("Zombieland: Double Tap");
        horrorlist.add("The Walking Dead");
        horrorlist.add("American Horror Story");
        horrorlist.add("Supernatural");
        horrorlist.add("It Chapter Two");
        horrorlist.add("Stranger Things");
        horrorlist.add("3 from Hell");
        allMovielist.add(horrorlist);
        scifilist.add("Watchmen");
        scifilist.add("Star Wars: The Rise of Skywalker");
        scifilist.add("Bloodshot");
        scifilist.add("Arrow");
        scifilist.add("The Flash");
        scifilist.add("Avengers: Endgame");
        scifilist.add("Black Mirror");
        allMovielist.add(scifilist);
    }



    public void SearchdisplayGenres(){
        System.out.println("Please Enter Your Choice:");
        System.out.println("1. Action 2.Comedy 3.Romance 4.Horror 5.SciFi");
    }
    public void SearchdisplayMovies(int x){
        switch(x){
            case 1: for(int i=0;i<actionlist.size();i++){
                System.out.print(actionlist);
            }
            break;
            case 2:
                for(int i=0;i<comedylist.size();i++){
                    System.out.print(comedylist.get(i) + "    ");
                }
                break;
            case 3:  for(int i=0;i<romancelist.size();i++){
                System.out.print(romancelist.get(i)+"   ");
            }
            break;
            case 4: for(int i=0;i<horrorlist.size();i++){
                System.out.print(horrorlist.get(i)+"    ");
            }
            break;
            case 5: for(int i=0;i<scifilist.size();i++){
                System.out.print(scifilist.get(i)+"     ");
            }
            break;
        }
    }

}
