import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Math;
//Fiona Tewolde
// 501101135

/*
 * This class manages, stores, and plays audio content such as songs, podcasts and audiobooks. 
 */
public class Library
{
	private ArrayList<Song> 			songs; 
	private ArrayList<AudioBook> 	audiobooks;
	private ArrayList<Playlist> 	playlists;

	private ArrayList<Podcast>      podcasts;
	

	// Public methods in this class set errorMesg string 
	// Error Messages can be retrieved from main in class MyAudioUI by calling  getErrorMessage()
	// In assignment 2 we will replace this with Java Exceptions
	String errorMsg = "";
	
	public String getErrorMessage()
	{
		return errorMsg;
	}

	public Library()
	{
		songs 			= new ArrayList<Song>(); 
		audiobooks 	= new ArrayList<AudioBook>(); ;
		playlists   = new ArrayList<Playlist>();
	    podcasts		= new ArrayList<Podcast>(); ;
	}
	/*
	 * Download audio content from the store. Since we have decided (design decision) to keep 3 separate lists in our library
	 * to store our songs, podcasts and audiobooks (we could have used one list) then we need to look at the type of
	 * audio content (hint: use the getType() method and compare to Song.TYPENAME or AudioBook.TYPENAME etc)
	 * to determine which list it belongs to above
	 * 
	 * Make sure you do not add song/podcast/audiobook to a list if it is already there. Hint: use the equals() method
	 * If it is already in a list, set the errorMsg string and return false. Otherwise add it to the list and return true
	 * See the video
	 */
	public boolean download(AudioContent content)
	{
		//First I checked what type of audiocontent it is, and then I checked if the personal library already has it
		//If the library does not have it, then I add it to the audiocontent's type list
		//If it does, then I set the error message

		int temper = -1;

		if (content.getType().equals("SONG")) {
			for (int i = songs.size() - 1; i >= 0; i--) {
				if (content.getTitle().equals(songs.get(i).getTitle())) {
					temper = 1;
				}
			}
			if (temper == -1) {
				Song contentA = (Song) content;
				songs.add(contentA);
				return true;
			} else { errorMsg = "Song already downloaded"; }
		} else if (content.getType().equals("AUDIOBOOK")) {
			for (int i = audiobooks.size() - 1; i >= 0; i--) {
				if (content.getTitle().equals(audiobooks.get(i).getTitle())) {
					temper = 1;
				}
			}
			if (temper == -1) {
				AudioBook contentA = (AudioBook) content;
				audiobooks.add(contentA);
				return true;
			} else { errorMsg = "Audiobook already downloaded"; }
		} else if (content.getType().equals("PODCAST")) {
			for (int i = podcasts.size() - 1; i >= 0; i--) {
				if (content.getTitle().equals(podcasts.get(i).getTitle())) {
					temper = 1;
				}
			}
			if (temper == -1) {
				Podcast contentA = (Podcast) content;
				podcasts.add(contentA);
				return true;
			} else { errorMsg = "Podcast already downloaded"; }
		}

		return false;
	}

	//I used the printinfo() method to print each of the lists of audiocontent

	// Print Information (printInfo()) about all songs in the array list
	public void listAllSongs()
	{
		for (int i = 0; i < songs.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			songs.get(i).printInfo();
			System.out.println();	
		}
	}
	
	// Print Information (printInfo()) about all audiobooks in the array list
	public void listAllAudioBooks()
	{
		for (int i = 0; i < audiobooks.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			audiobooks.get(i).printInfo();
			System.out.println();
		}
	}
	
  // Print Information (printInfo()) about all podcasts in the array list
	public void listAllPodcasts()
	{
		for (int i = 0; i < podcasts.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			podcasts.get(i).printInfo();
			System.out.println();
		}
	}
	
  // Print the name of all playlists in the playlists array list
	// First print the index number as in listAllSongs() above
	public void listAllPlaylists()
	{
		for (int i = 0; i < playlists.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			System.out.println(playlists.get(i).getTitle());
			System.out.println();
		}
	}
	
  // Print the name of all artists. 
	public void listAllArtists()
	{
		// First create a new (empty) array list of string 
		// Go through the songs array list and add the artist name to the new arraylist only if it is
		// not already there. Once the artist arrayl ist is complete, print the artists names

		//I used a for loop to iterate through the song list and check if each song artist already exists
		//Then it adds each artist based on its existence and prints the artists

		ArrayList<String> arrayl = new ArrayList<String> ();

		arrayl.add(songs.get(0).getArtist());

		int temper = -1;

		for (int i = 0; i < songs.size(); i++) {

			for (int j = arrayl.size() - 1; j >= 0; j--)
			{
				if (songs.get(i).getArtist().equals(arrayl.get(j))) { temper = 1; }
			}

			if (temper == -1) { arrayl.add(songs.get(i).getArtist());
			} else { temper = -1; }
		}

		for (int i = 0; i < arrayl.size(); i++) {
			int index = i + 1;
			System.out.print("" + index + ". ");
			System.out.print(arrayl.get(i));
			System.out.println();
		}

	}

