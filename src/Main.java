import java.time.Duration;
import java.math.*;
import java.util.*;

public class Main {
	
//	private static ArrayList<Album> albumList = new ArrayList<Album>();
	
	
	
	public static void main(String[] args) {
		Date date = new Date();
		
		Song song1 = new Song("My love", 180, "westLife", "westLife", "Road to the West", "POP", 2005);
		Song song2 = new Song("Uptown girl", 195, "westLife", "westLife", "Road to the West", "POP", 2005);
		Song song3 = new Song("Flying without wings", 265, "westLife123", "westLife", "Road to the West", "POP", 2005);
		Song song4 = new Song("Love 5", 265);
		
		Library.addSong(song1);
		Library.addSong(song2);
		Library.addSong(song3);
		Library.addSong(song4);
		
		
		Playlist myPlaylist = new Playlist("myPlaylist");
		Adder.addSongToPlaylist(myPlaylist, song1);
		Adder.addSongToPlaylist(myPlaylist, song2);
		Adder.addSongToPlaylist(myPlaylist, song3);
		Adder.addSongToPlaylist(myPlaylist, song4);
		
//		
//		Displayer.displayByProperty("composer", true);
//		Displayer.displayByProperty("genre", true);

		Displayer.displayByProperty("composer", true);
//		Displayer.displayGenres(genres, isFullInfo);
		
		
		
		
		
//		Library.getSongList();
		
		
		
//		ArrayList<Song> songList = new ArrayList<Song>();
//
//		

//		
//		Album album1 = new Album("Road to the West", westLife, date, songList);
//		album1.addSong(song1);
//		album1.addSong(song2);
//		album1.addSong(song3);
//		
//		Album album2 = new Album("Road to the West", westLife, date, songList);
//		album2.addSong(song1);
//		album2.addSong(song2);
//		album2.addSong(song3);
//		album2.addSong(song3);
//		
//		albumList.add(album1);
//		albumList.add(album2);
//		
//		for (int i=0; i<albumList.size(); i++) {
//			Album album = albumList.get(i);
//			album.listAllSong(true);
//		}
	}
}
