import java.util.*;

public class Adder {

	// Add songs to playlist in order
	public static int addSongsToPlaylist(Playlist playlist, List<Song> songs) {
		int count = 0;
		for (Song song: songs){
			if (addSongToPlaylist(playlist, song)) {
				count++;
			}
		}
		return count;
	}

	// Add song to playlist in order
	public static boolean addSongToPlaylist(Playlist playlist, Song song) {
		ListIterator<Song> songListIterator = playlist.getSongs().listIterator();
		
		while(songListIterator.hasNext()) {
			int comparison = songListIterator.next().getPath().compareToIgnoreCase(song.getPath());
			if(comparison == 0) {
				//equal, do not add
//				System.out.println("The song " + songListIterator.next().getTitle() + "is already exist in the list.");
				return false;
			} else if(comparison > 0) {
				//Larger --> New song should appear before this one
				songListIterator.previous();
				songListIterator.add(song);
				return true;
			} else {
				//Smaller --> Move on to the next Song
			}
		}
		songListIterator.add(song);
		return true;
	}
	





	
	
	
	
	
	
	
	
	
	
	
	
	
}
