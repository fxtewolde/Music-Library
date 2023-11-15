import java.util.ArrayList;
//Fiona Tewolde
// 501101135

/*
 * A Playlist contains an array list of AudioContent (i.e. Song, AudioBooks, Podcasts) from the library
 */
public class Playlist
{
	private String title;
	private ArrayList<AudioContent> contents; // songs, books, or podcasts or even mixture
	
	public Playlist(String title)
	{
		this.title = title;
		contents = new ArrayList<AudioContent>();
	}
	
	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void addContent(AudioContent content)
	{
		contents.add(content);
	}
	
	public ArrayList<AudioContent> getContent()
	{
		return contents;
	}

	public void setContent(ArrayList<AudioContent> contents)
	{
		this.contents = contents;
	}

	public int getindexofSong(String title)
	{
		//I created my own method to check if a song is in a certain playlist because I had trouble accessing the audiocontents titles in the library file
		//So I created this to have access to it whenever I want
		for (int i = 0; i < contents.size(); i++)
		{
			if (contents.get(i).getTitle().equals(title)) { return i + 1; }
		}
		return -1;
	}
	
	/*
	 * Print the information of each audio content object (song, audiobook, podcast)
	 * in the contents array list. Print the index of the audio content object first
	 * followed by ". " then make use of the printInfo() method of each audio content object
	 * Make sure the index starts at 1
	 */
	public void printContents()
	{
		for (int i = 0; i < contents.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			contents.get(i).printInfo();
			System.out.println();
		}
		
	}

	public void printContentTitles()
	{
		for (int i = 0; i < contents.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			System.out.println(contents.get(i).getTitle());
			System.out.println();
		}

	}


	// Play all the AudioContent in the contents list
	public void playAll()
	{
		for (int i = 0; i < contents.size(); i++) {
			contents.get(i).play();
			System.out.println();
		}
	}
	
	// Play the specific AudioContent from the contents array list.
	// First make sure the index is in the correct range. 
	public void play(int index)
	{
		if (this.contains(index)) {
			for(int i = 0; i < contents.size(); i++) {
				if ( i == index) {
					contents.get(i).play();
				}
			}
		}
	}
	
	public boolean contains(int index)
	{
		return index >= 1 && index <= contents.size();
	}

	
	// Two Playlists are equal if their titles are equal
	public boolean equals(Object other)
	{
		return false;
	}
	
	// Given an index of an audio content object in contents array list,
	// remove the audio content object from the array list
	// Hint: use the contains() method above to check if the index is valid
	// The given index is 1-indexed so convert to 0-indexing before removing
	public void deleteContent(int index)
	{
		if (!contains(index)) return;
		contents.remove(index-1);
	}
	
	
}
