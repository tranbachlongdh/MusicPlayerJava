import java.util.*;

public class Searcher {
//	private static Scanner scanner = new Scanner(System.in);
	
	public static Composer searchComposer(ArrayList<Composer> composerList, String name) {
		for(int i=0; i<composerList.size();i++) {
			Composer composer = composerList.get(i);
			if(composer.getName().toLowerCase().equals(name.toLowerCase())) {
				return composer;
			}
		}
		return null;
	}
	

	public static int searchComposerPosition(ArrayList<Composer> composerList, String title) {
		for(int i=0; i<composerList.size();i++) {
			Composer composer = composerList.get(i);
			if(composer.getName().toLowerCase().equals(title.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}
	
	public static Song searchSong(ArrayList<Song> songList, String title) {
		for(int i=0; i<songList.size();i++) {
			Song song = songList.get(i);
			if(song.getTitle().toLowerCase().equals(title.toLowerCase())) {
				return song;
			}
		}
		return null;
	}
	
	public static int searchSongPosition(ArrayList<Song> songList, String title) {
		for(int i=0; i<songList.size();i++) {
			Song song = songList.get(i);
			if(song.getTitle().toLowerCase().equals(title.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}

}
