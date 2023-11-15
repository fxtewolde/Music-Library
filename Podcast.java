import java.util.ArrayList;
//Fiona Tewolde
// 501101135
public class Podcast extends AudioContent
{
    public static final String TYPENAME =	"PODCAST";

    private ArrayList<Season> seasons;
    private String hoster;

    private int currentSeason = 0;

    private int currentEpisode = 0;

    //The class podcast has many of the same methods as the other audiocontent's with the addition of a few

    public Podcast(String title, int year, String id, String type, String host, int length, ArrayList<Season> numSeasons)
    {
        super(title, year, id, type, host, length);
        hoster = host;
        seasons = new ArrayList<Season>(numSeasons);

    }

    public String getType()
    {
        return TYPENAME;
    }

    public void printInfo()
    {
        super.printInfo();
        System.out.println("Host: " + hoster + "\nSeasons: " + seasons.size());
        //Using the printInfo method in superclass to do half of the work when printing
    }

    public void play()
    {
        this.printInfo(); //use this printInfo instead of superclass one, so you can include the author and narrator
        System.out.println("\n" + seasons.get(currentSeason).episodeTitles.get(currentEpisode) + ".\n" + seasons.get(currentSeason).episodeFiles.get(currentEpisode)); // Simulate playing of the audio file

    }


    public void printEpisodeTitles(int index)
    {
        for (int i = 0; i < seasons.get(index - 1).episodeTitles.size(); i++)
        {
            System.out.println("Episode " + (i+1) + ". " + seasons.get(index - 1).episodeTitles.get(i) + "\n");
        }
    }


    public void printEpisodes(int index)
    {
        for (int i = 0; i < seasons.get(index - 1).episodeFiles.size(); i++)
        {
            System.out.println("Episode " + (i+1) + ". " + seasons.get(i).episodeFiles.get(i));
        }
    }


    public boolean selectEpisode(int episode)
    {
        if (episode >= 1 && episode <= seasons.get(currentSeason).episodeFiles.size())
        {
            currentEpisode = episode - 1;
            return true;
        }
        return false;
    }

    public void selectSeason(int season)
    {
        if (season >= 1 && season <= seasons.size())
        {
            currentSeason = season - 1;
        }
    }


    public boolean equals(Object other)
    {
        return false;
    }

    public int getNumberOfSeasons() { return seasons.size(); }


    public void setSeasons(ArrayList<Season> newSeason) { seasons = new ArrayList<>(newSeason); }

}

