import java.util.*;

public class Adder {
	
	public static boolean addSongToPlaylist(Playlist playlist, Song song) {
		ListIterator<Song> songListIterator = playlist.getSongs().listIterator();
		
		while(songListIterator.hasNext()) {
			int comparison = songListIterator.next().getTitle().compareToIgnoreCase(song.getTitle());
			if(comparison == 0) {
				//equal, do not add
				System.out.println("The song " + songListIterator.next().getTitle() + "is already exist in the list.");
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
	
	public static boolean addSongToLinkedList(LinkedList<Song> songs, Song song) {
		ListIterator<Song> songListIterator = songs.listIterator();
		
		while(songListIterator.hasNext()) {
			int comparison = songListIterator.next().getTitle().compareToIgnoreCase(song.getTitle());
			if(comparison == 0) {
				//equal, do not add
				System.out.println("The song " + songListIterator.next().getTitle() + "is already exist in the list.");
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
	
	
//	public static boolean addSongTo(){
//		return false;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
