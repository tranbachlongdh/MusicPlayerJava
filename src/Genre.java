import java.util.ArrayList;

public class Genre {
	private String name;
	private ArrayList<Song> songs;

	public Genre() {
		this("UNKNOWN", new ArrayList<Song>());
	}
	
	public Genre(String name) {
		this(name, new ArrayList<Song>());
	}
	
	public Genre(String name, ArrayList<Song> songs) {
		this.name = name;
		this.songs = songs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Song> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}
	
	
	
	
}
