import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

import java.io.IOException;
import java.util.*;

public class Library {

	private static ArrayList<Song> songs = new ArrayList<>();
	private static ArrayList<Playlist> playlists = new ArrayList<>();
	
	
	
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
	
	// Add more song to library bases on file path
	public static boolean addSong(Song song) {
		if(Searcher.searchSongPosition(songs, song.getPath())<0) {
			songs.add(song);
			return true;
		}
		return false;
		
	}

	// Add songs to library
	public static void addSongs(String path) throws IOException, ReadOnlyFileException, TagException, InvalidAudioFrameException, CannotReadException {
		List<String> songs = ProcessDir.process(path);
		// Go through each file and add to library
		for(String s : songs) {
			List<String> fileInfo = ProcessDir.mp3FileInfo(s);
			Library.addSong(new Song(fileInfo.get(0), 						// Path
										fileInfo.get(1), 					// Title
										Integer.parseInt(fileInfo.get(2)), 	// Duration
										fileInfo.get(3), 					// Composer
										fileInfo.get(4), 					// Artist
										fileInfo.get(5), 					// Album
										fileInfo.get(5), 					// Genre
										Integer.parseInt(fileInfo.get(7)))); // Year
		}
	}

	// Remove song from library
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
