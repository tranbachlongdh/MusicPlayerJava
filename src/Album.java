import java.util.*;

public class Album {
	private String name;
	private Composer composer;
	private Date date;
	private ArrayList<Song> songList;
	
	public Album(String name) {
		this(name, null, null, new ArrayList<Song>());
	}
	
	public Album(String name, Composer composer, Date date, ArrayList<Song> songList) {
		this.name = name;
		this.composer = composer;
		this.date = date;
		this.songList = songList;
	}

	public String getName() {
		return name;
	}

	public Composer getComposer() {
		return composer;
	}

	public Date getDate() {
		return date;
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setComposer(Composer composer) {
		this.composer = composer;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public void setSongs(ArrayList<Song> songList) {
		this.songList = songList;
	}
	
	public void listAllSong(boolean fullInfo) {
		int albumSize = songList.size();
		System.out.println("Album " + name.toUpperCase() + " has " + albumSize + " songs:");
		for (int i=0; i< albumSize; i++) {
			Song songTemp = songList.get(i);
			if (fullInfo) {
				System.out.println(i+1 + ". " + songTemp.getTitle().toUpperCase() + 
									"\n - Composer: " + songTemp.getComposer().getName() +
									"\n - Genre: " + songTemp.getGenre() +
									"\n - Duration: " + songTemp.durationFormatter());
			} else {
				System.out.println(i+1 + ". " + songTemp.getTitle().toUpperCase() + " - " + songTemp.getComposer().getName());
			}
		}
	}
	
	public boolean addSong(Song song) {
		if (Searcher.searchSong(songList, song.getTitle()) == null) {
			songList.add(song);
			return true;
		}
		return false;
	}
	
	public boolean update() {
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
