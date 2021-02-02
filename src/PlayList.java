import java.util.*;

public class PlayList {
	private String name;
	private LinkedList<Song> playList;
	
	public PlayList(String name) {
		this(name, new LinkedList<Song>());
	}
	
	public PlayList(String name, LinkedList<Song> playList) {
		this.name = name;
		this.playList = playList;
	}

	public String getName() {
		return name;
	}
	
	public LinkedList<Song> getPlayList() {
		return playList;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setPlayList(LinkedList<Song> playList) {
		this.playList = playList;
	}
	
	
	
}
