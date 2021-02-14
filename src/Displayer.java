import java.util.*;

public class Displayer {


	public static void mainMenu(){
		System.out.println("Main menu:\n" +
				"\t0: Display main menu.\n" +
				"\t1: Add directory.\n" +
				"\t2: Songs.\n" +
				"\t3: Composers.\n" +
				"\t4: Artist.\n" +
				"\t5: Genres.\n" +
				"\t6: Play all songs.\n" +
				"\t7: Stop.\n" +
				"\t8: Exit.");
	}

	public static void songsMenu(){
		Displayer.displaySongs(Library.getSongs(), false);
		System.out.println("Songs:\n" +
				"\t1: Play.\n" +
				"\t2: Stop.\n" +
				"\t3: Shuffle.\n" +
				"\t4: Search.\n" +
				"\t5: Add to playlist.\n" +
				"\t6: Love.\n" +
				"\t0: Display main menu.\n" +
				"\t9: Back to library.");
	}
	public static void playListsMenu(){

		System.out.println("Playlists:\n" +
				"\t1: New playlist.\n" +
				"\t2: Now Playing.\n" +
				"\t3: Recently Played.\n" +
				"\t4: Play.\n" +
				"\t5: Stop.\n" +
				"\t6: Love.\n" +
				"\t0: Display main menu.\n" +
				"\t9: Back to library.");
	}

	public static void displayPlayerMenu(){
		System.out.println("mp3Player's menu:\n" +
				"\t0: Display menu.\n" +
				"\t1: Select mp3 file.\n" +
				"\t2: Play song.\n" +
				"\t3: Pause.\n" +
				"\t4: Resume.\n" +
				"\t5: Stop.\n" +
				"\t6: Next song.\n" +
				"\t7: Exit");
	}

	//----------------------------------Songs-------------------------------------------------------
	public static void displaySongInfo(Song song, boolean isisFullInfo) {
		int position = Searcher.searchSongPosition(Library.getSongs(), song.getPath());
		if (position>=0) {
			if (isisFullInfo) {
				System.out.println("\t" + song.getTitle().toUpperCase() + 
									"\n\t - Artist: " + song.getArtist() +
									"\n\t - Genre: " + song.getGenre() +
									"\n\t - Year: " + song.getYear() +
									"\n\t - Duration: " + song.durationFormatter());
			} else {
				System.out.println(song.getTitle().toUpperCase() +
									" - " + song.getArtist()
									+ " - " + song.getYear());
			}   
		}
	}
	
	public static void displaySongs(List<Song> songs, boolean isFullInfo) {
		int listSize = songs.size();
		System.out.println("There are " + listSize + " songs in the list:");
		for (Song song : songs) {
			displaySongInfo(song, isFullInfo);
		}
	}
	//----------------------------------Display by property---------------------------------------------
	private static void displayByProperty(String property, boolean displayFullInfo) {
		List<String> searchResult = Searcher.searchProperty(property);
		System.out.println("There are " + searchResult.size() + " " + property + "s found in library.");

		for (String item : searchResult) {
			System.out.println(item.toUpperCase());
			if (displayFullInfo) {
				displaySongs(Searcher.searchSongByProperty(Library.getSongs(), property, item), false);
			}

		}
	}

	public static void displayComposers(boolean displayFullInfo) {
		displayByProperty("composer", displayFullInfo);
	}
	public static void displayArtist(boolean displayFullInfo) {
		displayByProperty("artist", displayFullInfo);
	}
	public static void displayGenre(boolean displayFullInfo) {
		displayByProperty("genre", displayFullInfo);
	}
	public static void displayAlbum(boolean displayFullInfo) {
		displayByProperty("album", displayFullInfo);
	}


	//----------------------------------Playlists-----------------------------------------------------
	public static void displayPlaylists(List<Playlist> playlists, boolean isFullInfo) {
		int listSize = playlists.size();
		System.out.println("Library has " + listSize + " playlists:");
		for (int i=0; i< listSize; i++) {
			Playlist playlist = playlists.get(i);
			if (isFullInfo) {
				System.out.println(i+1 + ". " + playlist.getName().toUpperCase()+ ": " + playlist.getSongs().size() + " songs");
			} else {
				System.out.println(i+1 + ". " + playlist.getName().toUpperCase()+ ": " + playlist.getSongs().size() + " songs");
			}
		}
	}
	
	public static void displayPlaylistSongs(LinkedList<Song> songs, boolean isFullInfo) {
		Iterator<Song> i= songs.iterator();
		while(i.hasNext()) {
			displaySongInfo(i.next(), isFullInfo);
		}
	}
	

	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