	// Delete a song from the library (i.e. the songs list) - 
	// also go through all playlists and remove it from any playlist as well if it is part of the playlist
	public boolean deleteSong(int index)
	{
		//The for loop finds if a song is contained in a playlist and returns the index if it is
		//Then I delete the song in the specific playlist based on the index returned
		//Then I also remove the song from the songs list after removing it from the playlist

		if (index > 0 && index <= songs.size())
		{
			for (int i = 0; i < playlists.size(); i++)
			{
				if (playlists.get(i).getindexofSong(songs.get(index - 1).getTitle()) >= 0) {
					playlists.get(i).deleteContent(playlists.get(i).getindexofSong(songs.get(index - 1).getTitle()));
				}
			}
			songs.remove(index - 1);
			return true;
		}
		errorMsg = "Song Not Found";
		return false;
	}
	
  //Sort songs in library by year
	public void sortSongsByYear()
	{

		Collections.sort(songs, new SongYearComparator());
		// Use Collections.sort() 
	
	}
  // Write a class SongYearComparator that implements
	// the Comparator interface and compare two songs based on year
	public class SongYearComparator implements Comparator<Song>
  {
	  public int compare(Song a, Song b) {
		  Song otherA = (Song) a;
		  Song otherB = (Song) b;
		  if (otherA.getYear() > otherB.getYear()) {
			  return 1;
		  } else if (otherA.getYear() < otherB.getYear()) {
			  return -1;
		  } else {
			  return 0;
		  }
	  }

  }

	// Sort songs by length
	public void sortSongsByLength()
	{
	 Collections.sort(songs, new SongLengthComparator());
	}
  // Write a class SongLengthComparator that implements
	// the Comparator interface and compare two songs based on length
	private class SongLengthComparator implements Comparator<Song>
	{
		public int compare(Song a, Song b) {
			Song otherA = (Song) a;
			Song otherB = (Song) b;

			if (otherA.getLength() > otherB.getLength()) {
				return 1;
			} else if (otherA.getLength() < otherB.getLength()) {
				return -1;
			} else { return 0; }
		}
	}

	// Sort songs by title 
	public void sortSongsByName()
	{
		Collections.sort(songs);
	  // Use Collections.sort()
		// class Song should implement the Comparable interface
		// see class Song code
	}

	
	
	/*
	 * Play Content
	 */
	
	// Play song from songs list
	public boolean playSong(int index)
	{
		if (index < 1 || index > songs.size())
		{
			errorMsg = "Song Not Found";
			return false;
		}
		songs.get(index - 1).play();
		return true;
	}
	
	// Play podcast from list (specify season and episode)
	// Bonus
	public boolean playPodcast(int index, int season, int episode)
	{
		//I used the specified season and episode to play specific content
		//and set the error message if parameters are inconsistent
		//I use a very similar if condition for the next couple of methods
		if (index <= podcasts.size() && index > 0 && season <= podcasts.get(index - 1).getNumberOfSeasons())
		{
			podcasts.get(index - 1).selectSeason(season);
			if (podcasts.get(index - 1).selectEpisode(episode))
			{
				podcasts.get(index - 1).play();
				return true;
			}
		} else { errorMsg = "Podcast Not Found"; }

		return false;
	}
	
	// Print the episode titles of a specified season
	// Bonus 
	public boolean printPodcastEpisodes(int index, int season)
	{
		if (index <= podcasts.size() && index > 0 && season <= podcasts.get(index - 1).getNumberOfSeasons())
		{
			podcasts.get(index - 1).printEpisodeTitles(season);
			return true;
		} else { errorMsg = "Podcast Not Found"; }

		return false;
	}
	
	// Play a chapter of an audio book from list of audiobooks
	public boolean playAudioBook(int index, int chapter)
	{
		//I set the chapter using the specified chapter input
		if (index <= audiobooks.size() && index > 0 && chapter <= audiobooks.get(index - 1).getNumberOfChapters())
		{
			audiobooks.get(index - 1).selectChapter(chapter);
			audiobooks.get(index - 1).play();
			return true;
		} else { errorMsg = "AudioBook Not Found"; }

		return false;
	}
	
