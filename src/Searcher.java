import java.util.*;

public class Searcher {
//	private static Scanner scanner = new Scanner(System.in);
	
	//--------------------------------Method--------------------------------------------------------

	public static int searchStringInList(List<String> stringList, String string) {
		for (int i=0; i< stringList.size(); i++) {
			if(stringList.get(i).equalsIgnoreCase(string)) {
				return i;
			}
		}
		return -1;
	}
	//----------------------------------Songs-------------------------------------------------------

	public static int searchSongPosition(List<Song> songList, String path) {
		for(int i=0; i<songList.size();i++) {
			Song song = songList.get(i);
			if(song.getPath().equalsIgnoreCase(path)) {
				return i;
			}
		}
		return -1;
	}
	

	//----------------------------------Playlists-------------------------------------------------------
	
	public static Playlist searchPlaylist(ArrayList<Playlist> playlists, String name) {
		for (Playlist playlist : playlists) {
			if (playlist.getName().equalsIgnoreCase(name)) {
				return playlist;
			}
		}
		return null;
	}
	
	public static int searchPlaylistPosition(ArrayList<Playlist> playlists, String name) {
		for(int i=0; i<playlists.size();i++) {
			Playlist playlist = playlists.get(i);
			if(playlist.getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}
	


	//--------------------------------------------------------------------------------------------------
	public static List<String> searchProperty(String choice){
		ArrayList<String> result = new ArrayList<>();
		List<Song> songs = Library.getSongs();
		String item = null;

		for (Song song : songs) {

			switch (choice) {
				case "composer":
					item = song.getComposer();
					break;
				case "artist":
					item = song.getArtist();
					break;
				case "genre":
					item = song.getGenre();
					break;
				case "album":
					item = song.getAlbum();
					break;
				case "year":
					item = String.valueOf(song.getYear());
					break;
				default: {
					System.out.println("Wrong choice!!!");
				}
			}

			if (Searcher.searchStringInList(result, item) < 0) {
				result.add(item);
			}
		}
		return result;
	} 
	
	
	
	public static List<Song> searchSongByTitle (List<Song> songs, String title) {
		return searchSongByProperty(songs, "title", title);
	}
	
	public static List<Song> searchSongByComposer (List<Song> songs, String composerName) {
		return searchSongByProperty(songs, "composer", composerName);
	}
	
	public static List<Song> searchSongByGenre (List<Song> songs, String genre) {
		return searchSongByProperty(songs, "genre", genre);
	}
	
	public static List<Song> searchSongByProperty(List<Song> songs, String specificType, String searchPattern) {
		
		//convert to lowercase
		specificType = specificType.toLowerCase();
		ArrayList<Song> searchedSongs = new ArrayList<>();


		for (Song song : songs) {
			boolean matched = false;
			switch (specificType) {
				case "title":
					if (song.getTitle().equalsIgnoreCase(searchPattern)) {
						matched = true;
					}
					break;
				case "composer":
					if (song.getComposer().equalsIgnoreCase(searchPattern)) {
						matched = true;
					}
					break;
				case "artist":
					if (song.getArtist().equalsIgnoreCase(searchPattern)) {
						matched = true;
					}
					break;
				case "genre":
					if (song.getGenre().equalsIgnoreCase(searchPattern)) {
						matched = true;
					}
					break;
				case "album":
					if (song.getAlbum().equalsIgnoreCase(searchPattern)) {
						matched = true;
					}
					break;
				case "year":
					if (song.getYear() == Integer.parseInt(searchPattern)) {
						matched = true;
					}
					break;
				case "suggested":
					if (song.isSuggest()) {
						matched = true;
					}
					break;
				default: {
					System.out.println("Wrong searching code!!!");
				}
			}

			if (matched) {
				//Add song which was found to a new list
				searchedSongs.add(song);
			}

		}
		return searchedSongs;
	}
	
	
	
}
