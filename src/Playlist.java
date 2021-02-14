import java.util.*;

public class Playlist {
	private String name;
	private String description;
	private LinkedList<Song> songs;
	
	public Playlist(String name) {
		this(name, "", new LinkedList<>());
	}
	
	public Playlist(String name, String description, LinkedList<Song> songs) {
		this.name = name;
		this.description = description;
		this.songs = songs;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public LinkedList<Song> getSongs() {
		return songs;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setdescription(String description) {
		this.name = description;
	}

	public void setSongs(LinkedList<Song> songs) {
		this.songs = songs;
	}

//	public void addSong(Song song) {
//
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
