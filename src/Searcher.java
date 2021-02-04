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

	public static int searchSongPosition(List<Song> songList, String title) {
		for(int i=0; i<songList.size();i++) {
			Song song = songList.get(i);
			if(song.getTitle().equalsIgnoreCase(title)) {
				return i;
			}
		}
		return -1;
	}
	

	//----------------------------------Playlists-------------------------------------------------------
	
	public static Playlist searchPlaylist(ArrayList<Playlist> playlists, String name) {
		for(int i=0; i<playlists.size();i++) {
			Playlist playlist = playlists.get(i);
			if(playlist.getName().equalsIgnoreCase(name)) {
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
		ArrayList<String> result = new ArrayList<String>();
		List<Song> songs = Library.getSongs();
		String item = null;
		
		for (int i=0; i< songs.size(); i++) {
			
			switch (choice) {
				case "composer":
					item = songs.get(i).getComposer();
					break;
				case "artist":
					item = songs.get(i).getArtist();
					break;
				case "genre":
					item = songs.get(i).getGenre();
					break;
				case "album":
					item = songs.get(i).getAlbum();
					break;
				case "year":
					item = String.valueOf(songs.get(i).getYear());
					break;
				default: {
					System.out.println("Wrong choice!!!");
				}
			}
			
			if (Searcher.searchStringInList(result, item)<0) {
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
	
	public static LinkedList<Song> searchSongByProperty(List<Song> songs, String specificType, String searchPattern) {
		
		//convert to lowecase
		specificType = specificType.toLowerCase();
		LinkedList<Song> searchSongs = new LinkedList<Song>();
		
		
		for (int i=0; i<songs.size(); i++) {
			boolean matched = false;
			Song song = songs.get(i);
			switch (specificType) {
				case "title":
					if(song.getTitle().equalsIgnoreCase(searchPattern)) {
						matched = true;
					}
					break;
				case "composer":
					if(song.getComposer().equalsIgnoreCase(searchPattern)) {
						matched = true;
					}
					break;
				case "artist":
					if(song.getArtist().equalsIgnoreCase(searchPattern)) {
						matched = true;
					}
					break;
				case "genre":
					if(song.getGenre().equalsIgnoreCase(searchPattern)) {
						matched = true;
					}
					break;
				case "album":
					if(song.getAlbum().equalsIgnoreCase(searchPattern)) {
						matched = true;
					}
					break;
				case "year":
					if(song.getYear()==Integer.valueOf(searchPattern)) {
						matched = true;
					}
					break;
				case "suggested":
					if(song.isSuggest()) {
						matched = true;
					}
					break;
				default: {
					System.out.println("Wrong searching code!!!");
				}
			}
			
			if(matched==true) {
				//Add song which was found to a new linked list
				Adder.addSongToLinkedList(searchSongs, song);
			}
			
		}
		return searchSongs;
	}
	
	
	
}