	// Print the chapter titles (Table Of Contents) of an audiobook
	// see class AudioBook
	public boolean printAudioBookTOC(int index)
	{
		if (index <= audiobooks.size() && index > 0)
		{
			audiobooks.get(index - 1).printTOC();
			return true;
		} else {errorMsg = "Audio Book Not Found"; }
		return false;
	}
	
  /*
   * Playlist Related Methods
   */
	
	// Make a new playlist and add to playlists array list
	// Make sure a playlist with the same title doesn't already exist
	public boolean makePlaylist(String title)
	{
		//First, I check if the playlists already contain a playlist with the inputed title
		//If it does not contain it, then I add it to playlists and create a playlist at the same time
		//if it does contain it, then I set the error message

		int temper = -1;
		for (int i = 0; i < playlists.size(); i++)
		{
			if (playlists.get(i).getTitle().equals(title))
			{
				temper = 1;
			}
		}
		if (temper == -1) { playlists.add(new Playlist(title)); return true;
		} else { errorMsg = "Playlist " + title + " Already Exists"; }
		return false;
	}
	
	// Print list of content information (songs, audiobooks etc) in playlist named title from list of playlists

	public boolean printPlaylist(String title)
	{
		for (int i = 0; i < playlists.size(); i++) {
			if (playlists.get(i).getTitle().equals(title)) {
				playlists.get(i).printContentTitles();
			}
		}



		return false;
	}

	public boolean printallPlaylists()
	{
		//I created a new method to play all the playlists in the playlist arraylist because all of the other play playlist methods only play a specified playlist
		for (int i = 0; i < playlists.size(); i++)
		{
			System.out.println("Playlist Title: " + playlists.get(i).getTitle());
			playlists.get(i).playAll();
		}
		return true;
	}
	
	// Play all content in a playlist
	public boolean playPlaylist(String playlistTitle)
	{
		for (int i = 0; i < playlists.size(); i++)
		{
			if (playlists.get(i).getTitle().equals(playlistTitle))
			{
				playlists.get(i).printContents();
				return true;
			}
		}
		return false;
	}
	
	// Play a specific song/audiobook in a playlist
	public boolean playPlaylist(String playlistTitle, int indexInPL)
	{
		System.out.println(playlistTitle);
		for (int i = 0; i < playlists.size(); i++) {
			if (playlists.get(i).getTitle().equals(playlistTitle))
			{
				if (indexInPL <= playlists.get(i).getContent().size() && indexInPL > 0)
				{
					playlists.get(i).play(indexInPL - 1);
					return true;
				}
			}
		}
		return false;
	}
	
	// Add a song/audiobook/podcast from library lists at top to a playlist
	// Use the type parameter and compare to Song.TYPENAME etc
	// to determine which array list it comes from then use the given index
	// for that list
	public boolean addContentToPlaylist(String type, int index, String playlistTitle)
	{
		if (type.equals("SONG") || type.equals("Song") || type.equals("song")) {
			if (songs.size() > 0 && (!(index > songs.size()))) {
				for (int i = 0; i < playlists.size(); i++) {
					if (playlists.get(i).getTitle().equals(playlistTitle)) {
						playlists.get(i).addContent(songs.get(index - 1));
						return true;
					}
				}
			} else { errorMsg = "Song Not Found in Playlist " + playlistTitle; }
		} else if (type.equals("PODCAST") || type.equals("Podcast") || type.equals("podcast")) {
			if (podcasts.size() > 0 && (!(index > podcasts.size()))) {
				for (int i = 0; i < playlists.size(); i++) {
					if (playlists.get(i).getTitle().equals(playlistTitle)) {
						playlists.get(i).addContent(podcasts.get(index - 1));
						return true;
					}
				}
			} else { errorMsg = "Podcast Not Found in Playlist " + playlistTitle; }
		} else if (type.equals("AUDIOBOOK") || type.equals("Audiobook") || type.equals("audiobook")) {
			if (audiobooks.size() > 0 && (!(index > audiobooks.size()))) {
				for (int i = 0; i < playlists.size(); i++) {
					if (playlists.get(i).getTitle().equals(playlistTitle)) {
						playlists.get(i).addContent(audiobooks.get(index - 1));
						return true;
					}
				}
			} else { errorMsg = "Audio Book Not Found in Playlist " + playlistTitle; }
		}
		return false;
	}

  // Delete a song/audiobook/podcast from a playlist with the given title
	// Make sure the given index of the song/audiobook/podcast in the playlist is valid 
	public boolean delContentFromPlaylist(int index, String title)
	{
		for (int i = 0; i < playlists.size(); i++) {
			if (playlists.get(i).getTitle().equals(title))
			{
				if (index <= playlists.get(i).getContent().size() && index > 0)
				{
					playlists.get(i).deleteContent(index);
					return true;
				}
			}
		}
		return false;
	}

}

