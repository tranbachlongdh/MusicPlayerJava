import java.util.*;

public class Library {

	private static ArrayList<Song> songs = new ArrayList<Song>();
	private static ArrayList<Playlist> playlists = new ArrayList<Playlist>();
	
	
	
//	private static ArrayList<Composer> composers = new ArrayList<Composer>();
//	private static ArrayList<Album> albums = new ArrayList<Album>();
//	private static ArrayList<Genre> genres = new ArrayList<Genre>();
	

	//----------------------------------Constructor-------------------------------------------------------
	
	//----------------------------------getter and setter-------------------------------------------------
	
	public static List<Song> getSongs() {
		return songs;
	}

	public static List<Playlist> getPlaylists() {
		return playlists;
	}

	public static void setSongs(ArrayList<Song> songs) {
		Library.songs = songs;
	}

	public static void setPlaylists(ArrayList<Playlist> playlists) {
		Library.playlists = playlists;
	}
	

	//----------------------------------Methods-------------------------------------------------------
	//----------------------------------Playlists-----------------------------------------------------
	

	public static void listAllPlaylists(boolean fullInfo) {
		Displayer.displayPlaylists(Library.getPlaylists(), fullInfo);
	}
	
	public static boolean addPlaylist(Playlist playlist) {
		if (Searcher.searchPlaylist(playlists, playlist.getName()) == null) {
			playlists.add(playlist);
			return true;
		}
		return false;
	}
	
	public static boolean removePlaylist(String name) {
		int playlistPosition = Searcher.searchPlaylistPosition(playlists, name);
		if (playlistPosition >= 0) {
			Library.playlists.remove(playlistPosition);
			return true;
		}
		return false;
	}
	

	

	//----------------------------------Songs-----------------------------------------------------
	
	public static void listAllSongs(boolean fullInfo) {
		Displayer.displaySongs(Library.getSongs(), fullInfo);
	}
	
	
	public static boolean addSong(Song song) {
		if(Searcher.searchSongPosition(songs, song.getTitle())<0) {
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
	
//	public static boolean editSong(String title) {
//		Song song = Searcher.searchSong(songs, title);
//		if (song != null) {
//			Editor.editSongInfo(song);
//			return true;
//		}
//		return false;
//	}
	

//	//----------------------------------Composers-----------------------------------------------------
//		
//	public static void listAllComposers(boolean fullInfo) {
//		Displayer.displayComposers(Library.getComposers(), fullInfo);
//	}
//	
//	public static boolean addComposer(Composer composer) {
//		if (Searcher.searchComposer(composers, composer.getName()) == null) {
//			composers.add(composer);
//			return true;
//		}
//		return false;
//	}
//	
//	public static boolean removeComposer(String name) {
//		int composerPosition = Searcher.searchComposerPosition(composers, name);
//		if (composerPosition >= 0) {
//			Library.composers.remove(composerPosition);
//			return true;
//		}
//		return false;
//	}
//	
////	public static boolean editComposer(String name) {
////		Composer composer = Searcher.searchComposer(composers, name);
////		if (composer != null) {
////			Editor.editComposerInfo(composer);
////			return true;
////		}
////		return false;
////	}
//	
//
//	//----------------------------------Genres-----------------------------------------------------
//	public static void listAllGenres(boolean fullInfo) {
//		Displayer.displayGenres(Library.getGenres(), fullInfo);
//	}
//	
//	public static boolean addGenre(Genre genre) {
//		if (Searcher.searchGenre(genres, genre.getName()) == null) {
//			genres.add(genre);
//			return true;
//		}
//		return false;
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
