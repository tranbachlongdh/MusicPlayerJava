import java.util.*;

public class Library {
	private static ArrayList<Composer> composers = new ArrayList<Composer>();
	private static ArrayList<Song> songs = new ArrayList<Song>();
	private static ArrayList<Album> albums = new ArrayList<Album>();
	private static ArrayList<Playlist> playlists = new ArrayList<Playlist>();
	private static ArrayList<Genre> genres = new ArrayList<Genre>();
	

	//----------------------------------Constructor-------------------------------------------------------
	
	//----------------------------------getter and setter-------------------------------------------------
	
	public static ArrayList<Composer> getComposers() {
		return composers;
	}
	public static void setComposerList(ArrayList<Composer> composers) {
		Library.composers = composers;
	}
	public static ArrayList<Song> getSongs() {
		return songs;
	}
	public static void setSongList(ArrayList<Song> songs) {
		Library.songs = songs;
	}
	public static ArrayList<Album> getAlbums() {
		return albums;
	}
	public static void setAlbumList(ArrayList<Album> albums) {
		Library.albums = albums;
	}
	
	public static ArrayList<Playlist> getPlaylists() {
		return playlists;
	}
	public static void setPlaylists(ArrayList<Playlist> playlists) {
		Library.playlists = playlists;
	}
	
	public static ArrayList<Genre> getGenres() {
		return genres;
	}
	public static void setGenres(ArrayList<Genre> genres) {
		Library.genres = genres;
	}
	

	//----------------------------------Methods-----------------------------------------------------
	//----------------------------------Playlists-----------------------------------------------------
	
//	public static void listAllPlaylists() {
//		int listSize = playlists.size();
//		System.out.println("Library has " + listSize + " playlists:");
//		for (int i=0; i< listSize; i++) {
//			Playlist playlist = playlists.get(i);
//			System.out.println(i+1 + ". " + playlist.getName().toUpperCase());
//		}
//	}
		
	public static void listAllPlaylists(boolean fullInfo) {
		Displayer.displayPlaylists(Library.getPlaylists(), fullInfo);
	}
	
	public static void addPlaylist(Playlist playlist) {
		
	}
	

	//----------------------------------Songs-----------------------------------------------------
	
	public static void listAllSongs(boolean fullInfo) {
		Displayer.displaySongs(Library.getSongs(), fullInfo);
	}
	
	public static boolean addSong(Song song) {
		if (Searcher.searchSong(songs, song.getTitle()) == null) {
			songs.add(song);
			return true;
		}
		return false;
	}
	
	public static boolean removeSong(String title) {
		int songPosition = Searcher.searchSongPosition(songs, title);
		if (songPosition >= 0) {
			Library.songs.remove(songPosition);
			return true;
		}
		return false;
	}
	
	public static boolean editSong(String title) {
		Song song = Searcher.searchSong(songs, title);
		if (song != null) {
			Editor.editSongInfo(song);
			return true;
		}
		return false;
	}
	

	//----------------------------------Composers-----------------------------------------------------
		
	public static void listAllComposers(boolean fullInfo) {
		Displayer.displayComposers(Library.getComposers(), fullInfo);
	}
	
	public static boolean addComposer(Composer composer) {
		if (Searcher.searchComposer(composers, composer.getName()) == null) {
			composers.add(composer);
			return true;
		}
		return false;
	}
	
	public static boolean removeComposer(String name) {
		int composerPosition = Searcher.searchComposerPosition(composers, name);
		if (composerPosition >= 0) {
			Library.composers.remove(composerPosition);
			return true;
		}
		return false;
	}
	
//	public static boolean editComposer(String name) {
//		Composer composer = Searcher.searchComposer(composers, name);
//		if (composer != null) {
//			Editor.editComposerInfo(composer);
//			return true;
//		}
//		return false;
//	}
	

	//----------------------------------Genres-----------------------------------------------------
	public static void listAllGenres(boolean fullInfo) {
		Displayer.displayGenres(Library.getGenres(), fullInfo);
	}
	
	public static boolean addGenre(Genre genre) {
		if (Searcher.searchGenre(genres, genre.getName()) == null) {
			genres.add(genre);
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
