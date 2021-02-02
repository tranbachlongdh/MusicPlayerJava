import java.util.*;

public class Library {
	private static ArrayList<Composer> composerList = new ArrayList<Composer>();
	private static ArrayList<Song> songList = new ArrayList<Song>();
	private static ArrayList<Album> albumList = new ArrayList<Album>();
	
	public static ArrayList<Composer> getComposerList() {
		return composerList;
	}
	public static void setComposerList(ArrayList<Composer> composerList) {
		Library.composerList = composerList;
	}
	public static ArrayList<Song> getSongList() {
		return songList;
	}
	public static void setSongList(ArrayList<Song> songList) {
		Library.songList = songList;
	}
	public static ArrayList<Album> getAlbumList() {
		return albumList;
	}
	public static void setAlbumList(ArrayList<Album> albumList) {
		Library.albumList = albumList;
	}
	
	
	public static void listAllSong(boolean fullInfo) {
		int listSize = songList.size();
		System.out.println("Library has " + listSize + " songs:");
		for (int i=0; i< listSize; i++) {
			Song song = songList.get(i);
			if (fullInfo) {
				System.out.println(i+1 + ". " + song.getTitle().toUpperCase() + 
									"\n - Composer: " + song.getComposer().getName() +
									"\n - Genre: " + song.getGenre() +
									"\n - Duration: " + song.durationFormatter());
			} else {
				System.out.println(i+1 + ". " + song.getTitle().toUpperCase() + " - " + song.getComposer().getName());
			}
		}
	}
	
	public static boolean addSong(Song song) {
		if (Searcher.searchSong(songList, song.getTitle()) == null) {
			songList.add(song);
			return true;
		}
		return false;
	}
	
	public static boolean removeSong(String title) {
		int songPosition = Searcher.searchSongPosition(songList, title);
		if (songPosition >= 0) {
			Library.songList.remove(songPosition);
			return true;
		}
		return false;
	}
	
	public static boolean editSong(String title) {
		Song song = Searcher.searchSong(songList, title);
		if (song != null) {
			Editor.editSongInfo(song);
			return true;
		}
		return false;
	}
	
	public static void listAllComposer() {
		int listSize = composerList.size();
		System.out.println("Library has " + listSize + " composers:");
		for (int i=0; i< listSize; i++) {
			Composer composer = composerList.get(i);
			System.out.println(i+1 + ". " + composer.getName().toUpperCase() + 
									"\n - Age: " + composer.getAge());
			
		}
	}
	
	
	public static boolean addComposer(Composer composer) {
		if (Searcher.searchComposer(composerList, composer.getName()) == null) {
			composerList.add(composer);
			return true;
		}
		return false;
	}
	
	public static boolean removeComposer(String name) {
		int composerPosition = Searcher.searchComposerPosition(composerList, name);
		if (composerPosition >= 0) {
			Library.composerList.remove(composerPosition);
			return true;
		}
		return false;
	}
	
	public static boolean editComposer(String name) {
		Composer composer = Searcher.searchComposer(composerList, name);
		if (composer != null) {
			Editor.editComposerInfo(composer);
			return true;
		}
		return false;
	}
	
	
	
	

}
