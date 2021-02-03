import java.util.*;

public class Displayer {


	//----------------------------------Songs-------------------------------------------------------
	public static void displaySongs(ArrayList<Song> songs, boolean fullInfo) {
//		ArrayList<Song> songs = Library.getSongs();
		int listSize = songs.size();
		System.out.println("Library has " + listSize + " songs:");
		for (int i=0; i< listSize; i++) {
			Song song = songs.get(i);
			if (fullInfo) {
				System.out.println(i+1 + ". " + song.getTitle().toUpperCase() + 
									"\n - Composer: " + song.getComposer().getName() +
									"\n - Genre: " + song.getGenre().getName() +
									"\n - Year: " + song.getYear() +
									"\n - Duration: " + song.durationFormatter());
			} else {
				System.out.println(i+1 + ". " + song.getTitle().toUpperCase() +
									" - " + song.getComposer().getName()
									+ " - " + song.getYear());
			}
		}
	}
	

	//----------------------------------Composers-------------------------------------------------------
	public static void displayComposers(ArrayList<Composer> composers, boolean fullInfo) {
		int listSize = composers.size();
		System.out.println("Library has " + listSize + " composers:");
		for (int i=0; i< listSize; i++) {
			Composer composer = composers.get(i);
			if (fullInfo) {
				System.out.println(i+1 + ". " + composer.getName().toUpperCase()+ ": " + composer.getSongs().size() + " songs");
			} else {
				System.out.println(i+1 + ". " + composer.getName().toUpperCase()+ ": " + composer.getSongs().size() + " songs");
			}
		}
	}
	

	//----------------------------------Playlists-----------------------------------------------------
	public static void displayPlaylists(ArrayList<Playlist> playlists, boolean fullInfo) {
		int listSize = playlists.size();
		System.out.println("Library has " + listSize + " playlists:");
		for (int i=0; i< listSize; i++) {
			Playlist playlist = playlists.get(i);
			if (fullInfo) {
				System.out.println(i+1 + ". " + playlist.getName().toUpperCase()+ ": " + playlist.getSongs().size() + " songs");
			} else {
				System.out.println(i+1 + ". " + playlist.getName().toUpperCase()+ ": " + playlist.getSongs().size() + " songs");
			}
		}
	}
	

	//----------------------------------Genres-------------------------------------------------------
	
	public static void displayGenres(ArrayList<Genre> genres, boolean fullInfo) {
		int listSize = genres.size();
		System.out.println("Library has " + listSize + " playlists:");
		for (int i=0; i< listSize; i++) {
			Genre genre = genres.get(i);
			if (fullInfo) {
				System.out.println(i+1 + ". " + genre.getName().toUpperCase()+ ": " + genre.getSongs().size() + " songs");
			} else {
				System.out.println(i+1 + ". " + genre.getName().toUpperCase()+ ": " + genre.getSongs().size() + " songs");
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
