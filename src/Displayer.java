import java.util.*;

public class Displayer {


	//----------------------------------Songs-------------------------------------------------------
	public static void displaySongInfo(Song song, boolean isisFullInfo) {
		int position = Searcher.searchSongPosition(Library.getSongs(), song.getTitle());
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
		for (int i=0; i< listSize; i++) {
			displaySongInfo(songs.get(i), isFullInfo);
		}
	}
	//----------------------------------Display by property---------------------------------------------
	public static void displayByProperty(String property, boolean displayFullInfo) {
		List<String> searchResult = Searcher.searchProperty(property);
		System.out.println("There are " + searchResult.size() + property + "s found in library.");
		
		for(int i=0; i<searchResult.size(); i++) {
			String item = searchResult.get(i);
			System.out.println(item.toUpperCase());
			if (displayFullInfo) {
				displaySongs(Searcher.searchSongByProperty(Library.getSongs(), property, item), true);
			}
			
		}
	}

	//----------------------------------Composers-------------------------------------------------------
//	public static void displayComposers(boolean displayFullInfo) {
//		List<String> composers = Searcher.searchProperty("composer");
//		System.out.println("There are " + composers.size() + " composers found in library.");
//		for(int i=0; i<composers.size(); i++) {
//			String composer = composers.get(i);
//			System.out.println(composer.toUpperCase());
//			if (displayFullInfo) {
//				displaySongs(Searcher.searchSongByComposer(Library.getSongs(), composer), true);
//			}
//			
//		}
//	}

	//----------------------------------Genres-------------------------------------------------------
//	public static void displayGenres(boolean displayFullInfo) {
//		List<String> genres = Searcher.searchProperty("genre");
//		System.out.println("There are " + genres.size() + " genres found in library.");
//		for(int i=0; i<genres.size(); i++) {
//			String genre = genres.get(i);
//			System.out.println(genre.toUpperCase());
//			if (displayFullInfo) {
//				displaySongs(Searcher.searchSongByGenre(Library.getSongs(), genre), true);
//			}
//		}
//	}
		
//		int listSize = composers.size();
//		System.out.println("Library has " + listSize + " composers:");
//		for (int i=0; i< listSize; i++) {
//			Composer composer = composers.get(i);
//			if (isFullInfo) {
//				System.out.println(i+1 + ". " + composer.getName().toUpperCase()+ ": " + composer.getSongs().size() + " songs");
//			} else {
//				System.out.println(i+1 + ". " + composer.getName().toUpperCase()+ ": " + composer.getSongs().size() + " songs");
//			}
//		}
	
	

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
