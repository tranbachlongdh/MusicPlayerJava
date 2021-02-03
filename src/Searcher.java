import java.util.*;

public class Searcher {
//	private static Scanner scanner = new Scanner(System.in);
	
	//----------------------------------Composers-------------------------------------------------------
	public static Composer searchComposer(ArrayList<Composer> composerList, String name) {
		for(int i=0; i<composerList.size();i++) {
			Composer composer = composerList.get(i);
			if(composer.getName().toLowerCase().equals(name.toLowerCase())) {
				return composer;
			}
		}
		return null;
	}
	
//	public static int searchComposer(ArrayList<Composer> composerList, Composer composer) {
//		for(int i=0; i<composerList.size();i++) {
//			Composer composer_temp = composerList.get(i);
//			if(composer.getName().toLowerCase().equals(composer_temp.getName().toLowerCase())) {
//				return i;
//			}
//		}
//		return -1;
//	}
	

	public static int searchComposerPosition(ArrayList<Composer> composerList, String title) {
		for(int i=0; i<composerList.size();i++) {
			Composer composer = composerList.get(i);
			if(composer.getName().toLowerCase().equals(title.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}
	
	//----------------------------------Songs-------------------------------------------------------
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
	
	//----------------------------------Genres-------------------------------------------------------
	public static Genre searchGenre(ArrayList<Genre> genres, String name) {
		for(int i=0; i<genres.size();i++) {
			Genre genre = genres.get(i);
			if(genre.getName().toLowerCase().equals(name.toLowerCase())) {
				return genre;
			}
		}
		return null;
	}
	
	public static int searchGenrePosition(ArrayList<Genre> genres, String name) {
		for(int i=0; i<genres.size();i++) {
			Genre genre = genres.get(i);
			if(genre.getName().toLowerCase().equals(name.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}

	//----------------------------------Albums-------------------------------------------------------
	
	public static Album searchAlbum(ArrayList<Album> albums, String name) {
		for(int i=0; i<albums.size();i++) {
			Album album = albums.get(i);
			if(album.getName().toLowerCase().equals(name.toLowerCase())) {
				return album;
			}
		}
		return null;
	}
	
	public static int searchAlbumPosition(ArrayList<Album> albums, String name) {
		for(int i=0; i<albums.size();i++) {
			Album album = albums.get(i);
			if(album.getName().toLowerCase().equals(name.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}
	

	//----------------------------------Playlist-------------------------------------------------------
	
	
	
	
	
	
	
	
	
}
